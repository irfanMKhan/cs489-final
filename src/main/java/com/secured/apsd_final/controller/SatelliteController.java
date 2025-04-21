package com.secured.apsd_final.controller;

import com.secured.apsd_final.service.SatelliteService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SatelliteController {
    private final SatelliteService satelliteService;

    public SatelliteController(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;
    }


}
