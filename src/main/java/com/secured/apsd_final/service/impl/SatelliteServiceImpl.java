package com.secured.apsd_final.service.impl;

import com.secured.apsd_final.repository.SatelliteRepository;
import com.secured.apsd_final.service.SatelliteService;
import org.springframework.stereotype.Service;

@Service
public class SatelliteServiceImpl implements SatelliteService {
    private final SatelliteRepository satelliteRepository;

    public SatelliteServiceImpl(SatelliteRepository satelliteRepository) {
        this.satelliteRepository = satelliteRepository;
    }
    
}
