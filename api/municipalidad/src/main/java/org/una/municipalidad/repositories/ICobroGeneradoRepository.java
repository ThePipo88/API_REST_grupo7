package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.CobroGenerado;
import org.una.municipalidad.entities.Usuario;

import java.util.Date;
import java.util.List;


@Repository
public interface ICobroGeneradoRepository extends JpaRepository<CobroGenerado, Long> {

    public List<CobroGenerado> findByIdCobroGeneradoContainingIgnoreCase(Long id);

    public List<CobroGenerado> findByFechaCobroContainingIgnoreCase(Date startDate, Date endDate);

    public List<CobroGenerado> findByMontoDeCobroContainingIgnoreCase(Double monto);

}
