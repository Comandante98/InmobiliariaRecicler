package com.ulpdante.inmobiliariarecicler;

import java.io.Serializable;

public class Pelicula implements Serializable {

    private String titulo;
    private int foto;
    private String resenia;
    private String actores;

    private String director;

    public Pelicula(String titulo, int foto, String resenia, String actores, String director) {
        this.titulo = titulo;
        this.foto = foto;
        this.resenia = resenia;
        this.actores = actores;
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getResenia() {
        return resenia;
    }

    public void setResenia(String resenia) {
        this.resenia = resenia;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
