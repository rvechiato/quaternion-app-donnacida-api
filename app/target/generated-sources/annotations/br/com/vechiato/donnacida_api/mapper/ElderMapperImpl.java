package br.com.vechiato.donnacida_api.mapper;

import br.com.vechiato.donnacida_api.dto.ElderDto;
import br.com.vechiato.donnacida_api.entity.Elder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-22T19:49:34-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ElderMapperImpl implements ElderMapper {

    @Override
    public Elder toEntity(ElderDto dto) {
        if ( dto == null ) {
            return null;
        }

        Elder.ElderBuilder elder = Elder.builder();

        elder.elderId( dto.elderId() );
        elder.name( dto.name() );
        elder.email( dto.email() );
        elder.cellphone( dto.cellphone() );

        return elder.build();
    }

    @Override
    public ElderDto toDto(Elder entity) {
        if ( entity == null ) {
            return null;
        }

        String elderId = null;
        String name = null;
        String email = null;
        String cellphone = null;

        elderId = entity.getElderId();
        name = entity.getName();
        email = entity.getEmail();
        cellphone = entity.getCellphone();

        ElderDto elderDto = new ElderDto( elderId, name, email, cellphone );

        return elderDto;
    }
}
