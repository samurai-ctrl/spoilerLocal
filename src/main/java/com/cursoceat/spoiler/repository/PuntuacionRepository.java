package com.cursoceat.spoiler.repository;

import com.cursoceat.spoiler.model.Pelicula;
import com.cursoceat.spoiler.model.Rating;
import com.cursoceat.spoiler.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

    Optional<Rating> findByUsuarioAndPelicula(Usuario usuario, Pelicula pelicula);

    @Query("SELECT AVG(r.valor) FROM Rating r WHERE r.pelicula = :pelicula")
    Double findAverageByPelicula(@Param("pelicula") Pelicula pelicula);
}
