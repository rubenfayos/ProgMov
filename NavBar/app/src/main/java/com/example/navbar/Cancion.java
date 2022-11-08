package com.example.navbar;

public class Cancion {

    private String urlImagen, nombre, artista;
    private int mp3;

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public int getUrlAudio() {
        return mp3;
    }

    public void setUrlAudio(int mp3) {
        this.mp3 = mp3;
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

    public Cancion(String urlImagen, int mp3, String nombre, String artista) {
        this.urlImagen = urlImagen;
        this.mp3 = mp3;
        this.nombre = nombre;
        this.artista = artista;
    }
}
