package com.wineryapp.bodegaapp.repository;
import com.wineryapp.bodegaapp.dto.VinoDTO;
import com.wineryapp.bodegaapp.entity.Vino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VinoRepository extends JpaRepository<Vino, Integer> {
    @Query("SELECT v FROM Vino v WHERE v.bodega.id_bodega = :idBodega")
    List<Vino> findVinosByBodegaId(@Param("idBodega") Integer idBodega);


    @Query("SELECT new com.wineryapp.bodegaapp.dto.VinoDTO(v.id_vino, v.anio, v.nombre, v.nota_de_cata_bodega, v.precio_ars, v.bodega.id_bodega, v.varietal.id_varietal) FROM Vino v WHERE v.bodega.id_bodega = :idBodega")
    List<VinoDTO> findVinosDTOByBodegaId(@Param("idBodega") Integer idBodega);


}