package org.una.municipalidad.services;

import org.una.municipalidad.dto.PropiedadDTO;
import org.una.municipalidad.dto.ReciboDTO;
import org.una.municipalidad.entities.Recibo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IReciboService {

    public Optional<List<ReciboDTO>> findAll();

    public Optional<ReciboDTO> findById(Long id);

    public Optional<List<ReciboDTO>> findByContribuyente(String contribuyente);

    public Optional<List<ReciboDTO>> findByFechaEmision(Date fechaEmision);

    public PropiedadDTO create(ReciboDTO reciboDTO);

    public Optional<ReciboDTO> update(ReciboDTO reciboDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
