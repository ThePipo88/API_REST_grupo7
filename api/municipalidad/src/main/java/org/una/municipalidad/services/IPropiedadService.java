package org.una.municipalidad.services;

import org.una.municipalidad.dto.ExcepcionDTO;
import org.una.municipalidad.dto.PropiedadDTO;
import org.una.municipalidad.entities.Propiedad;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IPropiedadService {

    public Optional<List<PropiedadDTO>> findAll();

    public Optional<PropiedadDTO> findById(Long id);

    public Optional<List<PropiedadDTO>> findByProvincia(String provincia);

    public Optional<List<PropiedadDTO>> findByCanton(String canton);

    public Optional<List<PropiedadDTO>> findByDistrito(String distrito);

    public Optional<List<PropiedadDTO>> findByZona(String zona);

    public PropiedadDTO create(PropiedadDTO propiedadDTO);

    public Optional<PropiedadDTO> update(PropiedadDTO propiedadDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
