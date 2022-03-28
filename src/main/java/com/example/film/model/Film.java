package com.example.film.model;

public class Film extends Favorite {
    private int id;
    private String title;
    private String summary;
    private String imdb;
    private String category;
    private int reservation;
    private String image;
    private String comments;

    public Film() {
    }

    public Film(String title, String summary, String imdb, String category, String image) {
        this.title = title;
        this.summary = summary;
        this.imdb = imdb;
        this.category = category;
        this.image = image;
    }

    public Film(int id, String title, String summary, String imdb, String category, int reservation, String image) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.imdb = imdb;
        this.category = category;
        this.reservation = reservation;
        this.image = image;
    }

    public Film(int id, String title, String summary, String imdb, String category, String image) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.imdb = imdb;
        this.category = category;
        this.image = image;
    }

    public Film(int reservation) {
        this.reservation = reservation;
    }

    public Film(int id, int reservation) {
        this.id = id;
        this.reservation = reservation;
    }

    public Film(int id, String title, String summary, String imdb, String category) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.imdb = imdb;
        this.category = category;
    }

    public Film(int id,String comments) {
        this.id = id;
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getReservation() {
        return reservation;
    }

    public void setReservation(int reservation) {
        this.reservation = reservation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", isbn='" + imdb + '\'' +
                ", category='" + category + '\'' +
                ", reservation=" + reservation +
                ", image='" + image + '\'' +
                '}';
    }
}
