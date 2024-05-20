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
    private Integer idVino;

    private String anio;

    private String nombre;

    private String notaDeCataBodega;

    private Integer precioArs;

    @ManyToOne
    @JoinColumn(name = "idBodega")
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "idVarietal")
    private Varietal varietal;

    // Getters and setters
}
