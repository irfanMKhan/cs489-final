package com.secured.apsd_final.service;

import com.secured.apsd_final.model.Satellite;
import com.secured.apsd_final.model.dto.SatelliteDTO;

public interface SatelliteService {

    Satellite saveSatellite(SatelliteDTO satelliteDTO);

    Satellite getSatellite();

    Satellite updateSatellite(SatelliteDTO satelliteDTO);

    Satellite deleteSatellite(SatelliteDTO satelliteDTO);

}
