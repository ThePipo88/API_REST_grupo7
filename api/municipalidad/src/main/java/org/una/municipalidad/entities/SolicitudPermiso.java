package org.una.municipalidad.entities;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "SolicitudPermisos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SolicitudPermiso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean estado;

    @Column(name = "Persona_solicitante", length = 45)
    private String Persona_solicitante;

    @Column(name = "Persona_autorizante", length = 45)
    private String Persona_autorizante;

    @Column(name = "accion", length = 45)
    private String accion;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fechaCreacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
    }



}
