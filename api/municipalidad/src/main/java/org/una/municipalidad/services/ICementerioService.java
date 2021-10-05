package org.una.municipalidad.services;


import org.una.municipalidad.dto.CementerioDTO;


import java.util.List;
import java.util.Optional;

public interface ICementerioService {

    public Optional<List<CementerioDTO>> findAll();

    public Optional<CementerioDTO> findById(Long id);

    public Optional<List<CementerioDTO>> findBySector(String sector);

    public Optional<List<CementerioDTO>> findByOcupado(String ocupado);

    public Optional<CementerioDTO> create(CementerioDTO cementerioDTO);

    public Optional<CementerioDTO> update(CementerioDTO cementerioDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
