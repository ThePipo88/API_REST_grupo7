package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "limpieza_vias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class LimpiezaVia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="servicio_id")
    private Servicio servicio;

    @Column(name = "provincia", length = 100)
    private String provincia;

    @Column(name = "canton", length = 100)
    private String canton;

    @Column(name = "distrito", length = 100)
    private String distrito;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "zona", length = 100)
    private String zona;

    @Column(name = "metros_frente", length = 100)
    private Double metrosFrente;

    private static final long serialVersionUID = 1L;
}
