package com.secured.apsd_final.service.impl;

import com.secured.apsd_final.model.Satellite;
import com.secured.apsd_final.model.dto.SatelliteDTO;
import com.secured.apsd_final.repository.SatelliteRepository;
import com.secured.apsd_final.service.SatelliteService;
import org.springframework.stereotype.Service;

@Service
public class SatelliteServiceImpl implements SatelliteService {
    private final SatelliteRepository satelliteRepository;

    public SatelliteServiceImpl(SatelliteRepository satelliteRepository) {
        this.satelliteRepository = satelliteRepository;
    }

    @Override
    public Satellite saveSatellite(SatelliteDTO satelliteDTO) {
        return null;
    }

    @Override
    public Satellite getSatellite() {
        return null;
    }

    @Override
    public Satellite updateSatellite(SatelliteDTO satelliteDTO) {
        return null;
    }

    @Override
    public Satellite deleteSatellite(SatelliteDTO satelliteDTO) {
        return null;
    }
}
