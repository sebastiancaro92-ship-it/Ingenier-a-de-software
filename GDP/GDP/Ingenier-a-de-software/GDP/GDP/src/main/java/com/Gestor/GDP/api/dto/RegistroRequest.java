package com.Gestor.GDP.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class RegistroRequest {

    @NotNull
    private Expediente expediente;

    @NotNull
    private Documento documento;

    @NotNull
    private Clasificacion clasificacion;

    @NotNull
    private Paginacion paginacion;

  

    @Getter
    @Setter
    public static class Expediente {
        @NotBlank
        private String codigo_expediente;
        @NotBlank
        private String nombre_expediente;
        @NotBlank
        private String dependencia;
        @NotBlank
        private String estado;
        private String ubicacion_fisica;
        private String ubicacion_digital;
        private LocalDate fecha_creacion;   
        private String fecha_cierre;        
    }

    @Getter
    @Setter
    public static class Documento {
        @NotBlank
        private String nombre;
        @NotBlank
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

    @Getter
    @Setter
    public static class Clasificacion {
        @NotNull
        private Serie serie;
        @NotNull
        private Subserie subserie;
        private String carpeta;
        @NotNull
        private Retencion retencion;
    }

    @Getter
    @Setter
    public static class Serie {
        private String codigo;
        private String nombre;
    }

    @Getter
    @Setter
    public static class Subserie {
        private String codigo;
        private String nombre;
    }

    @Getter
    @Setter
    public static class Retencion {
        private Integer tiempo_gestion;
        private Integer tiempo_central;
        private String disposicion_final;
        private String observaciones;
    }

    @Getter
    @Setter
    public static class Paginacion {
        private Integer orden_expediente;
        private Integer pagina_inicio;
        private Integer pagina_fin;
    }
}
