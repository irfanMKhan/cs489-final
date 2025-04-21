package com.secured.apsd_final.repository;

import com.secured.apsd_final.model.Astronauts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstronautRepository extends JpaRepository<Astronauts, Long> {

}
