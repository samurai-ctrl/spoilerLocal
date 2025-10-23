package com.cursoceat.spoiler.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPelicula;

    private String titulo;
    private String director;
    private String genero;
    private double rating;

    @Column(columnDefinition = "TEXT")
    private String sinopsis;

    private int duracion; // en minutos

    private String portadaUrl;

    private String trailerUrl;

    private String imagenPelicula;
    // Relación OneToMany con ImagenPelicula
    //   @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //   private List<ImagenPelicula> imagenes;

    public Pelicula() {
    }

    public Pelicula(String imagenPelicula, String trailerUrl, String portadaUrl, int duracion, String sinopsis, double rating, String genero, String director, String titulo, int idPelicula) {
        this.imagenPelicula = imagenPelicula;
        this.trailerUrl = trailerUrl;
        this.portadaUrl = portadaUrl;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.rating = rating;
        this.genero = genero;
        this.director = director;
        this.titulo = titulo;
        this.idPelicula = idPelicula;
    }

    // Getters y setters completos

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getPortadaUrl() {
        return portadaUrl;
    }

    public void setPortadaUrl(String portadaUrl) {
        this.portadaUrl = portadaUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

//    public List<ImagenPelicula> getImagenes() {
//        return imagenes;
//    }
//
//    public void setImagenes(List<ImagenPelicula> imagenes) {
//        this.imagenes = imagenes;
//    }

    public String getImagenPelicula() {
        return imagenPelicula;
    }

    public void setImagenPelicula(String imagenPelicula) {
        this.imagenPelicula = imagenPelicula;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula=" + idPelicula +
                ", titulo='" + titulo +
                ", director='" + director +
                ", genero='" + genero +
                ", rating=" + rating +
                ", sinopsis='" + sinopsis +
                ", duracion=" + duracion +
                ", portadaUrl='" + portadaUrl +
                ", trailerUrl='" + trailerUrl +
                ", imagenPelicula='" + imagenPelicula;
    }
}
