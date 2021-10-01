package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.Contribuyente;
import org.una.municipalidad.entities.Servicio;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ContribuyenteServicioDTO {

    private Long id;
    private String porcentaje;
    private Contribuyente contribuyente;
    private Servicio servicio;
}
