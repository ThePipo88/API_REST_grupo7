package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cobros_generados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CobroGenerado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    //@MapsId
    @JoinColumn(name="contribuyente_id")
    private Contribuyente contribuyente;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @Column(name = "fecha_cobro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCobro;

    @OneToOne (mappedBy = "cobroGenerado")
    private CobroCancelado cobroCancelado;

    @Column(length = 100, name = "monto")
    private Double monto;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
    }

    @PreUpdate
    public void preUpdate() {
        fechaCobro= new Date();
    }

}
