package com.secured.apsd_final.service;

import com.secured.apsd_final.model.Astronauts;
import com.secured.apsd_final.model.dto.AstronautDTO;

public interface AstronautService {

    Astronauts saveAstronaut(AstronautDTO astronautDTO);

    Astronauts getAstronaut();

    Astronauts updateAstronaut(AstronautDTO astronautDTO);

    Astronauts deleteAstronaut(AstronautDTO astronautDTO);


}
