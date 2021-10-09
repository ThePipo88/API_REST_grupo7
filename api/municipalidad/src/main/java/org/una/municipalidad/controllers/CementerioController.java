package org.una.municipalidad.controllers;
import java.util.List;
import java.util.Optional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.CementerioDTO;
import org.una.municipalidad.services.ICementerioService;

    @RestController
    @RequestMapping("/cementerio")
    @Api(tags = {"Cementerio"})
    public class CementerioController {

        @Autowired
        private ICementerioService cementerioService;

        @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE') or hasRole('AUDITOR')")
        @ApiOperation(value = "Obtiene una lista de todos las los tipos de derecho", response = CementerioDTO.class, responseContainer = "List", tags = "Cementerio")
        @GetMapping()
        public @ResponseBody
        ResponseEntity<?> findAll() {
            Optional<List<CementerioDTO>> result = cementerioService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE') or hasRole('AUDITOR')")
        @ApiOperation(value = "Obtiene un derecho de cementerio a partir de su id", response = CementerioDTO.class, tags = "Cementerio")
        @GetMapping("/{id}")
        public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
            Optional<CementerioDTO> rutaBusFound = cementerioService.findById(id);
            return new ResponseEntity<>(rutaBusFound, HttpStatus.OK);
        }

        @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE') or hasRole('AUDITOR')")
        @ApiOperation(value = "Obtiene un derecho de cementerio a partir de su sector", response = CementerioDTO.class, tags = "Cementerio")
        @GetMapping("/sector/{term}")
        public ResponseEntity<?> findByNombre(@PathVariable(value = "term") String term) {
            Optional<List<CementerioDTO>> result = cementerioService.findBySector(term);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
        @ApiOperation(value = "Obtiene una ruta de bus a partir de si esta ocupado ", response = CementerioDTO.class, responseContainer = "List", tags = "Cementerio")
        @GetMapping("/ByOcupado/{ocupado}")
        public ResponseEntity<?> findByOcupado(@PathVariable(value = "ocupado") String ocupado) {
            Optional<List<CementerioDTO>> result = cementerioService.findByOcupado(ocupado);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        @PreAuthorize("hasRole('GESTOR')")
        @ResponseStatus(HttpStatus.OK)
        @ApiOperation(value = "Se crea un derecho de cementerio", response = CementerioDTO.class, tags = "RutaBus")
        @PostMapping("/")
        @ResponseBody
        public ResponseEntity<?> create(@RequestBody CementerioDTO cementerioDTO) {
            Optional<CementerioDTO> CemeterioCreated = cementerioService.create(cementerioDTO);
            return new ResponseEntity<>(CemeterioCreated, HttpStatus.CREATED);
        }

        @PreAuthorize("hasRole('GESTOR')")
        @ApiOperation(value = "Se modifica un derecho de cementerio apartir de su id", response = CementerioDTO.class, tags = "Cementerio")
        @PutMapping("/{id}")
        @ResponseBody
        public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CementerioDTO cementerioModified) {
            Optional<CementerioDTO> cementerioUpdated = cementerioService.update(cementerioModified, id);
            return new ResponseEntity<>(cementerioModified, HttpStatus.OK);
        }

        @PreAuthorize("hasRole('GESTOR')")
        @ApiOperation(value = "Se elimina un derecho de cementerio con du id", response = CementerioDTO.class, tags = "Cementerio")
        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
            cementerioService.delete(id);
            return new ResponseEntity<>("Ok", HttpStatus.OK);
        }

        @PreAuthorize("hasRole('GESTOR')")
        @ApiOperation(value = "Se eliminan todos los derechos de cementerio", response = CementerioDTO.class, tags = "Cementerio")
        @DeleteMapping("/")
        public ResponseEntity<?> deleteAll() throws Exception {
            cementerioService.deleteAll();
            return new ResponseEntity<>("Ok", HttpStatus.OK);
        }
}
