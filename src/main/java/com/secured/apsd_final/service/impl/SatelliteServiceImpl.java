package com.secured.apsd_final.service.impl;

import com.secured.apsd_final.exception.SatelliteNotFoundException;
import com.secured.apsd_final.model.Satellite;
import com.secured.apsd_final.model.dto.SatelliteDTO;
import com.secured.apsd_final.repository.SatelliteRepository;
import com.secured.apsd_final.service.SatelliteService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class SatelliteServiceImpl implements SatelliteService {
    private final SatelliteRepository satelliteRepository;

    public SatelliteServiceImpl(SatelliteRepository satelliteRepository) {
        this.satelliteRepository = satelliteRepository;
    }

    @Override
    public Satellite saveSatellite(SatelliteDTO satelliteDTO) {
        Satellite sat = new Satellite();
        sat.setName(satelliteDTO.getName());
        sat.setLaunchDate(satelliteDTO.getLaunchDate());
        sat.setOrbitType(satelliteDTO.getOrbitType());
        sat.setDecommissioned(satelliteDTO.getDecommissioned());
        return satelliteRepository.save(sat);
    }

    @Override
    public Satellite getSatellite(Long id) {
        return satelliteRepository.findById(id)
                .orElseThrow(() -> new SatelliteNotFoundException("Satellite not found"));
    }

    @Override
    public Satellite updateSatellite(Long id, SatelliteDTO satelliteDTO) throws BadRequestException {
        Satellite sat = satelliteRepository.findById(id)
                .orElseThrow(() -> new SatelliteNotFoundException("Satellite not found"));
        if (sat.getDecommissioned()) {
            throw new BadRequestException("Satellite is decommissioned and cannot be updated.");
        }
        sat.setName(satelliteDTO.getName());
        sat.setLaunchDate(satelliteDTO.getLaunchDate());
        sat.setOrbitType(satelliteDTO.getOrbitType());
        return satelliteRepository.save(sat);
    }

    @Override
    public void deleteSatellite(Long id) {
        Satellite satellite = satelliteRepository.findById(id)
                .orElseThrow(() -> new SatelliteNotFoundException("Satellite not found"));
        satelliteRepository.delete(satellite);
    }
}
