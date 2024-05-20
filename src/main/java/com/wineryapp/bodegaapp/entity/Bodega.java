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
    private Integer idBodega;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "coordenadaUbicacion")
    private RegionVitivinicola regionVitivinicola;

    @Lob
    private String descripcion;

    @Lob
    private String historia;

    private LocalDateTime periodoActualizable;

    private Boolean esActualizable;

    // Getters and setters
}
