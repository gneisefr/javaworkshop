package com.pentasys.ws.java4web.business.mapper;


import java.util.List;

import com.pentasys.ws.java4web.domain.BusinessObject;
import com.pentasys.ws.java4web.persistence.model.BaseEntity;

/**
 * The Interface EntityBOMapper.
 *
 * @param <B> the generic type
 * @param <E> the element type
 */
public interface EntityBOMapper<B extends BusinessObject, E extends BaseEntity> {

  /**
   * Creates the bo from entity.
   *
   * @param entity the entity
   * @return the b
 * @throws IllegalAccessException 
 * @throws InstantiationException 
   */
  B createBoFromEntity(E entity);

  /**
   * Creates the entity form bo.
   *
   * @param bo the bo
   * @return the e
 * @throws IllegalAccessException 
 * @throws InstantiationException 
   */
  E createEntityFromBo(B bo);

  /**
   * Creates the bos from entities.
   *
   * @param entities the entities
   * @return the list
 * @throws IllegalAccessException 
 * @throws InstantiationException 
   */
  List<B> createBosFromEntities(List<? extends E> entities);

  /**
   * Creates the entities form bos.
   *
   * @param bos the bos
   * @return the list
 * @throws IllegalAccessException 
 * @throws InstantiationException 
   */
  List<E> createEntitiesFormBos(List<? extends B> bos);

  /**
   * Map bo.
   *
   * @param bo the bo
   * @param entity the entity
   */
  void mapBo(B bo, E entity);

  /**
   * Map entity.
   *
   * @param entity the entity
   * @param bo the bo
   */
  void mapEntity(E entity, B bo);

  /**
   * Gets the manual mapped attributes.
   *
   * @return the manual mapped attributes
   */
  String[] getManualMappedAttributes();

  /**
   * Map bo manual.
   *
   * @param entity the entity
   * @param bo the bo
   */
  void mapBoManual(E entity, B bo);

  /**
   * Map entity manual.
   *
   * @param entity the entity
   * @param bo the bo
   */
  void mapEntityManual(E entity, B bo);
}
