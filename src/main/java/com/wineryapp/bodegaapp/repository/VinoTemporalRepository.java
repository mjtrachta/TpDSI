package com.wineryapp.bodegaapp.repository;

import com.wineryapp.bodegaapp.entity.VinoTemporal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VinoTemporalRepository extends JpaRepository<VinoTemporal, Integer> {
}