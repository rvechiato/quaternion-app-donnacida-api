package br.com.vechiato.donnacida_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record SchedulerDto(
         String tenant,
         @JsonProperty("caregiver_id")
         String caregiverId,
         @JsonFormat(pattern = "yyyy-MM-dd")
         @JsonProperty("start_at")
         LocalDate startAt,
         @JsonFormat(pattern = "yyyy-MM-dd")
         @JsonProperty("end_at")
         LocalDate endAt,
         String notes
) {
}
