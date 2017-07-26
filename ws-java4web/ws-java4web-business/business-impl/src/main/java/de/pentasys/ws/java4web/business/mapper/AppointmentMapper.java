package de.pentasys.ws.java4web.business.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import de.pentasys.ws.java4web.domain.Appointment;
import de.pentasys.ws.java4web.persistence.model.AppointmentEntity;

/**
 * @author radanmar
 */
@Mapper(componentModel="spring")
@DecoratedWith(UserMapperDecorator.class)
public interface AppointmentMapper {

	AppointmentMapper MAPPER = Mappers.getMapper(AppointmentMapper.class);

	@Mappings({
			@Mapping(target = "mandatoryUsers", ignore = true),
			@Mapping(source = "entity.startTime", target = "startTime"),
			@Mapping(source = "entity.endTime", target = "endTime"),
			@Mapping(source = "entity.location", target = "location"),
			@Mapping(source = "entity.purpose", target = "purpose")
	})
	
	Appointment toAppointment(AppointmentEntity entity);

}
