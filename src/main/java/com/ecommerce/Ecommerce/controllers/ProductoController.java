package com.ecommerce.Ecommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce.models.Producto;

@RestController
@RequestMapping(path = "/productos")
public class ProductoController {

	@GetMapping("/{id}")
	public Producto findProducto(@PathVariable String id) {
		return null;
		
	}
}
