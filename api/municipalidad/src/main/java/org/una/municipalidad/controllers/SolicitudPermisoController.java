package org.una.municipalidad.controllers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.TransaccionDTO;
import org.una.municipalidad.services.ITransaccionService;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/SolicitudPermiso")
@Api(tags = {"SolicitudPermiso"})
public class SolicitudPermisoController {


}
