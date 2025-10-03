package com.gestor.gdp.entity;

import lombok.Data;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expedientes")
@Data
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_expediente;

    @Column(nullable = false, unique = true)
    private String codigo_expediente;

    @Column(nullable = false)
    private String nombre_expediente;

    private String dependencia;

    private String estado;

    private String ubicacion_fisica;

    private String ubicacion_digital;

    private LocalDate fecha_creacion;

    private String fecha_cierre;
}
