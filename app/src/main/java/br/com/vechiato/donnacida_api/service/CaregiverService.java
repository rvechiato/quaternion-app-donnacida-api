package br.com.vechiato.donnacida_api.service;

import br.com.vechiato.donnacida_api.application.exceptions.TenantNotFoundException;
import br.com.vechiato.donnacida_api.dto.CaregiverDto;
import br.com.vechiato.donnacida_api.entity.Caregiver;
import br.com.vechiato.donnacida_api.mapper.CaregiverMapper;
import br.com.vechiato.donnacida_api.repository.impl.CaregiverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaregiverService {

    private final CaregiverRepository caregiverRepository;
    private final ElderService elderService;

    public CaregiverService(CaregiverRepository caregiverRepository, ElderService elderService) {
        this.caregiverRepository = caregiverRepository;
        this.elderService = elderService;
    }

    public CaregiverDto save(String tenant, Caregiver entity){
        if(!existTenant(tenant)){
            throw new TenantNotFoundException("tenant not found: "+ tenant);
        }

        entity.setTenant(tenant);
        return CaregiverMapper.INSTANCE.toDto(caregiverRepository.save(entity)
                .orElseThrow(()-> new IllegalStateException("Erro ao salvar o cuidador")
        ));
    }

   public List<CaregiverDto> getCaregiversByTenant(String tenant){
        return caregiverRepository.findBytenant(tenant)
                .stream()
                .map(CaregiverMapper.INSTANCE::toDto)
                .toList();
   }

   private boolean existTenant(String tenant){
       return elderService.getElderById(tenant).isPresent();
   }

}

