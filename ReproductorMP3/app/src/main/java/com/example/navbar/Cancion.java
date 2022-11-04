package com.example.navbar;

public class Cancion {

    private String urlImagen, urlAudio, nombre, artista;

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getUrlAudio() {
        return urlAudio;
    }

    public void setUrlAudio(String urlAudio) {
        this.urlAudio = urlAudio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Cancion() {
    }

    public Cancion(String urlImagen, String urlAudio, String nombre, String artista) {
        this.urlImagen = urlImagen;
        this.urlAudio = urlAudio;
        this.nombre = nombre;
        this.artista = artista;
    }
}
