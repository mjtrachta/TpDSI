package com.wineryapp.bodegaapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "varietal")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Varietal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVarietal;

    private String descripcion;

    private String porcentajeComposicion;

    @ManyToOne
    @JoinColumn(name = "idTipoUva")
    private TipoUva tipoUva;

    // Getters and setters
}

