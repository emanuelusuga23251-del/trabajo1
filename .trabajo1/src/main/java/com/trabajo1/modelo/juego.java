package com.trabajo1.modelo;

public class juego {
    private String nombre;
    private String plataforma;
    private String genero;

    public juego(String nombre, String plataforma, String genero) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.genero = genero;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
}
