package com.cursoceat.spoiler.controller;

import com.cursoceat.spoiler.model.Comentario;
import com.cursoceat.spoiler.model.ImagenPelicula;
import com.cursoceat.spoiler.model.Pelicula;
import com.cursoceat.spoiler.repository.ComentarioRepository;
import com.cursoceat.spoiler.repository.ImagenPeliculaRepository;
import com.cursoceat.spoiler.repository.PeliculaRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class PeliculasController {

    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private ImagenPeliculaRepository imagenPeliculaRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;

    double puntuacionPelicula;

    public PeliculasController(ImagenPeliculaRepository imagenPeliculaRepository) {
        this.imagenPeliculaRepository = imagenPeliculaRepository;
    }

    // Lista de películas
    @GetMapping("/peliculas")
    public String listarPeliculas(Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }
        List<Pelicula> peliculas = peliculaRepository.findAll();
        //System.out.println(peliculas.toString());
        model.addAttribute("imagen", peliculas);
        return "peliculas"; // nombre del HTML
    }

    // Detalle de una película
    @GetMapping("/plantillapeliculas/{id}")
    public String detallePelicula(@PathVariable("id") int id, Model model) {
        Optional<Pelicula> peliculaOpt = peliculaRepository.findById(id);
        if (peliculaOpt.isPresent()) {
            Pelicula pelicula = peliculaOpt.get();
            model.addAttribute("seleccionada", pelicula);
            puntuacionPelicula = peliculaOpt.get().getRating();
            System.out.println("Puntuacion Pelicula: " + puntuacionPelicula);


            model.addAttribute("puntuacionPelicula", puntuacionPelicula);
            List<ImagenPelicula> imagenes = imagenPeliculaRepository.findAll();
            List<ImagenPelicula> imagenesDeLaPelicula = new ArrayList<>();
            for (ImagenPelicula imagen : imagenes) {
                if(imagen.getPelicula() == id) {
                    imagenesDeLaPelicula.add(imagen);
                }
            }
            model.addAttribute("imagen", imagenesDeLaPelicula);

            // Cargar comentarios de esta película
            List<Comentario> comentarios = comentarioRepository.findByPelicula_IdPelicula(id);
            model.addAttribute("comentarios", comentarios);

            // Añadir un objeto Comentario vacío para el formulario
            model.addAttribute("nuevoComentario", new Comentario());

            return "plantillapeliculas";
        } else {
            return "error";
        }
    }
}
