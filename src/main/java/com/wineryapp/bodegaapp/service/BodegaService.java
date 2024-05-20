package com.wineryapp.bodegaapp.service;

import com.wineryapp.bodegaapp.dto.BodegaDTO;
import com.wineryapp.bodegaapp.dto.BodegaFullDTO;
import com.wineryapp.bodegaapp.entity.Bodega;

import java.util.List;
import java.util.Optional;

public interface BodegaService {

    // Obtener bodega x ID
    Optional<Bodega> obtenerBodegaPorId(Integer id);

    // Obtener todas las bodegas Actualizables
    List<Bodega> obtenerBodegasActualizables();

    // Obtener todas las bodegas ActualizablesDTO
    List<BodegaDTO> obtenerBodegasActualizablesDTO();

    // Actualizar  bodega x ID
    Bodega actualizarBodega(Bodega bodega);


    // Obtener todas las bodegas ActualizablesDTO
    List<BodegaFullDTO> obtenerBodegasActualizablesFullDTO();


}