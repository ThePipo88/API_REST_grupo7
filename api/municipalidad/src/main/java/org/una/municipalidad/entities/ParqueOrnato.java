package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "parques_y_ornatos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ParqueOrnato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="usuarios_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="servicios_id")
    private Servicio servicio;

    @Column(name = "provincia", length = 10)
    private String provincia;

    @Column(name = "canton", length = 10)
    private String canton;

    @Column(name = "distrito", length = 10)
    private String distrito;

    @Column(name = "direccion", length = 10)
    private String direccion;

    @Column(name = "responsable")
    private Double responsable;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
    }

    @PreUpdate
    public void preUpdate() {

    }
}
