package com.example.samaracatalina.mongo.models;

/**
 * Created by Samara Catalina on 25/03/2015.
 */
public class Pelicula {

    String nombre,duracion,director,idioma;

    public Pelicula(String nombre, String duracion, String director, String idioma) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.director = director;
        this.idioma = idioma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
