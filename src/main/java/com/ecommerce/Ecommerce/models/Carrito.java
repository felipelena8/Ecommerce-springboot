package com.ecommerce.Ecommerce.models;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyJoinColumn;
import lombok.Data;


@Entity
@Data
public class Carrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ElementCollection
	@MapKeyJoinColumn(name="producto_id")
	@Column(name = "cantidad")
	private Map<Producto, Integer> productos = new HashMap<Producto, Integer>();
}
