package com.wineryapp.bodegaapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "region_vitivinicola")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegionVitivinicola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegion;

    private String nombre;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idProvincia")
    private Provincia provincia;

    // Getters and setters
}
