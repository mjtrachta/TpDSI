package com.wineryapp.bodegaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BodegaDTO {
    private Integer id_bodega;
    private String nombre;

    // Constructor sin argumentos
    public BodegaDTO() {
    }
}