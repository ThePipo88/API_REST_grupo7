package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lista_salida")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ListaSalida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="ruta_buses_id")
    private RutaBus rutaBus;

    @Column(name = "cantidad", length = 100)
    private String cantidad;

    @Column(name = "inicio", length = 100)
    private String start;

    @Column(name = "final", length = 100)
    private String end;

}
