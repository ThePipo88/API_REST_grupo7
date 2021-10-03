package org.una.municipalidad.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.CobroCanceladoDTO;
import org.una.municipalidad.dto.ReciboDTO;
import org.una.municipalidad.dto.RutaBusDTO;
import org.una.municipalidad.dto.ServicioDTO;
import org.una.municipalidad.entities.Servicio;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.services.IRutaBusService;
import org.una.municipalidad.services.IServicioService;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private IServicioService servicioService;

    @ApiOperation(value = "Obtiene una lista de todos los servicios", response = ServicioDTO.class, responseContainer = "List", tags = "Servicios")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ServicioDTO>> result = servicioService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un servicio partir de su id", response = ServicioDTO.class, tags = "Servicios")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ServicioDTO> servicioFound = servicioService.findById(id);
        return new ResponseEntity<>(servicioFound, HttpStatus.OK);
    }


    @ApiOperation(value = "Obtiene una lista de servicios a de bus a partir de su tipo", response = ServicioDTO.class, tags = "Servicios")
    @GetMapping("/servicio/{term}")
    public ResponseEntity<?> findByServicio(@PathVariable(value = "term") String term) {
        Optional<List<ServicioDTO>> result = servicioService.findByServicio(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de servicios a partir de un estado", response = ServicioDTO.class, tags = "Servicios")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "term") String term) {
        Optional<List<ServicioDTO>> result = servicioService.findByEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de servicios a partir de una propiedad", response = ServicioDTO.class, tags = "Servicios")
    @GetMapping("/propiedad/{id}")
    public ResponseEntity<?> findByPropiedad(@PathVariable(value = "id") Long id) {
        Optional<List<ServicioDTO>> result = servicioService.findByPropiedad(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de servicios a partir de una fecha", response = ServicioDTO.class, tags = "Servicios")
    @GetMapping("/fechaRegistro/{fecha}")
    public ResponseEntity<?> findByFechaRegitro(@PathVariable(value = "fecha") Date fecha) {
        Optional<List<ServicioDTO>> result = servicioService.findByFechaRegitro(fecha);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de servicios a partir de una ultima actualizacion", response = ServicioDTO.class, tags = "Servicios")
    @GetMapping("/fechaActualizacion/{fecha}")
    public ResponseEntity<?> findByUltimaActualizacion(@PathVariable(value = "fecha") Date fecha) {
        Optional<List<ServicioDTO>> result = servicioService.findByUltimaActualizacion(fecha);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea un servicio", response = ServicioDTO.class, tags = "Servicios")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ServicioDTO servicioDTO) {
        Optional<ServicioDTO> servicioCreated = Optional.ofNullable(servicioService.create(servicioDTO));
        return new ResponseEntity<>(servicioCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Se modifica un servicio a partir de su id", response = ServicioDTO.class, tags = "Servicios")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ServicioDTO servicioDTO) {
        Optional<ServicioDTO> servicioUpdated = servicioService.update(servicioDTO, id);
        return new ResponseEntity<>(servicioUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Se elimina un ervicio a partir de su id", response = ServicioDTO.class, tags = "Servicios")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        servicioService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Se eliminan todos los servicios", response = ReciboDTO.class, tags = "Servicios")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        servicioService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}