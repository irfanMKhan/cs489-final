package com.secured.apsd_final.model.dto;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class SatelliteDTO {

    private Long id;

    private String name;

    @Past(message = "Launch date must be in the past")
    private LocalDate launchDate;

    @Pattern(regexp = "LEO|MEO|GEO", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Orbit type must be one of: LEO, MEO, GEO")
    private String orbitType;

    private Boolean decommissioned;

    private Set<AstronautDTO> astronautDTO = new HashSet<>();
}
