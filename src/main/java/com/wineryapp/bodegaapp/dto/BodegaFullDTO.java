package com.wineryapp.bodegaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class BodegaFullDTO {
    private Integer id_bodega;
    private String nombre;
    private Integer coordenada_ubicacion;
    private String descripcion;
    private String historia;
    private LocalDateTime periodo_actualizable;
    private Boolean es_actualizable;

    // Constructor sin argumentos
    public BodegaFullDTO() {
    }
}