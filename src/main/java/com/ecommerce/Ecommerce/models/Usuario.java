package com.ecommerce.Ecommerce.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String usuario;
    @NotNull
    private String contrasenia;
    @NotNull
    private String dni;
    @ManyToOne(cascade= CascadeType.ALL)
    private Direccion direccion;
    @OneToOne
    private Carrito carrito;
}
