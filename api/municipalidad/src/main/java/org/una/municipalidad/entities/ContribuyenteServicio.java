package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contribuyentes_servicios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ContribuyenteServicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="contribuyente_id")
    private Contribuyente contribuyente;

    @ManyToOne
    @JoinColumn(name="servicio_id")
    private Servicio servicio;
}
