package org.una.municipalidad.dto;

import lombok.*;
import org.una.municipalidad.entities.CobroCancelado;
import org.una.municipalidad.entities.ContribuyenteServicio;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CobroGeneradoDTO {

    private Long id;
    private ContribuyenteServicio contribuyenteServicio;
    private Date fechaCobro;
    private CobroCancelado cobroCancelado;
    private Double monto;
}
