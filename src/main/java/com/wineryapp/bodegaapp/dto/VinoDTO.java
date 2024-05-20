package com.wineryapp.bodegaapp.dto;

import com.wineryapp.bodegaapp.entity.Bodega;
import com.wineryapp.bodegaapp.entity.Varietal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VinoDTO {
    private Integer id_vino;
    private String anio;
    private String nombre;
    private String nota_de_cata_bodega;
    private Integer precio_ars;
    private Integer id_bodega;
    private Integer id_varietal;
}