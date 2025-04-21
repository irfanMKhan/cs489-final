package com.secured.apsd_final.repository;

import com.secured.apsd_final.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatelliteRepository extends JpaRepository<Satellite, Long> {

}
