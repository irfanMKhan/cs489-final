package com.secured.apsd_final.service.impl;

import com.secured.apsd_final.model.Astronauts;
import com.secured.apsd_final.model.Satellite;
import com.secured.apsd_final.model.dto.AstronautDTO;
import com.secured.apsd_final.repository.AstronautRepository;
import com.secured.apsd_final.repository.SatelliteRepository;
import com.secured.apsd_final.service.AstronautService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AstronautServiceImpl implements AstronautService {

    private final AstronautRepository astronautRepository;
    private final SatelliteRepository satelliteRepository;

    public AstronautServiceImpl(AstronautRepository astronautRepository, SatelliteRepository satelliteRepository) {
        this.astronautRepository = astronautRepository;
        this.satelliteRepository = satelliteRepository;
    }

    @Override
    public Astronauts saveAstronaut(AstronautDTO astronautDTO) {
        Set<Satellite> satellites = new HashSet<>(satelliteRepository.findAllById(astronautDTO.getSatelliteIds()));

        ModelMapper mapper = new ModelMapper();
        Astronauts astronaut = new Astronauts();
        mapper.map(astronautDTO, astronaut);

        astronautRepository.save(astronaut);

        return null;
    }

    @Override
    public Astronauts updateAstronaut(AstronautDTO astronautDTO) {
        return null;
    }

    @Override
    public Astronauts deleteAstronaut(AstronautDTO astronautDTO) {
        return null;
    }

    @Override
    public Astronauts getAstronaut() {
        return null;
    }
}
