package br.com.vechiato.donnacida_api.service;

import br.com.vechiato.donnacida_api.dto.SchedulerDto;
import br.com.vechiato.donnacida_api.entity.Scheduler;
import br.com.vechiato.donnacida_api.mapper.SchedulerMapper;
import br.com.vechiato.donnacida_api.repository.impl.SchedulerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleService {

    private final SchedulerRepository schedulerRepository;

    public ScheduleService(SchedulerRepository schedulerRepository) {
        this.schedulerRepository = schedulerRepository;
    }

    public Optional<SchedulerDto> save(String tenant, Scheduler entity){
        entity.setTenant(tenant);
        var result = schedulerRepository.save(entity);
        return result.map(SchedulerMapper.INSTANCE::toDto);
    }
}
