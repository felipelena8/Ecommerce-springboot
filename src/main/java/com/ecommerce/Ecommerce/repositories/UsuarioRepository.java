package com.ecommerce.Ecommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import com.ecommerce.Ecommerce.models.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
