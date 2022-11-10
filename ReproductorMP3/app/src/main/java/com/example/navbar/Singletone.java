package com.example.navbar;

public class Singletone {

    Cancion c;

    private static final Singletone ourInstance = new Singletone();
    public static Singletone getInstance() {
        return ourInstance;
    }
    private Singletone() {
    }
    public void setData(Cancion c) {
        this.c = c;
    }
    public Cancion getData() {
        return c;
    }
}
