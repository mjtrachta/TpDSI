package com.wineryapp.bodegaapp.repository;

import com.wineryapp.bodegaapp.dto.BodegaDTO;
import com.wineryapp.bodegaapp.dto.BodegaFullDTO;
import com.wineryapp.bodegaapp.entity.Bodega;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BodegaRepository extends JpaRepository<Bodega, Integer> {

    // Consulta sin DTO
    @Query("SELECT b FROM Bodega b WHERE b.es_actualizable = true")
    List<Bodega> obtenerBodegasActualizables();

    // Consulta con DTO
    @Query("SELECT new com.wineryapp.bodegaapp.dto.BodegaDTO(b.id_bodega, b.nombre) FROM Bodega b WHERE b.es_actualizable = true")
    List<BodegaDTO> obtenerBodegasActualizablesDTO();


    // actualiza los campos periodo_actualizable por la fecha actual  y
    // es_actualizable de 1 a 0 de la bodega con un id_bodega determinado
    // solo si es_actualizable esta en  1
    @Modifying
    @Transactional
    @Query("UPDATE Bodega b SET b.periodo_actualizable = CURRENT_TIMESTAMP, b.es_actualizable = false WHERE b.id_bodega = :id_bodega AND b.es_actualizable = true")
    int actualizarPeriodoYEstado(@Param("id_bodega") Integer id_bodega);



    // Consulta con DTO2
    @Query("SELECT new com.wineryapp.bodegaapp.dto.BodegaFullDTO(b.id_bodega, b.nombre, b.region_vitivinicola.id_region, b.descripcion, b.historia, b.periodo_actualizable, b.es_actualizable) FROM Bodega b WHERE b.es_actualizable = true")
    List<BodegaFullDTO> obtenerBodegasActualizablesFullDTO();
}