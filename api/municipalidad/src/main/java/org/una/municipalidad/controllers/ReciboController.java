package org.una.municipalidad.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.PropiedadDTO;
import org.una.municipalidad.dto.ReciboDTO;
import org.una.municipalidad.entities.Recibo;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.services.IReciboService;
import org.una.municipalidad.services.IRutaBusService;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recibos")
public class ReciboController {

    @Autowired
    private IReciboService reciboService;

    @ApiOperation(value = "Obtiene una lista de todos los recibos", response = ReciboDTO.class, responseContainer = "List", tags = "Recibos")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ReciboDTO>> result = reciboService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un recibo a partir de su id", response = ReciboDTO.class, tags = "Recibos")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ReciboDTO> reciboFound = reciboService.findById(id);
        return new ResponseEntity<>(reciboFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de recibos a partir de un contribuyente", response = ReciboDTO.class, responseContainer = "List", tags = "Recibos")
    @GetMapping("/contribuyente/{term}")
    public ResponseEntity<?> findByContribuyente(@PathVariable(value = "term") String term) {
        Optional<List<ReciboDTO>> result = reciboService.findByContribuyente(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de recibos a partir de una fecha de emision", response = ReciboDTO.class, responseContainer = "List", tags = "Recibos")
    @GetMapping("/fechaEmision/{fecha}")
    public ResponseEntity<?> findByFechaEmision(@PathVariable(value = "fecha") Date fecha) {
        Optional<List<ReciboDTO>> result = reciboService.findByFechaEmision(fecha);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea un recibo", response = ReciboDTO.class, tags = "Recibos")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ReciboDTO reciboDTO) {
        Optional<ReciboDTO> reciboCreated = Optional.ofNullable(reciboService.create(reciboDTO));
        return new ResponseEntity<>(reciboCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Se modifica un recibo a partir de su id", response = ReciboDTO.class, tags = "Recibos")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ReciboDTO reciboDTO) {
        Optional<ReciboDTO> propiedadUpdated = reciboService.update(reciboDTO, id);
        return new ResponseEntity<>(propiedadUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Se elimina un recibo a partir de su id", response = ReciboDTO.class, tags = "Recibos")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        reciboService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Se eliminan todos los recibos", response = ReciboDTO.class, tags = "Recibos")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        reciboService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}