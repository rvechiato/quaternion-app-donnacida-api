package br.com.vechiato.donnacida_api.mapper;

import br.com.vechiato.donnacida_api.dto.SchedulerDto;
import br.com.vechiato.donnacida_api.entity.Scheduler;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-22T19:49:34-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
public class SchedulerMapperImpl implements SchedulerMapper {

    @Override
    public Scheduler toEntity(SchedulerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Scheduler.SchedulerBuilder scheduler = Scheduler.builder();

        scheduler.tenant( dto.tenant() );
        scheduler.caregiverId( dto.caregiverId() );
        scheduler.startAt( dto.startAt() );
        scheduler.endAt( dto.endAt() );
        scheduler.notes( dto.notes() );

        return scheduler.build();
    }

    @Override
    public SchedulerDto toDto(Scheduler entity) {
        if ( entity == null ) {
            return null;
        }

        String tenant = null;
        String caregiverId = null;
        LocalDate startAt = null;
        LocalDate endAt = null;
        String notes = null;

        tenant = entity.getTenant();
        caregiverId = entity.getCaregiverId();
        startAt = entity.getStartAt();
        endAt = entity.getEndAt();
        notes = entity.getNotes();

        SchedulerDto schedulerDto = new SchedulerDto( tenant, caregiverId, startAt, endAt, notes );

        return schedulerDto;
    }
}
