package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.municipalidad.entities.Contribuyente;



import java.util.List;


public interface IContribuyenteRepository extends JpaRepository<Contribuyente, Long> {

    public Contribuyente findByCedula(String cedula);

    public List<Contribuyente> findByCedulaContaining(String cedula);

    public List<Contribuyente> findByNombreCompletoContainingIgnoreCase(String nombreCompleto);

}
