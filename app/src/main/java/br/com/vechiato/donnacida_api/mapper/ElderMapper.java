package br.com.vechiato.donnacida_api.mapper;

import br.com.vechiato.donnacida_api.entity.Elder;
import br.com.vechiato.donnacida_api.dto.ElderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ElderMapper {

    ElderMapper INSTANCE = Mappers.getMapper( ElderMapper.class );

    Elder toEntity(ElderDto dto);
    ElderDto toDto(Elder entity);
}
