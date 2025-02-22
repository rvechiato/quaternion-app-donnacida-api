package br.com.vechiato.donnacida_api.application.controller;

import br.com.vechiato.donnacida_api.dto.CaregiverDto;
import br.com.vechiato.donnacida_api.mapper.CaregiverMapper;
import br.com.vechiato.donnacida_api.service.CaregiverService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/elders/{elderId}")
public class CaregiverController {

    private static final Logger log = LoggerFactory.getLogger(CaregiverController.class);
    private final CaregiverService caregiverService;

    public CaregiverController(CaregiverService caregiverService) {
        this.caregiverService = caregiverService;
    }

    @PostMapping("/caregivers")
    public ResponseEntity<CaregiverDto> save(@PathVariable String elderId, @Valid @RequestBody CaregiverDto entity){

        log.info("Saving entity Caregiver" + entity.toString());
        return ResponseEntity.ok(caregiverService.save(elderId, CaregiverMapper.INSTANCE.toEntity(entity)));
    }

    @GetMapping("/caregivers")
    public ResponseEntity<List<CaregiverDto>> getCaregivers(@PathVariable String elderId){
        return ResponseEntity.ok(caregiverService.getCaregiversByTenant(elderId));
    }
}
