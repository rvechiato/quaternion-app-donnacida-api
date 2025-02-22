package br.com.vechiato.donnacida_api.dto;

import br.com.vechiato.donnacida_api.utils.anotation.ValidCPF;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CaregiverDto (
    @JsonProperty("caregiver_id")
    String caregiverId,
    @ValidCPF
    String cpf,
    @NotBlank
    String name,
    @NotBlank
    String email,
    @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$",
            message = "The color must be a valid hexadecimal code, such as #FFFFFF or #FFF.")
    String color,
    String thumbnail,
    AddressDto address)
{}
