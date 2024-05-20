package com.wineryapp.bodegaapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_uva")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TipoUva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_uva")
    private Integer id_tipo_uva;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

// Getters and setters
}
