package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.CobroCancelado;

import java.util.Date;
import java.util.List;

@Repository
public interface ICobroCanceladoRepository extends JpaRepository<CobroCancelado, Long> {

    public List<CobroCancelado> findByFechaCreacionBetween(Date startDate, Date endDate);

    public List<CobroCancelado> findByFechaCreacion(Date startDate);

}
