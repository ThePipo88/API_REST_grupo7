package org.una.municipalidad.services;

import org.una.municipalidad.dto.CobroGeneradoDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ICobroGeneradoService {

    public Optional<List<CobroGeneradoDTO>> findAll();

    public Optional<CobroGeneradoDTO> findById(Long id);

    public Optional<List<CobroGeneradoDTO>> findByMonto(Double monto);

    public Optional<List<CobroGeneradoDTO>> findByObjetoAndFechaCobroBetween(String objetoId, Date startDate, Date endDate);

    public Optional<List<CobroGeneradoDTO>> findByFechaCobroBetween(Date startDate, Date endDate);

    public CobroGeneradoDTO create(CobroGeneradoDTO cobroGeneradoDTO);

    public Optional<CobroGeneradoDTO> update(CobroGeneradoDTO cobroGeneradoDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}