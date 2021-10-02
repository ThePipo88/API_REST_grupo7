package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.municipalidad.entities.Contribuyente;


import java.util.Date;
import java.util.List;


public interface IContribuyenteRepository extends JpaRepository<Contribuyente, Long> {

    public Contribuyente findById(String id);

    public List<Contribuyente> findByIdContaining(String id);

    public List<Contribuyente> findByFechaNacimientoContainingIgnoreCase(Date fechaNacimiento);

    public List<Contribuyente> findByDireccionContainingIgnoreCase(String direccion);

    public List<Contribuyente> findByCorreoElectronicoContainingIgnoreCase(String correoElectronico);

    public List<Contribuyente> findByTelefonoContainingIgnoreCase(String telefono);


}
