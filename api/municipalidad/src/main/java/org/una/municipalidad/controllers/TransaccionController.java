package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.TipoDerechoDTO;
import org.una.municipalidad.dto.TransaccionDTO;
import org.una.municipalidad.dto.UsuarioDTO;
import org.una.municipalidad.services.ITransaccionService;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transferencias")
@Api(tags = {"Transferencias"})
public class TransaccionController {

    @Autowired
    private ITransaccionService transaccionService;

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    @ApiOperation(value = "Obtiene una transaccion a partir de su id", response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<TransaccionDTO> usuarioFound = transaccionService.findById(id);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    @ApiOperation(value = "Obtiene una lista de todos las trasacciones", response = TransaccionDTO.class, responseContainer = "List", tags = "Transacciones")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<TransaccionDTO>> result = transaccionService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    @GetMapping("/byIdAndFecha/{id}/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de transacciones de acuerdo al usuario y dos fechas dadas", response = TransaccionDTO.class, responseContainer = "TransaccionDto", tags = "Transacciones")
    public ResponseEntity<?> findByUsuarioIdAndFechaCreacionBetween(@PathVariable(value = "id") Long id, @PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable(value = "endDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        Optional<List<TransaccionDTO>> result = transaccionService.findByUsuarioIdAndFechaCreacionBetween(id,startDate,endDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    @GetMapping("/byObjetoAndFecha/{id}/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de transacciones de acuerdo al objeto y fecha de creacion", response = TransaccionDTO.class, responseContainer = "TransaccionDto", tags = "Transacciones")
    public ResponseEntity<?> findByObjetoAndFechaCreacionBetween(@PathVariable(value = "id") String id, @PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable(value = "endDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        Optional<List<TransaccionDTO>> result = transaccionService.findByObjetoAndFechaCreacionBetween(id,startDate,endDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    @GetMapping("/byFechaCreacion/{startDate}/{endDate}")
    @ApiOperation(value = "Obtiene una lista de transacciones entre dos fechas dadas", response = TransaccionDTO.class, responseContainer = "TransaccionDto", tags = "Transacciones")
    public ResponseEntity<?> findByFechaCreacionBetween(@PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable(value = "endDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        Optional<List<TransaccionDTO>> result = transaccionService.findByFechaCreacionBetween(startDate,endDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea una transaccion", response = TransaccionDTO.class, tags = "Transacciones")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TransaccionDTO transaccionDTO) {
        TransaccionDTO transaccionCreated = transaccionService.create(transaccionDTO);
        TransaccionDTO transaccionDto = MapperUtils.DtoFromEntity(transaccionCreated, TransaccionDTO.class);
        return new ResponseEntity<>(transaccionDto, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @ApiOperation(value = "Se modifica una lista de transacciones a partir de su id", response = TransaccionDTO.class, tags = "Transacciones")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody TransaccionDTO tipoDerechoModified) {
        Optional<TransaccionDTO> listaSalidaUpdated = transaccionService.update(tipoDerechoModified, id);
        return new ResponseEntity<>(listaSalidaUpdated, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @ApiOperation(value = "Se elimina una transaccion a partir de su id", response = TransaccionDTO.class, tags = "Transacciones")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        transaccionService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GESTOR')")
    @ApiOperation(value = "Se eliminan todas las transacciones", response = TransaccionDTO.class, tags = "Transacciones")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        transaccionService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
