package org.una.municipalidad.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.ExcepcionDTO;
import org.una.municipalidad.dto.ListaSalidaDTO;
import org.una.municipalidad.dto.PropiedadDTO;
import org.una.municipalidad.entities.Excepcion;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.services.IExcepcionService;
import org.una.municipalidad.services.IListaSalidaService;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/excepciones")
public class ExcepcionController {

    @Autowired
    private IExcepcionService excepcionService;

    @ApiOperation(value = "Obtiene una lista de todas las excepcioness", response = ExcepcionDTO.class, responseContainer = "List", tags = "Excepciones")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ExcepcionDTO>> result = excepcionService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una excepcion a partir de su id", response = ExcepcionDTO.class, tags = "Excepciones")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ExcepcionDTO> excepcionFound = excepcionService.findById(id);
        return new ResponseEntity<>(excepcionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de excepciones a partir del id de un usuario", response = ExcepcionDTO.class, tags = "Excepciones")
    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> findByUsuario(@PathVariable(value = "id") Long id) {
        Optional<List<ExcepcionDTO>> result = excepcionService.findByUsuario(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de excepciones a partir del id de un usuario", response = ExcepcionDTO.class, tags = "Excepciones")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findByUsuario(@PathVariable(value = "term") String term) {
        Optional<List<ExcepcionDTO>> result = excepcionService.findByEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de excepciones a partir de la fecha de creacion", response = ExcepcionDTO.class, tags = "Excepciones")
    @GetMapping("/fechaCreacion/{fecha}")
    public ResponseEntity<?> findByFechaCreacion(@PathVariable(value = "fecha") Date fecha) {
        Optional<List<ExcepcionDTO>> result = excepcionService.findByFechaCreacion(fecha);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea una excepcion", response = ExcepcionDTO.class, tags = "Excepciones")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ExcepcionDTO excepcionDTO) {
        Optional<ExcepcionDTO> excepcionCreated = Optional.ofNullable(excepcionService.create(excepcionDTO));
        return new ResponseEntity<>(excepcionCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Se modifica una excepcion a partir de su id", response = ExcepcionDTO.class, tags = "Excepciones")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ExcepcionDTO excepcionModified) {
        Optional<ExcepcionDTO> excepcionesUpdated = excepcionService.update(excepcionModified, id);
        return new ResponseEntity<>(excepcionesUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Se elimina una excepcion a partir de su id", response = ExcepcionDTO.class, tags = "Excepciones")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        excepcionService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Se eliminan todos las excepciones", response = ExcepcionDTO.class, tags = "Excepciones")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        excepcionService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}