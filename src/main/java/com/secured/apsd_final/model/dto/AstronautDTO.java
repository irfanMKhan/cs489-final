package com.secured.apsd_final.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class AstronautDTO {

    private Long id;

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters")
    private String lastName;

    @Min(value = 0, message = "Experience year must be at least 0")
    @Max(value = 50, message = "Experience year must be at most 50")
    private Integer experienceYear;

    private Set<SatelliteDTO> satellites = new HashSet<>();
}
