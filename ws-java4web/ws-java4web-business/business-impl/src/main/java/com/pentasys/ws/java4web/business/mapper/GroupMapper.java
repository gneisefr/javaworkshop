package com.pentasys.ws.java4web.business.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.pentasys.ws.java4web.domain.Group;
import com.pentasys.ws.java4web.persistence.model.GroupEntity;

/**
 * @author radanmar
 */
@Mapper(componentModel="spring")
@DecoratedWith(GroupMapperDecorator.class)
public interface GroupMapper {

	GroupMapper MAPPER = Mappers.getMapper(GroupMapper.class);

	@Mappings({ 
		@Mapping(target = "users", ignore = true),
		@Mapping(source = "entity.name", target = "name")
	})
	Group toGroupBO(GroupEntity entity);
	
	@Mappings({ 
		@Mapping(target = "users", ignore = true),
		@Mapping(source = "bo.name", target = "name")
	})
	GroupEntity toGroupEntity(Group bo);

}
