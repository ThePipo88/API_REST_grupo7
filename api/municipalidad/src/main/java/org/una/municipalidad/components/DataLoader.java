package org.una.municipalidad.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.municipalidad.dto.RolDTO;
import org.una.municipalidad.dto.UsuarioDTO;
import org.una.municipalidad.services.IRolService;
import org.una.municipalidad.services.IUsuarioService;

import java.util.Optional;

@Component
public class DataLoader implements ApplicationRunner {

    @Value("${app.admin-user}")
    private String cedula;

    @Value("${app.password}")
    private String password;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IRolService rolService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        if(usuarioService.findByCedulaAproximate(cedula).get().size() == 0){

            System.out.println("Se metio aqui");

            Optional<RolDTO> colaboradorRol = Optional.ofNullable(rolService.create(RolDTO.builder().nombre("COLABORADOR").build()));
            Optional<RolDTO> auditorRol = Optional.ofNullable(rolService.create(RolDTO.builder().nombre("AUDITOR").build()));
            Optional<RolDTO> contadorRol = Optional.ofNullable(rolService.create(RolDTO.builder().nombre("CONTADOR").build()));
            Optional<RolDTO> usuarioRol = Optional.ofNullable(rolService.create(RolDTO.builder().nombre("USUARIO").build()));
            Optional<RolDTO> administradorRol = Optional.ofNullable(rolService.create(RolDTO.builder().nombre("ADMINISTRADOR").build()));


            UsuarioDTO cajeroUsuario = UsuarioDTO.builder()
                    .cedula("0123456789")
                    .nombreCompleto("Usuario Prueba Cajero")
                    .passwordEncriptado("Una2021")
                    .rol(usuarioRol.orElseThrow()).build();
            usuarioService.create(cajeroUsuario);

            UsuarioDTO contadorUsuario = UsuarioDTO.builder()
                    .cedula("9876543210")
                    .nombreCompleto("Usuario Prueba Contador")
                    .passwordEncriptado("Una2021")
                    .rol(contadorRol.orElseThrow()).build();
            usuarioService.create(contadorUsuario);

            UsuarioDTO administradorUsuario = UsuarioDTO.builder()
                    .cedula(cedula)
                    .nombreCompleto("Usuario Administrador")
                    .passwordEncriptado(password)
                    .rol(administradorRol.orElseThrow()).build();
            usuarioService.create(administradorUsuario);

            System.out.println("Se agrega el usuario inicial a la aplicación");
        }else{
            System.out.println("Usuario existente");
        }
    }
}
