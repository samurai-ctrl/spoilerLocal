package com.cursoceat.spoiler.repository;

import com.cursoceat.spoiler.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    //Necesita que el repositorio busque aqui el usuario
    Optional<Usuario> findByUsername(String username);
}