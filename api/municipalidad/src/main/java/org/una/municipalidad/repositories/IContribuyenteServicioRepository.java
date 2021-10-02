package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.municipalidad.entities.ContribuyenteServicio;


import java.util.List;

public interface IContribuyenteServicioRepository extends JpaRepository<ContribuyenteServicio, Long> {

    public List<ContribuyenteServicio> findByIdContribuyenteServicio(Long id);

    public List<ContribuyenteServicio> findByPorcentajeServicio(String porcentaje);



}
