package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "servicios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_servicio", length = 50)
    private String tipoServicio;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @Column
    private boolean estado;

    @Column(name = "fechaRegistro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column(name = "ultima_actualizacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date ultimaActualizacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio")
    private List<RutaBus> buses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio")
    private List<ServicioPropiedad> propiedad = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fechaRegistro = new Date();
        ultimaActualizacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        ultimaActualizacion = new Date();
    }
}
