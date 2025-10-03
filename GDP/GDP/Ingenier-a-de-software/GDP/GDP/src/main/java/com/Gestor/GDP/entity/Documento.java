package com.gestor.gdp.entity;
import lombok.Data;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documentos")
@Data
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documento;

    @ManyToOne
    @JoinColumn(name = "id_expediente", nullable = false)
    private Expediente expediente;

    private String nombre;
    private String tipologia;
    private LocalDate fecha_creacion;
    private LocalDate fecha_incorporacion;
    private String formato;
    private Integer tamano_kb;
    private String hash_valor;
    private String origen;
    private String version;
    private String estado;
}
