package com.secured.apsd_final.service.impl;

import com.secured.apsd_final.exception.AstronautNotFoundException;
import com.secured.apsd_final.model.Astronauts;
import com.secured.apsd_final.model.Satellite;
import com.secured.apsd_final.model.dto.AstronautDTO;
import com.secured.apsd_final.repository.AstronautRepository;
import com.secured.apsd_final.repository.SatelliteRepository;
import com.secured.apsd_final.service.AstronautService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
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
        Set<Satellite> satellites = new HashSet<>();
        for (Long id : astronautDTO.getSatelliteIds()) {
            Satellite sat = satelliteRepository.findById(id)
                    .orElseThrow(() -> new AstronautNotFoundException("Satellite not found"));
            satellites.add(sat);
        }

        ModelMapper mapper = new ModelMapper();
        Astronauts astronaut = new Astronauts();
        mapper.map(astronautDTO, astronaut);
        astronaut.setSatellites(satellites);

        astronaut = astronautRepository.save(astronaut);

        return astronaut;
    }

    @Override
    public Astronauts updateAstronaut(AstronautDTO astronautDTO) {
        return null;
    }

    @Override
    public void deleteAstronaut(Long id) {
        Astronauts astronauts = astronautRepository.findById(id)
                .orElseThrow(() -> new AstronautNotFoundException("Astronaut not found"));
        astronautRepository.delete(astronauts);
    }

    @Override
    public List<Astronauts> getAstronaut(String sort, String order) {
        Sort.Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

        if (sort.equalsIgnoreCase("experienceYears")) {
            sort = "experienceYear";
        }

        return astronautRepository.findAll(Sort.by(direction, sort));
    }
}
