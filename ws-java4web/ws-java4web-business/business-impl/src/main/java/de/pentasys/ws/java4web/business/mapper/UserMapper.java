package de.pentasys.ws.java4web.business.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import de.pentasys.ws.java4web.domain.User;
import de.pentasys.ws.java4web.persistence.model.UserEntity;

/**
 * @author radanmar
 */
@Mapper(componentModel="spring")
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

	@Mappings({
			@Mapping(target = "group", ignore = true),
			@Mapping(source = "entity.name", target = "name"),
			@Mapping(source = "entity.firstname", target = "firstname"),
			@Mapping(source = "entity.password", target = "password"),
			@Mapping(source = "entity.email", target = "email"),
			@Mapping(source = "entity.active", target = "active")
	})
	
	User toUserBO(UserEntity entity);
	
	UserEntity toUserEntity(User bo);

}
