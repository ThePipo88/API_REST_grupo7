package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contribuyente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Contribuyente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo", length = 100)
    private String nombreCompleto;

    @Column(name = "fecha_nacimiento", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaNacimiento;

    @Column(name = "direccion", length = 300)
    private String direccion;

    @Column(name = "correo_electronico", length = 300)
    private String correoElectronico;

    @Column(name = "telefono", length = 300)
    private String telefono;

    private static final long serialVersionUID = 1L;


    @PrePersist
    public void prePersist() {
        fechaNacimiento = new Date();
    }


}
