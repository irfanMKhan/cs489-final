package com.secured.apsd_final.service;

import com.secured.apsd_final.model.Satellite;
import com.secured.apsd_final.model.dto.SatelliteDTO;
import org.apache.coyote.BadRequestException;

public interface SatelliteService {

    Satellite saveSatellite(SatelliteDTO satelliteDTO);

    Satellite getSatellite(Long id);

    Satellite updateSatellite(Long id, SatelliteDTO satelliteDTO) throws BadRequestException;

    void deleteSatellite(Long id);

}
