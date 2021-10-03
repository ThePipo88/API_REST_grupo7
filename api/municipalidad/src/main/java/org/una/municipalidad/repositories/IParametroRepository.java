package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Parametro;
import org.una.municipalidad.entities.Recibo;

import java.util.Date;
import java.util.List;

@Repository
public interface IParametroRepository extends JpaRepository<Parametro, Long> {

    public List<Parametro> findByNombre(String nombre);

    public List<Parametro> findByFormula(String formula);

    public List<Parametro> findByEstado(boolean estado);

    public List<Parametro> findByFechaCracion(Date startDate, Date endDate);

    public List<Parametro> findByFechaModificacion(Date startDate, Date endDate);
}
