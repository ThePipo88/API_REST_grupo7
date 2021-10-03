package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParametroServiceImplementation implements IParametroService{

    @Autowired
    private IParametroService iParametroService;
}
