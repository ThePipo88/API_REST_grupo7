package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.CobroCanceladoDTO;
import org.una.municipalidad.dto.CobroGeneradoDTO;
import org.una.municipalidad.services.ICobroGeneradoService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cobrosGenerados")
@Api(tags = {"CobrosGenerados"})
public class CobroGeneradoController {
    @Autowired
    private ICobroGeneradoService cobroGeneradoService;

    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE') or hasRole('AUDITOR')")
    @ApiOperation(value = "Obtiene una lista de todos los cobros generados", response = CobroGeneradoDTO.class, responseContainer = "List", tags = "CobroGenerado")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<CobroGeneradoDTO>> result = cobroGeneradoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE') or hasRole('AUDITOR')")
    @ApiOperation(value = "Obtiene un cobro generado a partir de su id", response = CobroGeneradoDTO.class, tags = "CobroGenerado")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CobroGeneradoDTO> cobroGeneradoFound = cobroGeneradoService.findById(id);
        return new ResponseEntity<>(cobroGeneradoFound, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE') or hasRole('AUDITOR')")
    @ApiOperation(value = "Obtiene un cobro generado a partir de su monto", response = CobroGeneradoDTO.class, responseContainer = "List", tags = "CobroGenerado")
    @GetMapping("/monto/{term}")
    public ResponseEntity<?> findByMonto(@PathVariable(value = "term") Double term) {
        Optional<List<CobroGeneradoDTO>> result = cobroGeneradoService.findByMonto(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
     /*
    @GetMapping("/ByObjetoAndFechaCobroBetween/{id}/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de cobros generados de acuerdo al objeto y fecha de Cobro", response = CobroGeneradoDTO.class, responseContainer = "CobroGeneradoDTO", tags = "CobroGenerado")
    public ResponseEntity<?> findByObjetoAndFechaCobroBetween(@PathVariable(value = "id") String id, @PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        Optional<List<CobroGeneradoDTO>> result = cobroGeneradoService.findByObjetoAndFechaCobroBetween(id,startDate,endDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
     */
     @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE') or hasRole('AUDITOR')")
    @GetMapping("/ByFechaCobroBetween/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de cobros generados de acuerdo a su fecha de cobro", response = CobroGeneradoDTO.class, responseContainer = "CobroGeneradoDTO", tags = "CobroGenerado")
    public ResponseEntity<?> findByFechaCobroBetween(@PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        Optional<List<CobroGeneradoDTO>> result = cobroGeneradoService.findByFechaCobroBetween(startDate,endDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea un cobro generado", response = CobroGeneradoDTO.class, tags = "CobroGenerado")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CobroGeneradoDTO cobroGeneradoDTO) {
        Optional<CobroGeneradoDTO> cobroGeneradoCreated = Optional.ofNullable(cobroGeneradoService.create(cobroGeneradoDTO));
        return new ResponseEntity<>(cobroGeneradoCreated, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @ApiOperation(value = "Se modifica un cobro generado a partir de su id", response = CobroGeneradoDTO.class, tags = "CobroGenerado")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CobroGeneradoDTO cobroGeneradoModified) {
        Optional<CobroGeneradoDTO> cobroGeneradoUpdated = cobroGeneradoService.update(cobroGeneradoModified, id);
        return new ResponseEntity<>(cobroGeneradoModified, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @ApiOperation(value = "Se elimina un cobro generado a partir de su id", response = CobroGeneradoDTO.class, tags = "CobroGenerado")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        cobroGeneradoService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @ApiOperation(value = "Se eliminan todos los cobros generados", response = CobroGeneradoDTO.class, tags = "CobroGenerado")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        cobroGeneradoService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
