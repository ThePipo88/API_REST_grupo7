package org.una.municipalidad.dto;
import lombok.*;
import org.una.municipalidad.entities.Servicio;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CementerioDTO {

    private Long id;
    private Servicio servicio;
    private String sector;
    private String esta_ocupado;


}
