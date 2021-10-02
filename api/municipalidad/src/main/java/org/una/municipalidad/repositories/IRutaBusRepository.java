package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.RutaBus;
import org.una.municipalidad.entities.Servicio;
import java.util.List;

@Repository
public interface IRutaBusRepository extends JpaRepository<RutaBus, Long> {

    public List<RutaBus> findByNombre(String nombre);

    public List<RutaBus> findByInicio(String inicio);

    public List<RutaBus> findByFinal(String fin);
}
