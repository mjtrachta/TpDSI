package com.wineryapp.bodegaapp.controller;

import com.wineryapp.bodegaapp.dto.VinoDTO;
import com.wineryapp.bodegaapp.entity.Vino;
import com.wineryapp.bodegaapp.service.VinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinos")
public class VinoController {

    private final VinoService vinoService;

    @Autowired
    public VinoController(VinoService vinoService) {
        this.vinoService = vinoService;
    }


    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/bodega/{idBodega}")
    public ResponseEntity<List<Vino>> obtenerVinosPorBodegaId(@PathVariable("idBodega") Integer idBodega) {
        List<Vino> vinos = vinoService.obtenerVinosPorBodegaId(idBodega);
        if (vinos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(vinos);
        }
    }

    @GetMapping("/bodega/dto/{idBodega}")
    public ResponseEntity<List<VinoDTO>> obtenerVinosDTOPorIdBodega(@PathVariable("idBodega") Integer idBodega) {
        List<VinoDTO> vinos = vinoService.obtenerVinosDTOPorIdBodega(idBodega);
        if (vinos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(vinos);
        }
    }

    @PostMapping
    public ResponseEntity<Vino> crearVino(@RequestBody Vino vino) {
        Vino vinoCreado = vinoService.crearVino(vino);
        return new ResponseEntity<>(vinoCreado, HttpStatus.CREATED);
    }

    @PostMapping("/accept")
    public ResponseEntity<String> acceptPost(@RequestBody Vino vino) {
        kafkaTemplate.send("vino-topic", vino); // Envía el vino a Kafka
        return ResponseEntity.ok("POST accepted");
    }
}