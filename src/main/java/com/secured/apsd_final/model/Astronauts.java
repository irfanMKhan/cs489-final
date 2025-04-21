package com.secured.apsd_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Astronauts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters")
    @Column(nullable = false)
    private String lastName;

    @Min(value = 0, message = "Experience year must be at least 0")
    @Max(value = 50, message = "Experience year must be at most 50")
    @Column(nullable = false)
    private Integer experienceYear;

    @ManyToMany
    @JoinTable(
            name = "astronaut_satellite",
            joinColumns = @JoinColumn(name = "astronaut_id"),
            inverseJoinColumns = @JoinColumn(name = "satellite_id")
    )
    private Set<Satellite> satellites = new HashSet<>();
}
