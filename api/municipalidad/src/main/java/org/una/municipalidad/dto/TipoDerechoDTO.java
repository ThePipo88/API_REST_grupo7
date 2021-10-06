package org.una.municipalidad.dto;
import lombok.*;
import org.una.municipalidad.entities.TipoDerecho;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TipoDerechoDTO {

    private Long id;
    private TipoDerecho tipoDerecho;
    private String tipo;
    private int monto;

}
