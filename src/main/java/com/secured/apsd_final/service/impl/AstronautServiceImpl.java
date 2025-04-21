package com.secured.apsd_final.service.impl;

import com.secured.apsd_final.repository.AstronautRepository;
import com.secured.apsd_final.service.AstronautService;
import org.springframework.stereotype.Service;

@Service
public class AstronautServiceImpl implements AstronautService {

    private final AstronautRepository astronautRepository;

    public AstronautServiceImpl(AstronautRepository astronautRepository) {
        this.astronautRepository = astronautRepository;
    }

}
