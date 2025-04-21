package com.secured.apsd_final.service;

import com.secured.apsd_final.model.Astronauts;
import com.secured.apsd_final.model.dto.AstronautDTO;

import java.util.List;

public interface AstronautService {

    Astronauts saveAstronaut(AstronautDTO astronautDTO);

    List<Astronauts> getAstronaut(String sort,String order);

    Astronauts updateAstronaut(AstronautDTO astronautDTO);

    void deleteAstronaut(Long id);


}
