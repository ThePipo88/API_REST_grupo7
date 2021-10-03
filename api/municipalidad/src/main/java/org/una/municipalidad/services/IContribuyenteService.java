package org.una.municipalidad.services;


import org.una.municipalidad.dto.ContribuyenteDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IContribuyenteService {

    public Optional<List<ContribuyenteDTO>> findAll();

    public Optional<ContribuyenteDTO> findById(Long id);

    public Optional<List<ContribuyenteDTO>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto);

    public Optional<List<ContribuyenteDTO>> findByFechaNacimientoBetween(Date fechaNacimiento);

    public Optional<List<ContribuyenteDTO>> findCorreo(String correoElectronico);

    public Optional<List<ContribuyenteDTO>> findDireccion(String direccion);

    public Optional<List<ContribuyenteDTO>> findTelefono(String telefono);

    public ContribuyenteDTO create(ContribuyenteDTO contribuyenteDTO);

    public Optional<ContribuyenteDTO> update(ContribuyenteDTO contribuyenteDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
