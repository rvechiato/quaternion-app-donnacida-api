package br.com.vechiato.donnacida_api.application.controller;

import br.com.vechiato.donnacida_api.dto.SchedulerDto;
import br.com.vechiato.donnacida_api.mapper.SchedulerMapper;
import br.com.vechiato.donnacida_api.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/elders/{elderId}")
public class SchedulerController {

    private final ScheduleService scheduleService;

    public SchedulerController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedules")
    public ResponseEntity<SchedulerDto> save(@PathVariable String elderId,
                                             @RequestBody SchedulerDto body){

        return scheduleService.save(elderId, SchedulerMapper.INSTANCE.toEntity(body))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
