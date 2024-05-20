package com.wineryapp.bodegaapp.repository;

import com.wineryapp.bodegaapp.dto.BodegaDTO;
import com.wineryapp.bodegaapp.dto.BodegaFullDTO;
import com.wineryapp.bodegaapp.entity.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BodegaRepository extends JpaRepository<Bodega, Integer> {

    // Consulta sin DTO
    @Query("SELECT b FROM Bodega b WHERE b.es_actualizable = true")
    List<Bodega> obtenerBodegasActualizables();

    // Consulta con DTO
    @Query("SELECT new com.wineryapp.bodegaapp.dto.BodegaDTO(b.id_bodega, b.nombre) FROM Bodega b WHERE b.es_actualizable = true")
    List<BodegaDTO> obtenerBodegasActualizablesDTO();






    // Consulta con DTO2
    @Query("SELECT new com.wineryapp.bodegaapp.dto.BodegaFullDTO(b.id_bodega, b.nombre, b.region_vitivinicola.id_region, b.descripcion, b.historia, b.periodo_actualizable, b.es_actualizable) FROM Bodega b WHERE b.es_actualizable = true")
    List<BodegaFullDTO> obtenerBodegasActualizablesFullDTO();
}