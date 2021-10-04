package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.CobroCanceladoDTO;
import org.una.municipalidad.dto.ContribuyenteDTO;
import org.una.municipalidad.dto.ParametroDTO;
import org.una.municipalidad.services.IParametroService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parametros")
@Api(tags = {"Parametros"})
public class ParametroController {

    @Autowired
    private IParametroService parametroService;

    @ApiOperation(value = "Obtiene una lista de todos los parametros", response = ParametroDTO.class, responseContainer = "List", tags = "Parametro")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ParametroDTO>> result = parametroService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un parametro a partir de su id", response = ParametroDTO.class, tags = "Parametro")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ParametroDTO> parametroFound = parametroService.findById(id);
        return new ResponseEntity<>(parametroFound, HttpStatus.OK);
    }

    @GetMapping("/findByFormulaAproximate/{formula}")
    @ApiOperation(value = "Obtiene un parametro de acuerdo a su formula", response = ParametroDTO.class, responseContainer = "ParametroDTO", tags = "Parametro")
    public ResponseEntity<?> findByFormulaAproximate(@PathVariable(value = "formula") String formula) {
        Optional<List<ParametroDTO>> result = parametroService.findByFormulaAproximate(formula);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findByNombreAproximate/{nombre}")
    @ApiOperation(value = "Obtiene un parametro de acuerdo a su nombre", response = ParametroDTO.class, responseContainer = "ParametroDTO", tags = "Parametro")
    public ResponseEntity<?> findByNombreAproximate(@PathVariable(value = "nombre") String nombre) {
        Optional<List<ParametroDTO>> result = parametroService.findByNombreAproximate(nombre);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findByestadoAproximate/{estado}")
    @ApiOperation(value = "Obtiene un parametro de acuerdo a su estado", response = ParametroDTO.class, responseContainer = "ParametroDTO", tags = "Parametro")
    public ResponseEntity<?> findByestadoAproximate(@PathVariable(value = "estado") boolean estado) {
        Optional<List<ParametroDTO>> result = parametroService.findByestadoAproximate(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findByFechaCreacionBetween/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de parametros de acuerdo a su fecha de creacion", response = ParametroDTO.class, responseContainer = "ParametroDTO", tags = "Parametro")
    public ResponseEntity<?> findByFechaCreacionBetween(@PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        Optional<List<ParametroDTO>> result = parametroService.findByFechaCreacionBetween(startDate,endDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findByFechaModificacionBetween/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de cobros cancelados de acuerdo a su fecha de modificacion", response = ParametroDTO.class, responseContainer = "List", tags = "Parametros")
    public ResponseEntity<?> findByFechaModificacionBetween(@PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        Optional<List<ParametroDTO>> result = parametroService.findByFechaModificacionBetween(startDate,endDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea un parametro", response = ParametroDTO.class, tags = "Parametro")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ParametroDTO parametroDTO) {
        Optional<ParametroDTO> parametroCreated = Optional.ofNullable(parametroService.create(parametroDTO));
        return new ResponseEntity<>(parametroCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Se modifica un parametro a partir de su id", response = ParametroDTO.class, tags = "Parametro")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ParametroDTO parametroDTO) {
        Optional<ParametroDTO> parametroUpdated = parametroService.update(parametroDTO, id);
        return new ResponseEntity<>(parametroUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Se elimina un parametro a partir de su id", response = ParametroDTO.class, tags = "Parametro")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        parametroService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Se eliminan todos los parametros", response = ParametroDTO.class, tags = "Parametro")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        parametroService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
