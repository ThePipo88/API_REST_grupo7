package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.municipalidad.dto.ContribuyenteServicioDTO;
import org.una.municipalidad.entities.Contribuyente;
import org.una.municipalidad.entities.ContribuyenteServicio;
import org.una.municipalidad.entities.Servicio;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.IContribuyenteServicioRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ContribuyenteServicioServiceImplementation implements IContribuyenteServicioService {

    @Autowired
    private IContribuyenteServicioRepository contribuyenteServicioRepository;

    @Override
    public Optional<List<ContribuyenteServicioDTO>> findAll() {
        List<ContribuyenteServicioDTO> contribuyenteServicioDTOList = MapperUtils.DtoListFromEntityList(contribuyenteServicioRepository.findAll(), ContribuyenteServicioDTO.class);
        return Optional.ofNullable(contribuyenteServicioDTOList);
    }

    @Override
    public Optional<ContribuyenteServicioDTO> findById(Long id) {
        Optional<ContribuyenteServicio> contribuyenteServicio = contribuyenteServicioRepository.findById(id);
        if (contribuyenteServicio.isEmpty()) throw new NotFoundInformationException();

        ContribuyenteServicioDTO contribuyenteServicioDTO = MapperUtils.DtoFromEntity(contribuyenteServicio.get(), ContribuyenteServicioDTO.class);
        return Optional.ofNullable(contribuyenteServicioDTO);
    }

    @Override
    public Optional<ContribuyenteServicioDTO> findByPorcentaje(String porcentaje) {
        ContribuyenteServicio contribuyenteServicio = (ContribuyenteServicio) contribuyenteServicioRepository.findByPorcentajeServicio(porcentaje);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(contribuyenteServicio, ContribuyenteServicioDTO.class));
    }

    @Override
    public Optional<ContribuyenteServicioDTO> findByContribuyente(Contribuyente contribuyente) {
        return Optional.empty();
    }

    @Override
    public Optional<ContribuyenteServicioDTO> findByServicio(Servicio servicio) {
        return Optional.empty();
    }

    @Override
    public ContribuyenteServicioDTO create(ContribuyenteServicioDTO contribuyenteServicioDTO) {
        ContribuyenteServicio contribuyenteServicio = MapperUtils.EntityFromDto(contribuyenteServicioDTO, ContribuyenteServicio.class);
        contribuyenteServicio = contribuyenteServicioRepository.save(contribuyenteServicio);
        return MapperUtils.DtoFromEntity(contribuyenteServicio, ContribuyenteServicioDTO.class);
    }

    private ContribuyenteServicioDTO getSavedContribuyenteServicioDTO(ContribuyenteServicioDTO contribuyenteServicioDTO) {
        ContribuyenteServicio contribuyenteServicio = MapperUtils.EntityFromDto(contribuyenteServicioDTO, ContribuyenteServicio.class);
        ContribuyenteServicio contribuyenteServicioCreated = contribuyenteServicioRepository.save(contribuyenteServicio);
        return MapperUtils.DtoFromEntity(contribuyenteServicioCreated, ContribuyenteServicioDTO.class);
    }

    @Override
    public Optional<ContribuyenteServicioDTO> update(ContribuyenteServicioDTO contribuyenteServicioDTO, Long id) {
        if (contribuyenteServicioRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedContribuyenteServicioDTO(contribuyenteServicioDTO));
    }

    @Override
    public void delete(Long id) {
        contribuyenteServicioRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        contribuyenteServicioRepository.deleteAll();
    }
}
