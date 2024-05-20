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
    @Column(name = "id_varietal")
    private Integer id_varietal;

    private String descripcion;

    @Column(name = "porcentaje_composicion")
    private String porcentaje_composicion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_uva")
    private TipoUva tipo_uva;

    // Getters and setters
}

