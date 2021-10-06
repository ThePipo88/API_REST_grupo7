package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.municipalidad.entities.Rol;
import org.una.municipalidad.entities.Usuario;
import org.una.municipalidad.repositories.IRolRepository;
import org.una.municipalidad.repositories.IUsuarioRepository;

@Service
public class DataInitializerServiceImplementation implements IDataInitializerService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public void initDevelopData() {



        Rol colaboradorRol =  rolRepository.save(Rol.builder().nombre("Colaborador").build());
        Rol usuarioRol =  rolRepository.save(Rol.builder().nombre("Usuario").build());
        Rol auditorRol =  rolRepository.save(Rol.builder().nombre("Auditor").build());
        Rol contadorRol =  rolRepository.save(Rol.builder().nombre("Contador").build());
        Rol administradorRol =  rolRepository.save(Rol.builder().nombre("Administrador").build());


        Usuario cajeroUsuario = new Usuario();
        cajeroUsuario.setCedula("0123456789");
        cajeroUsuario.setNombreCompleto("Usuario Prueba cajero");
        cajeroUsuario.setPasswordEncriptado("Una2021");
        cajeroUsuario.setRol(usuarioRol);
        usuarioRepository.save(cajeroUsuario);


    }

    @Override
    public void deleteAllData() {
        rolRepository.deleteAll();
        usuarioRepository.deleteAll();

    }

}

