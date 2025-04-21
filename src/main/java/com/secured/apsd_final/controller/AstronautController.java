package com.secured.apsd_final.controller;

import com.secured.apsd_final.service.AstronautService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AstronautController {

    private final AstronautService astronautService;

    public AstronautController(AstronautService astronautService) {
        this.astronautService = astronautService;
    }
}
