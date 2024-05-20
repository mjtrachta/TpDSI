package com.wineryapp.bodegaapp.service;

import com.wineryapp.bodegaapp.dto.BodegaDTO;
import com.wineryapp.bodegaapp.dto.BodegaFullDTO;
import com.wineryapp.bodegaapp.entity.Bodega;
import com.wineryapp.bodegaapp.repository.BodegaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BodegaServiceImpl implements BodegaService {

    private final BodegaRepository bodegaRepository;

    @Autowired
    public BodegaServiceImpl(BodegaRepository bodegaRepository) {
        this.bodegaRepository = bodegaRepository;
    }

    // Obtener bodega x ID
    @Override
    public Optional<Bodega> obtenerBodegaPorId(Integer id) {
        return bodegaRepository.findById(id);
    }

    // Obtener todas las bodegas Actualizables
    @Override
    public List<Bodega> obtenerBodegasActualizables() {
        return bodegaRepository.obtenerBodegasActualizables();

    }

    // Obtener todas las bodegas ActualizablesDTO
    @Override
    public List<BodegaDTO> obtenerBodegasActualizablesDTO() {
        return bodegaRepository.obtenerBodegasActualizablesDTO();
    }

    // Actualizar  bodega x ID
    @Override
    public Bodega actualizarBodega(Bodega bodega) {
        return bodegaRepository.save(bodega);
    }




    // Obtener todas las bodegas ActualizablesDTO
    @Override
    public List<BodegaFullDTO> obtenerBodegasActualizablesFullDTO() {
        return bodegaRepository.obtenerBodegasActualizablesFullDTO();
    }


    // actualiza los campos periodo_actualizable por la fecha actual  y
    // es_actualizable de 1 a 0 de la bodega con un id_bodega determinado
    // solo si es_actualizable esta en  1
    @Override
    public boolean actualizarPeriodoYEstado(Integer id_bodega) {
        int updatedRows = bodegaRepository.actualizarPeriodoYEstado(id_bodega);
        return updatedRows > 0;
    }

}
