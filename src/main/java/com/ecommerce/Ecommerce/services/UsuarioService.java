package com.ecommerce.Ecommerce.services;

import java.util.List;

import com.ecommerce.Ecommerce.dtos.UsuarioDTO;
import com.ecommerce.Ecommerce.models.Usuario;

public interface UsuarioService {

	boolean saveUsuario(Usuario usuario);
	
	Usuario findById(String id);
	
	List<Usuario> findAll();
	
	boolean actualizarUsuario(Usuario usuario, UsuarioDTO userDTO);

	void eliminarUsuarios();
}
