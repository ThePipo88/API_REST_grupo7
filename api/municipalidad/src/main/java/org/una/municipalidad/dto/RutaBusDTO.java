package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.Servicio;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RutaBusDTO {

    private Long id;
    private Servicio servicio;
    private String nombre;
    private String inicio;
    private String fin;
}
