package com.example.film.model;

import java.text.SimpleDateFormat;

public class Comment {
    private int id;
    private String user_username;
    private int film_id;
    private String comment;
    private String data;

    public Comment() {
    }

    public Comment(String user_username, String comment, String data) {
        this.user_username = user_username;
        this.comment = comment;
        this.data = data;
    }

    public Comment(int id, String user_username, int film_id, String comment, String data) {
        this.id = id;
        this.user_username = user_username;
        this.film_id = film_id;
        this.comment = comment;
        this.data = data;
    }

    public Comment(String user_username, int film_id, String comment) {
        this.user_username = user_username;
        this.film_id = film_id;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
