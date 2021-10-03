package org.una.municipalidad.services;

import org.una.municipalidad.dto.ExcepcionDTO;
import org.una.municipalidad.dto.ReciboDTO;
import org.una.municipalidad.dto.ServicioDTO;
import org.una.municipalidad.entities.Servicio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IServicioService {

    public Optional<List<ServicioDTO>> findAll();

    public Optional<ServicioDTO> findById(Long id);

    public Optional<List<ServicioDTO>> findByServicio(String servicio);

    public Optional<List<ServicioDTO>> findByEstado(String estado);

    public Optional<List<ServicioDTO>> findByPropiedad(Long id);

    public Optional<List<ServicioDTO>> findByFechaRegitro(Date fechaRegistro);

    public Optional<List<ServicioDTO>> findByUltimaActualizacion(Date ultimaActualizacion);

    public ServicioDTO create(ServicioDTO servicioDTO);

    public Optional<ServicioDTO> update(ServicioDTO servicioDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
