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
    private Integer idTipoUva;

    private String nombre;

    private String descripcion;

// Getters and setters
}
