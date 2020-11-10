package com.sergigonzalez.tablaperiodica;

public class Elemento {

    private String nombre;
    private String simbolo;
    private String estado;
    private String numeroAtomico;
    private String peso;
    private String url;
    private String SerieQuimica;

    public Elemento(String serieQuimica, String estado1, String Simbolo1, String numero1, String nombre1, String peso1,String url1)
    {
        SerieQuimica = serieQuimica;
        estado = estado1;
        simbolo = Simbolo1;
        numeroAtomico = numero1;
        nombre = nombre1;
        peso = peso1;
        url = url1;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setNumeroAtomico(String numeroAtomico) {
        this.numeroAtomico = numeroAtomico;
    }

    public String getNumeroAtomico() {
        return numeroAtomico;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPeso() {
        return peso;
    }

    public void setSerieQuimica(String serieQuimica) {
        SerieQuimica = serieQuimica;
    }

    public String getSerieQuimica() {
        return SerieQuimica;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }

}
