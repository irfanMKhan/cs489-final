package com.secured.apsd_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Satellite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Past(message = "Launch date must be in the past")
    private LocalDate launchDate;

    @Pattern(regexp = "LEO|MEO|GEO", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Orbit type must be one of: LEO, MEO, GEO")
    private String orbitType;

    @Column(columnDefinition = "boolean default true")
    private Boolean decommissioned;

    @ManyToMany(mappedBy = "satellites")
    private Set<Astronauts> astronauts = new HashSet<>();
}
