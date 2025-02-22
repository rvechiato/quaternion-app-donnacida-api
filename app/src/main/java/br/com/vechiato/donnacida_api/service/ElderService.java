package br.com.vechiato.donnacida_api.service;

import br.com.vechiato.donnacida_api.entity.Elder;
import br.com.vechiato.donnacida_api.dto.ElderDto;
import br.com.vechiato.donnacida_api.mapper.ElderMapper;
import br.com.vechiato.donnacida_api.repository.impl.ElderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ElderService {

    private final ElderRepository elderRepository;

    public ElderService(ElderRepository elderRepository) {
        this.elderRepository = elderRepository;
    }

    public Optional<ElderDto> save(Elder entity){
        var result = elderRepository.save(entity);
        return result.map(ElderMapper.INSTANCE::toDto);
    }

    public Optional<ElderDto> getElderById(String eldeId){
        var result = elderRepository.findById(eldeId);
        return result.map(ElderMapper.INSTANCE::toDto);
    }
}
