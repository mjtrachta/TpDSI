package com.wineryapp.bodegaapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vino")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vino")
    private Integer id_vino;

    @Column(name = "anio")
    private String anio;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nota_de_cata_bodega")
    private String nota_de_cata_bodega;

    @Column(name = "precio_ars")
    private Integer precio_ars;

    @ManyToOne
    @JoinColumn(name = "id_bodega")
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "id_varietal")
    private Varietal varietal;
















    // Getters and setters
}
