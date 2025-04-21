package com.secured.apsd_final.service;

import com.secured.apsd_final.model.Satellite;
import com.secured.apsd_final.model.dto.SatelliteDTO;
import org.apache.coyote.BadRequestException;

public interface SatelliteService {

    Satellite saveSatellite(SatelliteDTO satelliteDTO);

    Satellite getSatellite(Long id);

    Satellite updateSatellite(SatelliteDTO satelliteDTO) throws BadRequestException;

    Satellite deleteSatellite(SatelliteDTO satelliteDTO);

}
