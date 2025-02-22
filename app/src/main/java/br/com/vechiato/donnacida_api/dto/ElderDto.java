package br.com.vechiato.donnacida_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import static br.com.vechiato.donnacida_api.utils.constantes.MessageConstantes.*;
import static br.com.vechiato.donnacida_api.utils.constantes.ValidateConstantes.VALIDATE_EMAIL_REGEX;

public record ElderDto(
        @JsonProperty("elder_id")
        String elderId,

        @NotBlank(message = NOME_NOT_NULL_MESSAGE)
        String name,

        @NotBlank(message = EMAIL_NOT_NULL_MESSAGE)
        @Pattern(
                regexp = VALIDATE_EMAIL_REGEX,
                message = EMAIL_INVALID_MESSAGE
        )
        String email,

        @JsonProperty("cell_phone")
        @Pattern(regexp = "\\d{9,15}", message = CELLPHONE_INVALID_MESSAGE)
        String cellphone
) {}
