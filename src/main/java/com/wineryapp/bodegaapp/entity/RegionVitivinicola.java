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
    @Column(name = "id_region")
    private Integer id_region;

    private String nombre;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;

    // Getters and setters
}
