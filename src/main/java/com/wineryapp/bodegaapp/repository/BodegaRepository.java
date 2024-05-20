package com.wineryapp.bodegaapp.repository;

import com.wineryapp.bodegaapp.entity.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodegaRepository  extends JpaRepository<Bodega, Integer> {
}
