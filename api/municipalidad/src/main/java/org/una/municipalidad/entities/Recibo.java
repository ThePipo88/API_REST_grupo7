package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "recibo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Recibo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_emicion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaEmision;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fechaEmision = new Date();
    }
}
