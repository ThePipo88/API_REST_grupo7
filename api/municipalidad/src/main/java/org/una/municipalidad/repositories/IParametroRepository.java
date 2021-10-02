package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.municipalidad.entities.Parametro;
import org.una.municipalidad.entities.Recibo;

import java.util.Date;
import java.util.List;

public interface IParametroRepository extends JpaRepository<Parametro, Long> {

    public List<Parametro> findByNombre(String nombre);

    public List<Parametro> findByFormula(String formula);

    public List<Parametro> findByEstado(boolean estado);
}
