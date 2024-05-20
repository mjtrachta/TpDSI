package com.wineryapp.bodegaapp.controller;

import com.wineryapp.bodegaapp.dto.BodegaDTO;
import com.wineryapp.bodegaapp.dto.BodegaFullDTO;
import com.wineryapp.bodegaapp.entity.Bodega;
import com.wineryapp.bodegaapp.service.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

    @Autowired
    private BodegaService bodegaService;

    // Endpoint para obtener las bodegas con DTO
    // se une a http://localhost:4200/bodegaSSSSS

    @GetMapping("/actualizablesDTO")
    public ResponseEntity<List<BodegaDTO>> obtenerBodegasActualizablesDTO() {
        List<BodegaDTO> bodegasDTO = bodegaService.obtenerBodegasActualizablesDTO();
        return ResponseEntity.ok(bodegasDTO);
    }






    // Endpoint para obtener las bodegas sin DTO
    @GetMapping("/actualizables")
    public ResponseEntity<List<Bodega>> obtenerBodegasActualizables() {
        List<Bodega> bodegas = bodegaService.obtenerBodegasActualizables();
        return ResponseEntity.ok(bodegas);
    }

    // Endpoint PUT para actualizar una Bodega existente
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarBodega(@PathVariable Integer id, @RequestBody Bodega bodega) {
        Optional<Bodega> bodegaExistente = bodegaService.obtenerBodegaPorId(id);
        if (bodegaExistente.isPresent()) {
            // Aquí establecemos el ID de la bodega usando el método setId_bodega
            bodega.setId_bodega(id);
            Bodega bodegaActualizada = bodegaService.actualizarBodega(bodega);
            // Aquí obtenemos el ID de la bodega actualizada usando el método getId_bodega
            return ResponseEntity.status(HttpStatus.OK).body("Bodega actualizada con éxito: " + bodegaActualizada.getId_bodega());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bodega no encontrada con ID: " + id);
        }
    }


    // Endpoint para obtener las bodegas con DTO
    @GetMapping("/actualizablesDTO2")
    public ResponseEntity<List<BodegaFullDTO>> obtenerBodegasActualizablesFullDTO() {
        List<BodegaFullDTO> bodegasFullDTO = bodegaService.obtenerBodegasActualizablesFullDTO();
        return ResponseEntity.ok(bodegasFullDTO);
    }



    // actualiza los campos periodo_actualizable por la fecha actual  y
    // es_actualizable de 1 a 0 de la bodega con un id_bodega determinado
    // solo si es_actualizable esta en  1
    @PutMapping("/actualizar-periodo-estado/{id_bodega}")
    public ResponseEntity<String> actualizarPeriodoYEstado(@PathVariable Integer id_bodega) {
        boolean actualizado = bodegaService.actualizarPeriodoYEstado(id_bodega);
        if (actualizado) {
            return ResponseEntity.ok("Bodega actualizada correctamente");
        } else {
            return ResponseEntity.status(400).body("No se pudo actualizar la bodega, verifique que el ID sea correcto y que la bodega sea actualizable.");
        }
    }
}