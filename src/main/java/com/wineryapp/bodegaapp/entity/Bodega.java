package com.wineryapp.bodegaapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "bodega")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bodega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bodega")
    private Integer id_bodega;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "coordenada_ubicacion")
    private RegionVitivinicola region_vitivinicola;

    @Lob
    private String descripcion;

    @Lob
    private String historia;

    @Column(name = "periodo_actualizable")
    private LocalDateTime periodo_actualizable;

    @Column(name = "es_actualizable")
    private Boolean es_actualizable;


    // Getters and setters
}
