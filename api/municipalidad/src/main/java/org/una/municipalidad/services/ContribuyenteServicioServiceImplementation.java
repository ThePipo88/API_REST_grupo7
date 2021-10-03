package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContribuyenteServicioServiceImplementation implements IContribuyenteServicioService {

    @Autowired
    private IContribuyenteServicioService iContribuyenteServicioService;
}
