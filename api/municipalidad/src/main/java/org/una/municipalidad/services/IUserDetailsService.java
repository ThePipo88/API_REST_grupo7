package org.una.municipalidad.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.una.municipalidad.entities.Usuario;
import org.una.municipalidad.repositories.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IUserDetailsService   {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioBuscado = IUsuarioRepository.findByCedula(username);
        if (usuarioBuscado.isPresent()) {
            Usuario usuario = usuarioBuscado.get();
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("ADMIN"));
            UserDetails userDetails = new User(usuario.getCedula(), usuario.getPasswordEncriptado(), roles);
            return userDetails;
        } else {
            throw new UsernameNotFoundException("Username not found, check your request");
        }
    }

}
