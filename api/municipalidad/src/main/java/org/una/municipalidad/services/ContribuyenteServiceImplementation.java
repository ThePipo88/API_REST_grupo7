package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.municipalidad.dto.ContribuyenteDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContribuyenteServiceImplementation implements IContribuyenteService{

    @Autowired
    private IContribuyenteService iContribuyenteService;

    @Override
    public Optional<List<ContribuyenteDTO>> findAll() {
        return Optional.empty();
    }

    @Override
    public Optional<ContribuyenteDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ContribuyenteDTO>> findNombre(String nombreCompleto) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ContribuyenteDTO>> findByFechaNacimientoBetween(Date startDate, Date endDate) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ContribuyenteDTO>> findCorreo(String correoElectronico) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ContribuyenteDTO>> findDireccion(String direccion) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ContribuyenteDTO>> findTelefono(String telefono) {
        return Optional.empty();
    }

    @Override
    public Optional<ContribuyenteDTO> create(ContribuyenteDTO contribuyenteDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<ContribuyenteDTO> update(ContribuyenteDTO contribuyenteDTO, Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
