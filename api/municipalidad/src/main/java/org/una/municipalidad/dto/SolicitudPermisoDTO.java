package org.una.municipalidad.dto;
import lombok.*;
import org.una.municipalidad.entities.Usuario;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SolicitudPermisoDTO {

    private Long id;

    private String Persona_solicitante;
    private String Persona_autorizante;
    private String accion;
    private Date fechaCreacion;
}
