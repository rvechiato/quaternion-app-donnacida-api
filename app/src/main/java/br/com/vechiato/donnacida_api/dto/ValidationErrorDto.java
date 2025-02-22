package br.com.vechiato.donnacida_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.util.Map;

public record ValidationErrorDto(
        String description,
        Map<String,String> fields,
        @JsonProperty("http_status_code")
        HttpStatus httpStatusCode) {
}
