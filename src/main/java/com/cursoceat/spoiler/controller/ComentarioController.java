package com.cursoceat.spoiler.controller;

import com.cursoceat.spoiler.model.Comentario;
import com.cursoceat.spoiler.model.Pelicula;
import com.cursoceat.spoiler.model.Usuario;
import com.cursoceat.spoiler.repository.ComentarioRepository;
import com.cursoceat.spoiler.repository.PeliculaRepository;
import com.cursoceat.spoiler.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/pelicula/{id}/comentario")
    public String crearComentario(@PathVariable("id") int id,
                                  @ModelAttribute("nuevoComentario") Comentario nuevoComentario,
                                  HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null) {
            return "redirect:/login";
        }

        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Película no encontrada"));

        // Asignar usuario y película al comentario
        //System.out.println("Nueva comentario: " + nuevoComentario);
        nuevoComentario.setUsuario(usuario);
        nuevoComentario.setPelicula(pelicula);

        comentarioRepository.save(nuevoComentario);
        System.out.println("Comentario: " + nuevoComentario.getContenido());
        return "redirect:/plantillapeliculas/" + pelicula.getIdPelicula();
    }
}

