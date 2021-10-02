package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.municipalidad.entities.Parametro;

public interface IParametroRepository extends JpaRepository<Parametro, Long> {

}
