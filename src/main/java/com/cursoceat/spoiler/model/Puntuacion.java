package com.cursoceat.spoiler.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Pelicula pelicula;

    private int valor; // 1 a 5

    public Rating() {}

    public Rating(Usuario usuario, Pelicula pelicula, int valor) {
        this.usuario = usuario;
        this.pelicula = pelicula;
        this.valor = valor;
    }

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }
    public int getValor() { return valor; }
    public void setValor(int valor) { this.valor = valor; }
}