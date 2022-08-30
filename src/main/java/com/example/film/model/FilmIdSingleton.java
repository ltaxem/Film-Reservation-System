package com.example.film.model;

public class FilmIdSingleton {
    private static FilmIdSingleton instance;

    private String id;

    private FilmIdSingleton() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static FilmIdSingleton getInstance(){
        if(instance == null){
            instance = new FilmIdSingleton();
        }
        return instance;
    }
}
