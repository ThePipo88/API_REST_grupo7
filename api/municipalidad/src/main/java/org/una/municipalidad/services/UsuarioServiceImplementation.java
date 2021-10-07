package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.UsuarioDTO;
import org.una.municipalidad.entities.Usuario;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.exceptions.PasswordIsBlankException;
import org.una.municipalidad.repositories.IUsuarioRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplementation implements IUsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> usuarioDTOList = MapperUtils.DtoListFromEntityList(usuarioRepository.findAll(), UsuarioDTO.class);
        return Optional.ofNullable(usuarioDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) throw new NotFoundInformationException();

        UsuarioDTO usuarioDTO = MapperUtils.DtoFromEntity(usuario.get(), UsuarioDTO.class);
        return Optional.ofNullable(usuarioDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuarioDTO>> findByCedulaAproximate(String cedula) {
        List<Usuario> usuarioList = usuarioRepository.findByCedulaContaining(cedula);
        List<UsuarioDTO> usuarioDTOList = MapperUtils.DtoListFromEntityList(usuarioList, UsuarioDTO.class);
        return Optional.ofNullable(usuarioDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findByCedula(String cedula) {
        Usuario usuario = usuarioRepository.findByCedula(cedula);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(usuario, UsuarioDTO.class));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuarioDTO>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto) {
        List<Usuario> usuarioList = usuarioRepository.findByNombreCompletoContainingIgnoreCase(nombreCompleto);
        List<UsuarioDTO> usuarioDTOList = MapperUtils.DtoListFromEntityList(usuarioList, UsuarioDTO.class);
        return Optional.ofNullable(usuarioDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findNombreCompletoWithLikeSQL(@Param("nombreCompleto")String nombreCompleto) {
        Usuario usuario = usuarioRepository.findNombreCompletoWithLikeSQL(nombreCompleto);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(usuario, UsuarioDTO.class));
    }

    private UsuarioDTO getSavedUsuarioDTO(UsuarioDTO usuarioDTO) {
        Usuario usuario = MapperUtils.EntityFromDto(usuarioDTO, Usuario.class);
        Usuario usuarioCreated = usuarioRepository.save(usuario);
        return MapperUtils.DtoFromEntity(usuarioCreated, UsuarioDTO.class);
    }

    @Override
    @Transactional
    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        Usuario usuario = MapperUtils.EntityFromDto(usuarioDTO, Usuario.class);
        usuario = usuarioRepository.save(usuario);
        return MapperUtils.DtoFromEntity(usuario, UsuarioDTO.class);
    }

    @Override
    @Transactional
    public Optional<UsuarioDTO> update(UsuarioDTO usuarioDTO, Long id) {
        if (usuarioRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedUsuarioDTO(usuarioDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        usuarioRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> login(String cedula, String password) {
        Usuario usuario = usuarioRepository.findByCedulaAndPasswordEncriptado(cedula, password);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(usuario, UsuarioDTO.class));


    }
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private String encriptarPassword(String password) throws PasswordIsBlankException {
        if (!password.isBlank()) {
            return bCryptPasswordEncoder.encode(password);
        }else{
            throw new PasswordIsBlankException();
        }
    } // TODO: Piense donde se debe llamar esta función


}
