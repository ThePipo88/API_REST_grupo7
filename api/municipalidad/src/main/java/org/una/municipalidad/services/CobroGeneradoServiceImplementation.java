package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.municipalidad.dto.CobroGeneradoDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CobroGeneradoServiceImplementation implements ICobroGeneradoService{

    @Autowired
    private ICobroGeneradoService cobroGeneradoService;

    @Override
    public Optional<List<CobroGeneradoDTO>> findAll() {
        return Optional.empty();
    }

    @Override
    public Optional<CobroGeneradoDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CobroGeneradoDTO> findByMonto(Double monto) {
        return Optional.empty();
    }

    @Override
    public Optional<List<CobroGeneradoDTO>> findByObjetoAndFechaCobroBetween(String objetoId, Date startDate, Date endDate) {
        return Optional.empty();
    }

    @Override
    public Optional<List<CobroGeneradoDTO>> findByFechaCobroBetween(Date startDate, Date endDate) {
        return Optional.empty();
    }

    @Override
    public Optional<CobroGeneradoDTO> create(CobroGeneradoDTO cobroGeneradoDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<CobroGeneradoDTO> update(CobroGeneradoDTO cobroGeneradoDTO, Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
