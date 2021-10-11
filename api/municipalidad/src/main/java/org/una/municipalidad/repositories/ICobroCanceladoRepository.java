package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.CobroCancelado;
import org.una.municipalidad.entities.CobroGenerado;

import java.util.Date;
import java.util.List;

@Repository
public interface ICobroCanceladoRepository extends JpaRepository<CobroCancelado, Long> {

    public List<CobroCancelado> findByFechaCreacionBetween(Date startDate, Date endDate);

    public List<CobroCancelado> findByFechaCreacion(Date startDate);

    @Query(value = "SELECT u FROM CobroGenerado u LEFT JOIN u.contribuyenteServicio e WHERE e.contribuyente.cedula = :cedula AND e.servicio.tipoServicio = :tipo")
    public List<CobroCancelado> findByCobroCobroBetweenFecha(@Param("cedula")String cedula, @Param("startDate")Date startDate, @Param("endDate")Date endDate);
}
