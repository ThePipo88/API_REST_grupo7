package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.CementerioDTO;
import org.una.municipalidad.dto.RutaBusDTO;
import org.una.municipalidad.entities.Cementerio;
import org.una.municipalidad.entities.RutaBus;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.ICementerioRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

public class CementerioServiceImplementation implements  ICementerioService{

    @Autowired
    private ICementerioRepository cementerioRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CementerioDTO>> findAll() {
        List<CementerioDTO> cementerioDTOList = MapperUtils.DtoListFromEntityList(cementerioRepository.findAll(), CementerioDTO.class);
        return Optional.ofNullable(cementerioDTOList);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<CementerioDTO> findById(Long id) {
        Optional<Cementerio> cementerio = cementerioRepository.findById(id);
        if (cementerio.isEmpty()) throw new NotFoundInformationException();

        CementerioDTO cementerioDTO = MapperUtils.DtoFromEntity(cementerioDTO.get(), CementerioDTO.class);
        return Optional.ofNullable(cementerioDTO);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<List<CementerioDTO>> findBySector(String sector) {
        List<CementerioDTO> cementerioDTOList = cementerioRepository.findBySector(sector);
        List<CementerioDTO> cementerioDTOList = MapperUtils.DtoListFromEntityList(rutaBusList, RutaBusDTO.class);
        return Optional.ofNullable(rutaBusDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<RutaBusDTO>> findByInicio(String inicio) {
        List<RutaBus> rutaBusList = rutaBusRepository.findByInicio(inicio);
        List<RutaBusDTO> rutaBusDTOList = MapperUtils.DtoListFromEntityList(rutaBusList, RutaBusDTO.class);
        return Optional.ofNullable(rutaBusDTOList);
    }
    @Override
    public Optional<List<CementerioDTO>> findAll() {
        return Optional.empty();
    }

    @Override
    public Optional<CementerioDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<CementerioDTO>> findBySector(String sector) {
        return Optional.empty();
    }

    @Override
    public Optional<List<CementerioDTO>> findByOcupado(String esta_ocupado) {
        return Optional.empty();
    }

    @Override
    public Optional<CementerioDTO> create(CementerioDTO cementerioDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<CementerioDTO> update(CementerioDTO cementerioDTO, Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
