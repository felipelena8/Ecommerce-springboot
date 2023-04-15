package com.ecommerce.Ecommerce.dtos;

import com.ecommerce.Ecommerce.models.Direccion;

import lombok.Data;
@Data
public class UsuarioDTO {
	private String nombre;
	private String apellido;
	private String usuario;
	private String contrasenia;
	private String dni;
	private Direccion direccion;
}
