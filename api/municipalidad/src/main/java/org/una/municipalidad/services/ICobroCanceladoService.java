package org.una.municipalidad.services;

import org.una.municipalidad.dto.CobroCanceladoDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ICobroCanceladoService {

    public Optional<List<CobroCanceladoDTO>> findAll();

    public Optional<CobroCanceladoDTO> findById(Long id);

    public Optional<List<CobroCanceladoDTO>> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate);

    public Optional<List<CobroCanceladoDTO>> findByFechaCreacionBetween(Date startDate, Date endDate);

    public Optional<List<CobroCanceladoDTO>> findByDescripcion(String descripcion);

    public Optional<CobroCanceladoDTO> create(CobroCanceladoDTO cobroCanceladoDTO);

    public Optional<CobroCanceladoDTO> update(CobroCanceladoDTO cobroCanceladoDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
