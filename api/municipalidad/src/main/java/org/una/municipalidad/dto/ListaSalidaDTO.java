package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.RutaBus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ListaSalidaDTO {

    private Long id;
    private RutaBus rutaBus;
    private String dia;
    private int cantidad;
}
