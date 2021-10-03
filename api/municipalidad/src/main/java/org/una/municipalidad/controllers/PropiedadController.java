package org.una.municipalidad.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.PropiedadDTO;
import org.una.municipalidad.dto.UsuarioDTO;
import org.una.municipalidad.entities.Propiedad;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.services.IPropiedadService;
import org.una.municipalidad.services.IUsuarioService;
import org.una.municipalidad.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/propiedades")
public class PropiedadController {

    @Autowired
    private IPropiedadService propiedadService;

    @ApiOperation(value = "Obtiene una lista de todos las propiedades", response = PropiedadDTO.class, responseContainer = "List", tags = "Propiedades")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<PropiedadDTO>> result = propiedadService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una propiedad a partir de su id", response = PropiedadDTO.class, tags = "Propiedades")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<PropiedadDTO> propiedadFound = propiedadService.findById(id);
        return new ResponseEntity<>(propiedadFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de propiedades a partir de su provincia", response = PropiedadDTO.class, responseContainer = "List", tags = "Propiedades")
    @GetMapping("/provincia/{term}")
    public ResponseEntity<?> findByProvincia(@PathVariable(value = "term") String term) {
        Optional<List<PropiedadDTO>> result = propiedadService.findByProvincia(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de propiedades a partir de su canton", response = PropiedadDTO.class, responseContainer = "List", tags = "Propiedades")
    @GetMapping("/canton/{term}")
    public ResponseEntity<?> findByCanton(@PathVariable(value = "term") String term) {
        Optional<List<PropiedadDTO>> result = propiedadService.findByCanton(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de propiedades a partir de su distrito", response = PropiedadDTO.class, responseContainer = "List", tags = "Propiedades")
    @GetMapping("/distrito/{term}")
    public ResponseEntity<?> findByDistrito(@PathVariable(value = "term") String term) {
        Optional<List<PropiedadDTO>> result = propiedadService.findByDistrito(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @ApiOperation(value = "Obtiene una lista de zonas a partir de su distrito", response = PropiedadDTO.class, responseContainer = "List", tags = "Propiedades")
    @GetMapping("/zona/{term}")
    public ResponseEntity<?> findByZona(@PathVariable(value = "term") String term) {
        Optional<List<PropiedadDTO>> result = propiedadService.findByZona(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea una propiedad", response = PropiedadDTO.class, tags = "Propiedad")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody PropiedadDTO propiedadDTO) {
        Optional<PropiedadDTO> propiedadCreated = Optional.ofNullable(propiedadService.create(propiedadDTO));
        return new ResponseEntity<>(propiedadCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Se modifica una propiedad a partir de su id", response = PropiedadDTO.class, tags = "Propiedad")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PropiedadDTO propiedadModified) {
        Optional<PropiedadDTO> propiedadUpdated = propiedadService.update(propiedadModified, id);
        return new ResponseEntity<>(propiedadUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Se elimina una propiedad a partir de su id", response = PropiedadDTO.class, tags = "Propiedad")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        propiedadService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Se eliminan todas las propiedades", response = PropiedadDTO.class, tags = "Propiedades")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        propiedadService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
