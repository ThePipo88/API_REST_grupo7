package org.una.municipalidad.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.ContribuyenteServicioDTO;
import org.una.municipalidad.services.IContribuyenteServicioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contribuyentesServicios")
public class ContribuyenteServicioController {

    @Autowired
    private IContribuyenteServicioService contribuyenteServicioService;

    @ApiOperation(value = "Obtiene una lista de todos los servicios de los contribuyentes", response = ContribuyenteServicioDTO.class, responseContainer = "List", tags = "ContribuyenteServicio")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ContribuyenteServicioDTO>> result = contribuyenteServicioService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un servicio contribuyente a partir de su id", response = ContribuyenteServicioDTO.class, tags = "ContribuyenteServicio")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ContribuyenteServicioDTO> contribuyenteServicioFound = contribuyenteServicioService.findById(id);
        return new ResponseEntity<>(contribuyenteServicioFound, HttpStatus.OK);
    }

    @GetMapping("/ByPorcentaje/{porcentaje}")
    @ApiOperation(value = "Obtiene un contribuyente de acuerdo a su porcentaje de servicio", response = ContribuyenteServicioDTO.class, responseContainer = "ContribuyenteServicioDTO", tags = "ContribuyenteServicio")
    public ResponseEntity<?> findByPorcentaje(@PathVariable(value = "porcentaje") String porcentaje) {
        Optional<ContribuyenteServicioDTO> contribuyenteServicioFound = contribuyenteServicioService.findByPorcentaje(porcentaje);
        return new ResponseEntity<>(contribuyenteServicioFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Se crea un servicio de contribuyente", response = ContribuyenteServicioDTO.class, tags = "ContribuyenteServicio")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ContribuyenteServicioDTO contribuyenteServicioDTO) {
        Optional<ContribuyenteServicioDTO> contribuyenteServicioCreated = Optional.ofNullable(contribuyenteServicioService.create(contribuyenteServicioDTO));
        return new ResponseEntity<>(contribuyenteServicioCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Se modifica un servicio de contribuyente a partir de su id", response = ContribuyenteServicioDTO.class, tags = "ContribuyenteServicio")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ContribuyenteServicioDTO contribuyenteServicioDTO) {
        Optional<ContribuyenteServicioDTO> contribuyenteServicioUpdated = contribuyenteServicioService.update(contribuyenteServicioDTO, id);
        return new ResponseEntity<>(contribuyenteServicioUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Se elimina un servicio de contribuyente a partir de su id", response = ContribuyenteServicioDTO.class, tags = "ContribuyenteServicio")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        contribuyenteServicioService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Se eliminan todos los servicios de contribuyentes", response = ContribuyenteServicioDTO.class, tags = "ContribuyenteServicio")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        contribuyenteServicioService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
