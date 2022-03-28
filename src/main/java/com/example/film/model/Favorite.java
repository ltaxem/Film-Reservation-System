package com.example.film.model;

public class Favorite {
    private int id;
    private int user_id;
    private String title;
    private String summary;
    private String imdb;
    private String category;

    public Favorite() {
    }

    public Favorite(int user_id, String title, String summary, String imdb, String category) {
        this.user_id = user_id;
        this.title = title;
        this.summary = summary;
        this.imdb = imdb;
        this.category = category;
    }

    public Favorite(int id, int user_id, String title, String summary, String imdb, String category) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.summary = summary;
        this.imdb = imdb;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", isbn='" + imdb + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
