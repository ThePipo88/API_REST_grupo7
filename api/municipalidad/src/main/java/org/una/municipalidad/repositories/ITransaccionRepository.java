package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.municipalidad.entities.Transaccion;

import java.util.Date;
import java.util.List;

public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {

    public List<Transaccion> findByUsuarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate);

    public List<Transaccion> findByRolIdAndFechaCreacionBetween(Long id, Date startDate, Date endDate);

    public List<Transaccion> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate);

    public List<Transaccion> findByFechaCreacionBetween(Date startDate, Date endDate);
}
