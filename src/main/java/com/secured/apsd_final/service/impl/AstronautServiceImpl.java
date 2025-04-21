package com.secured.apsd_final.service.impl;

import com.secured.apsd_final.model.Astronauts;
import com.secured.apsd_final.model.dto.AstronautDTO;
import com.secured.apsd_final.repository.AstronautRepository;
import com.secured.apsd_final.service.AstronautService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AstronautServiceImpl implements AstronautService {

    private final AstronautRepository astronautRepository;

    public AstronautServiceImpl(AstronautRepository astronautRepository) {
        this.astronautRepository = astronautRepository;
    }

    @Override
    public Astronauts saveAstronaut(AstronautDTO astronautDTO) {
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
