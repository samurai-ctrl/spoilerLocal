package com.cursoceat.spoiler.repository;

import com.cursoceat.spoiler.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeliculaRepository  extends JpaRepository<Pelicula,Integer> {
    Optional<Pelicula> findByTitulo(String titulo);
}

