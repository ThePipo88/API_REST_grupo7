package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ruta_buses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RutaBus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="servicio_id")
    private Servicio servicio;


    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "inicio", length = 100)
    private String start;

    @Column(name = "final", length = 100)
    private String end;

    @Column(name = "lista_salida", length = 100)
    private String listaSalida;


    @Column(name = "estado", length = 10)
    private String estado;

    private static final long serialVersionUID = 1L;
}
