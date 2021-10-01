package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.municipalidad.entities.Rol;

import java.util.Date;
import java.util.List;

public interface IRolRepository extends JpaRepository<Rol, Long> {

    public List<Rol> findByEstado(boolean estado);
    public List<Rol> findByFechaCreacionBetween(Date startDate, Date endDate);

}
