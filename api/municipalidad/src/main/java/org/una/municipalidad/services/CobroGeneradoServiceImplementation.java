package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.CobroGeneradoDTO;
import org.una.municipalidad.entities.CobroGenerado;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.ICobroGeneradoRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CobroGeneradoServiceImplementation implements ICobroGeneradoService{

    @Autowired
    private ICobroGeneradoRepository cobroGeneradoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroGeneradoDTO>> findAll() {
        List<CobroGeneradoDTO> cobroGeneradoDTOList = MapperUtils.DtoListFromEntityList(cobroGeneradoRepository.findAll(), CobroGeneradoDTO.class);
        return Optional.ofNullable(cobroGeneradoDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CobroGeneradoDTO> findById(Long id) {
        Optional<CobroGenerado> cobroGenerado = cobroGeneradoRepository.findById(id);
        if (cobroGenerado.isEmpty()) throw new NotFoundInformationException();

        CobroGeneradoDTO cobroGeneradoDTO = MapperUtils.DtoFromEntity(cobroGenerado.get(), CobroGeneradoDTO.class);
        return Optional.ofNullable(cobroGeneradoDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroGeneradoDTO>> findByMonto(Double monto) {
        List<CobroGenerado> cobroGeneradoList = cobroGeneradoRepository.findByMonto(monto);
        List<CobroGeneradoDTO> cobroGeneradoDTOList = MapperUtils.DtoListFromEntityList(cobroGeneradoList, CobroGeneradoDTO.class);
        return Optional.ofNullable(cobroGeneradoDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroGeneradoDTO>> findByCobroCedula(@Param("cedula")String cedula) {
        List<CobroGenerado> cobroGeneradoList = cobroGeneradoRepository.findByCobroCedula(cedula);
        List<CobroGeneradoDTO> cobroGeneradoDTOList = MapperUtils.DtoListFromEntityList(cobroGeneradoList, CobroGeneradoDTO.class);
        return Optional.ofNullable(cobroGeneradoDTOList);
    }

/*
    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroGeneradoDTO>> findByObjetoAndFechaCobroBetween(String objetoId, Date startDate, Date endDate) {
        List<CobroGenerado> cobroGeneradoList = cobroGeneradoRepository.findByObjetoAndFechaCobroBetween(objetoId,startDate,endDate);
        List<CobroGeneradoDTO> cobroGeneradoDTOList = MapperUtils.DtoListFromEntityList(cobroGeneradoList, CobroGeneradoDTO.class);
        return Optional.ofNullable(cobroGeneradoDTOList);
    }
*/

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroGeneradoDTO>> findByFechaCobroBetween(Date startDate, Date endDate) {
        List<CobroGenerado> cobroGeneradoList = cobroGeneradoRepository.findByFechaCobroBetween(startDate,endDate);
        List<CobroGeneradoDTO> cobroGeneradoDTOList = MapperUtils.DtoListFromEntityList(cobroGeneradoList, CobroGeneradoDTO.class);
        return Optional.ofNullable(cobroGeneradoDTOList);
    }


    private CobroGeneradoDTO getSavedCobroGeneradoDTO(CobroGeneradoDTO cobroGeneradoDTO) {
        CobroGenerado cobroGenerado = MapperUtils.EntityFromDto(cobroGeneradoDTO, CobroGenerado.class);
        CobroGenerado cobroGeneradoCreate = cobroGeneradoRepository.save(cobroGenerado);
        return MapperUtils.DtoFromEntity(cobroGeneradoCreate, CobroGeneradoDTO.class);
    }

    @Override
    @Transactional
    public CobroGeneradoDTO create(CobroGeneradoDTO cobroGeneradoDTO) {
        CobroGenerado cobroGenerado = MapperUtils.EntityFromDto(cobroGeneradoDTO, CobroGenerado.class);
        cobroGenerado = cobroGeneradoRepository.save(cobroGenerado);
        return MapperUtils.DtoFromEntity(cobroGenerado, CobroGeneradoDTO.class);
    }

    @Override
    @Transactional
    public Optional<CobroGeneradoDTO> update(CobroGeneradoDTO cobroGeneradoDTO, Long id) {
        if (cobroGeneradoRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedCobroGeneradoDTO(cobroGeneradoDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cobroGeneradoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        cobroGeneradoRepository.deleteAll();
    }
}
