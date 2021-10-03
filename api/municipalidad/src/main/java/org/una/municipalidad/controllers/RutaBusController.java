package org.una.municipalidad.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.CobroCanceladoDTO;
import org.una.municipalidad.dto.RutaBusDTO;
import org.una.municipalidad.services.IRutaBusService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rutasBus")
public class RutaBusController {

    @Autowired
    private IRutaBusService rutaBusService;

    @ApiOperation(value = "Obtiene una lista de todos las rutas de bus", response = RutaBusDTO.class, responseContainer = "List", tags = "RutaBus")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<RutaBusDTO>> result = rutaBusService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una ruta de bus a partir de su id", response = RutaBusDTO.class, tags = "RutaBus")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<RutaBusDTO> rutaBusFound = rutaBusService.findById(id);
        return new ResponseEntity<>(rutaBusFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una ruta de bus a partir de su nombre", response = RutaBusDTO.class, tags = "RutaBus")
    @GetMapping("/nombre/{term}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "term") String term) {
        Optional<List<RutaBusDTO>> result = rutaBusService.findByNombre(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una ruta de bus a partir de su inicio", response = RutaBusDTO.class, tags = "RutaBus")
    @GetMapping("/inicio/{term}")
    public ResponseEntity<?> findByInicio(@PathVariable(value = "term") String term) {
        Optional<List<RutaBusDTO>> result = rutaBusService.findByInicio(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una ruta de bus a partir de su final", response = RutaBusDTO.class, tags = "RutaBus")
    @GetMapping("/fin/{term}")
    public ResponseEntity<?> findByFinal(@PathVariable(value = "term") String term) {
        Optional<List<RutaBusDTO>> result = rutaBusService.findByFinal(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea una ruta de bus", response = RutaBusDTO.class, tags = "RutaBus")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody RutaBusDTO rutaBusDTO) {
        Optional<RutaBusDTO> rutaBusCreated = rutaBusService.create(rutaBusDTO);
        return new ResponseEntity<>(rutaBusCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Se modifica una ruta de bus a partir de su id", response = RutaBusDTO.class, tags = "RutaBus")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody RutaBusDTO rutaBusModified) {
        Optional<RutaBusDTO> rutaBusUpdated = rutaBusService.update(rutaBusModified, id);
        return new ResponseEntity<>(rutaBusModified, HttpStatus.OK);
    }

    @ApiOperation(value = "Se elimina una ruta de bus a partir de su id", response = RutaBusDTO.class, tags = "RutaBus")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        rutaBusService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Se eliminan todos las rutas de bus", response = RutaBusDTO.class, tags = "RutaBus")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        rutaBusService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
