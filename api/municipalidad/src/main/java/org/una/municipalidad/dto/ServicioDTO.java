package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.Propiedad;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ServicioDTO {

    private Long id;
    private String tipoServicio;
    private String descripcion;
    private String estado;
    private Propiedad propiedad;
    private Date fechaRegistro;
    private Date ultimaActualizacion;
}
