package br.com.vechiato.donnacida_api.mapper;

import br.com.vechiato.donnacida_api.dto.SchedulerDto;
import br.com.vechiato.donnacida_api.entity.Scheduler;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SchedulerMapper {
    SchedulerMapper INSTANCE = Mappers.getMapper(SchedulerMapper.class);

    Scheduler toEntity(SchedulerDto dto);
    SchedulerDto toDto(Scheduler entity);
}
