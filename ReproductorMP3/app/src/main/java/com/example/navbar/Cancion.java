package com.example.navbar;

import android.media.MediaPlayer;

public class Cancion {

    private String urlImagen, nombre, artista;
    private int mp3, estado;
    private MediaPlayer mediaPlayer;

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public int getmp3() {
        return mp3;
    }

    public void setmp3(int mp3) {
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
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
