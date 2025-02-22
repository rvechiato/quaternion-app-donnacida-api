package br.com.vechiato.donnacida_api.application.controller;


import br.com.vechiato.donnacida_api.dto.ElderDto;
import br.com.vechiato.donnacida_api.mapper.ElderMapper;
import br.com.vechiato.donnacida_api.service.ElderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/elders")
public class ElderController {

    private final ElderService elderService;

    public ElderController(ElderService elderService) {
        this.elderService = elderService;
    }

    @PostMapping
    public ResponseEntity<ElderDto> save(@RequestBody ElderDto dto){
        return elderService.save(ElderMapper.INSTANCE.toEntity(dto))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/{elderId}")
    public ResponseEntity<ElderDto> getElderById(@PathVariable String elderId){
        return elderService.getElderById(elderId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
