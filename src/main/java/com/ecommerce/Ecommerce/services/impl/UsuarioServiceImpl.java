package com.ecommerce.Ecommerce.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce.dtos.UsuarioDTO;
import com.ecommerce.Ecommerce.models.Usuario;
import com.ecommerce.Ecommerce.repositories.UsuarioRepository;
import com.ecommerce.Ecommerce.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	private final UsuarioRepository repository;

	@Override
	public boolean saveUsuario(Usuario usuario) {
		try {
			repository.save(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Usuario findById(String id) {
		try {
			Long idFinal = Long.parseLong(id);
			return repository.findById(idFinal).orElse(null);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean actualizarUsuario(Usuario usuario, UsuarioDTO userDto) {
		if (!userDto.getContrasenia().equals("")) {
			usuario.setContrasenia(userDto.getContrasenia());
		}
		if (!userDto.getUsuario().equals("")) {
			usuario.setUsuario(userDto.getUsuario());
		}
		if (userDto.getDireccion() != null) {
			usuario.setDireccion(userDto.getDireccion());
		}
		if (!userDto.getDni().equals("")) {
			usuario.setDni(userDto.getDni());
		}
		if (!userDto.getNombre().equals("")) {
			usuario.setNombre(userDto.getNombre());
		}
		return saveUsuario(usuario);
	}

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {
		this.repository =repository;
	}

	@Override
	public void eliminarUsuarios() {
		repository.deleteAll();
	}
}
