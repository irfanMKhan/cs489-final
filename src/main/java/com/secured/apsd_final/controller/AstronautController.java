package com.secured.apsd_final.controller;

import com.secured.apsd_final.model.Astronauts;
import com.secured.apsd_final.model.dto.AstronautDTO;
import com.secured.apsd_final.service.AstronautService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/astronaut")
public class AstronautController {

    private final AstronautService astronautService;

    public AstronautController(AstronautService astronautService) {
        this.astronautService = astronautService;
    }

    @PostMapping("")
    public ResponseEntity<Astronauts> create(@Valid @RequestBody AstronautDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(astronautService.saveAstronaut(dto));
    }

    @GetMapping("")
    public ResponseEntity<List<Astronauts>> getAstronautsSorted(
            @RequestParam(defaultValue = "experienceYears") String sort,
            @RequestParam(defaultValue = "asc") String order) {

        List<Astronauts> result = astronautService.getAstronaut(sort, order);
        return ResponseEntity.ok(result);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        astronautService.deleteAstronaut(id);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
//    }

}
