package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Cementerio;
import org.una.municipalidad.entities.Servicio;
import java.util.List;

public interface ICementerioRepository extends JpaRepository<Cementerio, Long>{
    public List<Cementerio> findBySector(String sector);

    public List<Cementerio> findByOcupado(String esta_ocuapado);

    public List<Cementerio> findByFin(String fin);
}
}
