package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.CobroGenerado;
import org.una.municipalidad.entities.Recibo;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CobroCanceladoDTO {

    private Long id;
    private CobroGenerado cobroGenerado;
    private Recibo recibo;
    private Date fechaCreacion;
    private String descripcion;

}