package com.ecommerce.Ecommerce.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce.dtos.UsuarioDTO;
import com.ecommerce.Ecommerce.models.Usuario;
import com.ecommerce.Ecommerce.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private final UsuarioService userService;
	
	
	@GetMapping
	public List<Usuario> allUsuarios() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public Usuario usuario(@PathVariable String id) {
		return userService.findById(id);
	}

	@PutMapping(path="/crear", consumes="application/json")
	public boolean saveUsuario(@RequestBody UsuarioDTO user) {
		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(user, usuario);
		return userService.saveUsuario(usuario);
	}

	@PostMapping("/{id}/actualizar")
	public boolean update(@RequestBody UsuarioDTO userDto, @PathVariable String id) {
		try {
			Usuario usuario = userService.findById(id);
			return userService.actualizarUsuario(usuario, userDto);
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	@DeleteMapping("/all")
	public void delete() {
		userService.eliminarUsuarios();
	}

	@Autowired
	public UsuarioController(UsuarioService userService) {
		this.userService = userService;
	} 
}
