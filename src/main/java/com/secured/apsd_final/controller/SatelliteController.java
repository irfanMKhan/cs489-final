package com.secured.apsd_final.controller;

import com.secured.apsd_final.model.Satellite;
import com.secured.apsd_final.model.dto.SatelliteDTO;
import com.secured.apsd_final.service.SatelliteService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/satellites")
public class SatelliteController {
    private final SatelliteService satelliteService;

    public SatelliteController(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;
    }

    @PostMapping
    public ResponseEntity<Satellite> create(@Valid @RequestBody SatelliteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(satelliteService.saveSatellite(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Satellite> update(@PathVariable Long id, @Valid @RequestBody SatelliteDTO dto) throws BadRequestException {
        return ResponseEntity.ok(satelliteService.updateSatellite(id, dto));
    }

//    @GetMapping
//    public ResponseEntity<List<Satellite>> getAll() {
//        return ResponseEntity.ok(satelliteService.getSatellite());
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        satelliteService.deleteSatellite(id);
        return ResponseEntity.noContent().build();
    }


}
