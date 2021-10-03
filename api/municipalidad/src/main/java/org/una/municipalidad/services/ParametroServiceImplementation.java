package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.municipalidad.dto.ParametroDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ParametroServiceImplementation implements IParametroService{

    @Autowired
    private IParametroService iParametroService;

    @Override
    public Optional<List<ParametroDTO>> findAll() {
        return Optional.empty();
    }

    @Override
    public Optional<ParametroDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ParametroDTO>> findByFormulaAproximate(String formula) {
        return Optional.empty();
    }

    @Override
    public Optional<ParametroDTO> findByFormula(String formula) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ParametroDTO>> findByNombreAproximate(String nombre) {
        return Optional.empty();
    }

    @Override
    public Optional<ParametroDTO> findByNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ParametroDTO>> findByestadoAproximate(boolean estado) {
        return Optional.empty();
    }

    @Override
    public Optional<ParametroDTO> findByEstado(boolean estado) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ParametroDTO>> findByFechaCreacionBetween(Date startDate, Date endDate) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ParametroDTO>> findByFechaModificacionBetween(Date startDate, Date endDate) {
        return Optional.empty();
    }

    @Override
    public ParametroDTO create(ParametroDTO parametroDTO) {
        return null;
    }

    @Override
    public Optional<ParametroDTO> update(ParametroDTO parametroDTO, Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
