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

    // actualiza los campos periodo_actualizable por la fecha actual  y
    // es_actualizable de 1 a 0 de la bodega con un id_bodega determinado
    // solo si es_actualizable esta en  1
    boolean actualizarPeriodoYEstado(Integer id_bodega);


}