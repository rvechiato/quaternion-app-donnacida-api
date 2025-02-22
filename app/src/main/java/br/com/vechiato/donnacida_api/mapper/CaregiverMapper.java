package br.com.vechiato.donnacida_api.mapper;

import br.com.vechiato.donnacida_api.dto.CaregiverDto;
import br.com.vechiato.donnacida_api.entity.Caregiver;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CaregiverMapper {
    CaregiverMapper INSTANCE = Mappers.getMapper(CaregiverMapper.class);

    Caregiver toEntity(CaregiverDto dto);
    CaregiverDto toDto(Caregiver entity);
}
