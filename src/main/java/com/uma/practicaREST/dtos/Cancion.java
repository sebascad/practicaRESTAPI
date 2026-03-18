package com.uma.practicaREST.dtos;

public class Cancion {
    private Long id;
    private String titulo;
    private String cantante;
    private int anio;

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", cantante='" + cantante + '\'' +
                ", anio=" + anio +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    public Cancion(int anio, String cantante, String titulo, Long id) {
        this.anio = anio;
        this.cantante = cantante;
        this.titulo = titulo;
        this.id = id;
    }

    public Cancion(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
