/*
 * AbstractEntityBOMapperImpl.java
 *
 * (c) Copyright AUDI AG, 2015
 * All Rights reserved.
 *
 * AUDI AG
 * 85057 Ingolstadt
 * Germany
 */

package de.pentasys.ws.javaframeworks.business.mapper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.core.GenericTypeResolver;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import de.pentasys.ws.javaframeworks.common.ErrorCode;
import de.pentasys.ws.javaframeworks.common.exception.ServiceException;
import de.pentasys.ws.javaframeworks.domain.BusinessObject;
import de.pentasys.ws.javaframeworks.persistence.BaseEntity;

public abstract class AbstractEntityBOMapperImpl<B extends BusinessObject, E extends BaseEntity>
		implements EntityBOMapper<B, E> {

	/** The classes. */
	private final Class<?>[] classes = GenericTypeResolver.resolveTypeArguments(this.getClass(),
			AbstractEntityBOMapperImpl.class);

	/** The bo class. */
	@SuppressWarnings("unchecked")
	private final Class<B> boClass = (Class<B>) this.classes[0];

	/** The entity class. */
	@SuppressWarnings("unchecked")
	private final Class<E> entityClass = (Class<E>) this.classes[1];

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.audi.elvis.otdb.business.mapper.EntityBOMapper#mapEntity(E)
	 */
	@Override
	public B createBoFromEntity(E entity) {
		B bo = null;
		if (entity != null) {
			bo = this.getInstanceOfBO();
			this.mapEntity(entity, bo);
		}
		return bo;
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.audi.elvis.otdb.business.mapper.EntityBOMapper#mapEntities(java.util.
	 * List)
	 */
	@Override
	public List<B> createBosFromEntities(List<? extends E> entities) {
		final List<B> result = new ArrayList<B>();
		if (entities != null) {
			for (final E entity : entities) {
				result.add(this.createBoFromEntity(entity));
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.audi.elvis.otdb.business.mapper.EntityBOMapper#mapBos(java.util.List)
	 */
	@Override
	public List<E> createEntitiesFormBos(List<? extends B> bos) {
		final List<E> result = new ArrayList<>();
		for (final B bo : bos) {
			result.add(this.createEntityFromBo(bo));
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.audi.elvis.otdb.business.mapper.EntityBOMapper#createEntityFromBo(com
	 * .audi.elvis.otdb.domain.BO)
	 */
	@Override
	public E createEntityFromBo(B bo) {
		final E entity = this.getInstanceOfEntity();
		if (bo != null) {
			this.mapBo(bo, entity);
		}
		return entity;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.audi.elvis.otdb.business.mapper.EntityBOMapper#
	 * getManualMappedAttributes()
	 */
	@Override
	public String[] getManualMappedAttributes() {
		return new String[] {};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.audi.elvis.otdb.business.mapper.EntityBOMapper#mapBo(com.audi.elvis.
	 * otdb.domain.BO, com.audi.elvis.otdb.data.entity.BaseEntity)
	 */
	@Override
	public void mapBo(B bo, E entity) {
		final List<String> doNotMapAttributs = new ArrayList<String>();
		Collections.addAll(doNotMapAttributs, this.getManualMappedAttributes());
		Collections.addAll(doNotMapAttributs, "modified", "modifiedBy", "created", "createdBy");
		BeanUtils.copyProperties(bo, entity, doNotMapAttributs.toArray(new String[] {}));
		this.mapBoManual(entity, bo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.audi.elvis.otdb.business.mapper.EntityBOMapper#mapBoManual
	 * (com.audi.elvis.otdb.data.entity.BaseEntity,
	 * com.audi.elvis.otdb.domain.BO)
	 */
	@Override
	public void mapBoManual(E entity, B bo) {
		// default behavior: do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.audi.elvis.otdb.business.mapper.EntityBOMapper#mapEntity(com.audi.
	 * elvis.otdb.data.entity.BaseEntity, com.audi.elvis.otdb.domain.BO)
	 */
	@Override
	public void mapEntity(final E entity, final B bo) {
		BeanUtils.copyProperties(entity, bo, this.getManualMappedAttributes());
		this.mapEntityManual(entity, bo);
		this.convertJavaUtilDate(bo);
		if (TransactionSynchronizationManager.isSynchronizationActive()) {
			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
				@Override
				public void afterCommit() {
				}
			});
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.audi.elvis.otdb.business.mapper.EntityBOMapper#mapEntityManual
	 * (com.audi.elvis.otdb.data.entity.BaseEntity,
	 * com.audi.elvis.otdb.domain.BO)
	 */
	@Override
	public void mapEntityManual(E entity, B bo) {
		// default behavior: do nothing
	}

	/**
	 * convert the java.sql.Date and jave.sql.Timestamps to java.util.Date
	 * 
	 * @param bo
	 *            the bo to convert the dates
	 */
	private void convertJavaUtilDate(B bo) {
		final PropertyDescriptor[] propertyDescs = BeanUtils.getPropertyDescriptors(bo.getClass());
		for (final PropertyDescriptor desc : propertyDescs) {
			if (desc.getPropertyType().isAssignableFrom(Date.class)) {
				try {
					final Date date = (Date) desc.getReadMethod().invoke(bo, (Object[]) null);
					Date javaUtilDate = null;
					if (date != null) {
						javaUtilDate = new Date(date.getTime());
					}
					desc.getWriteMethod().invoke(bo, new Object[] { javaUtilDate });

				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// do nothing
				}
			}
		}
	}

	/**
	 * Gets the instance of bo.
	 *
	 * @return the instance of bo
	 */
	protected B getInstanceOfBO() {

		try {
			return this.boClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new ServiceException(ErrorCode.UNEXPECTED_ERROR, e);
		}

	}

	/**
	 * Gets the instance of entity.
	 *
	 * @return the instance of entity
	 */
	protected E getInstanceOfEntity() {
		try {
			return this.entityClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new ServiceException(ErrorCode.UNEXPECTED_ERROR, e);
		}
	}

}
