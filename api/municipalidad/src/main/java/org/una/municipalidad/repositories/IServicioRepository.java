package org.una.municipalidad.repositories;

import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Propiedad;
import org.una.municipalidad.entities.Servicio;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio, Long> {

    public List<Servicio> findByServicio(Long servicio);

    public List<Servicio> findByEstado(String estado);

    public List<Servicio> findByPropiedad(Long id);

    public List<Servicio> findByFechaRegitro(Date fechaRegistro);

    public List<Servicio> findByUltimaActualizacion(Date ultimaActualizacion);

}
