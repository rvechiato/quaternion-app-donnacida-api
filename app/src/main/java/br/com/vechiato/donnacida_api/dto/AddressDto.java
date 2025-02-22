package br.com.vechiato.donnacida_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddressDto(
        String address,
        String number,
        String neighborhood,
        @JsonProperty("zip_code")
        String zipCode,
        String city,
        String state,
        String country
) {
}
