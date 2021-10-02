package org.una.municipalidad.services;

import org.una.municipalidad.dto.ListaSalidaDTO;
import org.una.municipalidad.dto.RutaBusDTO;

import java.util.List;
import java.util.Optional;

public interface IListaSalidaService {

    public Optional<List<ListaSalidaDTO>> findAll();

    public Optional<ListaSalidaDTO> findById(Long id);

    public Optional<List<ListaSalidaDTO>> findByDia(String dia);

    public Optional<List<ListaSalidaDTO>> findByCantidad(int cantidad);

    public Optional<ListaSalidaDTO> create(ListaSalidaDTO listaSalidaDTO);

    public Optional<ListaSalidaDTO> update(ListaSalidaDTO listaSalidaDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
