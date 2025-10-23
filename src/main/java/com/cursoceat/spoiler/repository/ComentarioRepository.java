package com.cursoceat.spoiler.repository;

import com.cursoceat.spoiler.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    //List<Comentario> findByContenido(String contenido);
    //List<Comentario> findByPelicula_IdPelicula(int idPelicula);
    List<Comentario> findByPelicula_IdPelicula(int id);
}

