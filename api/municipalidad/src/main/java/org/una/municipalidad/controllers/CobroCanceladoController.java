package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.CobroCanceladoDTO;
import org.una.municipalidad.services.ICobroCanceladoService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cobrosCancelados")
@Api(tags = {"CobrosCancelados"})
public class CobroCanceladoController {

    @Autowired
    private ICobroCanceladoService cobroCanceladoService;

    @ApiOperation(value = "Obtiene una lista de todos los cobros cancelados", response = CobroCanceladoDTO.class, responseContainer = "List", tags = "CobroCancelado")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<CobroCanceladoDTO>> result = cobroCanceladoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un cobro cancelado a partir de su id", response = CobroCanceladoDTO.class, tags = "CobroCancelado")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CobroCanceladoDTO> cobroCanceladoFound = cobroCanceladoService.findById(id);
        return new ResponseEntity<>(cobroCanceladoFound, HttpStatus.OK);
    }
/*
    @GetMapping("/byObjetoAndFecha/{objetoId}/{startDate}")
    @ApiOperation(value = "Obtiene una lista de cobros cancelados de acuerdo al objeto y fecha de creacion", response = CobroCanceladoDTO.class, responseContainer = "CobroCanceladoDto", tags = "CobroCancelado")
    public ResponseEntity<?> findByObjetoAndFechaCreacionBetween(@PathVariable(value = "objetoId") String objetoId, @PathVariable(value = "startDate") Date startDate) {
        Optional<List<CobroCanceladoDTO>> result = cobroCanceladoService.findByObjetoAndFechaCreacionBetween(objetoId,startDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
*/
    @GetMapping("/byFechaCreacion/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de cobros cancelados de acuerdo a su fecha de creacion", response = CobroCanceladoDTO.class, responseContainer = "CobroCanceladoDto", tags = "CobroCancelado")
    public ResponseEntity<?> findByFechaCreacionBetween(@PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        Optional<List<CobroCanceladoDTO>> result = cobroCanceladoService.findByFechaCreacionBetween(startDate,endDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un cobro cancelado a partir de su descripcion", response = CobroCanceladoDTO.class, responseContainer = "List", tags = "CobroCancelado")
    @GetMapping("/descripcion/{term}")
    public ResponseEntity<?> findByDescripcion(@PathVariable(value = "term") String term) {
        Optional<List<CobroCanceladoDTO>> result = cobroCanceladoService.findByDescripcion(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea un cobro cancelado", response = CobroCanceladoDTO.class, tags = "CobroCancelado")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CobroCanceladoDTO cobroCanceladoDTO) {
        Optional<CobroCanceladoDTO> cobroCanceladoCreated = cobroCanceladoService.create(cobroCanceladoDTO);
        return new ResponseEntity<>(cobroCanceladoCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Se modifica un cobro cancelado a partir de su id", response = CobroCanceladoDTO.class, tags = "CobroCancelado")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CobroCanceladoDTO cobroCanceladoModified) {
        Optional<CobroCanceladoDTO> cobroCanceladoUpdated = cobroCanceladoService.update(cobroCanceladoModified, id);
        return new ResponseEntity<>(cobroCanceladoModified, HttpStatus.OK);
    }

    @ApiOperation(value = "Se elimina un cobro cancelado a partir de su id", response = CobroCanceladoDTO.class, tags = "CobroCancelado")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        cobroCanceladoService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Se eliminan todos los cobros cancelados", response = CobroCanceladoDTO.class, tags = "CobroCancelado")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        cobroCanceladoService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
