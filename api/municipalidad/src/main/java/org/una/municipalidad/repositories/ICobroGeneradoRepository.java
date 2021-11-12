package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.dto.CobroGeneradoDTO;
import org.una.municipalidad.entities.CobroGenerado;
import org.una.municipalidad.entities.Usuario;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface ICobroGeneradoRepository extends JpaRepository<CobroGenerado, Long> {

    public List<CobroGenerado> findByMonto(Double monto);

    public List<CobroGenerado> findByFechaCobroBetween(Date startDate, Date endDate);

    public List<CobroGenerado> findByEstado(boolean estado);

    @Query(value = "SELECT u FROM CobroGenerado u LEFT JOIN u.contribuyenteServicio e WHERE e.contribuyente.cedula = :cedula AND e.servicio.tipoServicio = :tipo AND u.estado = 1")
    public List<CobroGenerado> findCobroByCedula(@Param("cedula")String cedula, @Param("tipo")String tipo);

    //@Query(value = "{call lista_cobros_masivos()}", nativeQuery = true)
    //public List<CobroGenerado> findByCobrosMasivos(Long id);
}
