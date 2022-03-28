package com.example.film.model;

public class Category {
    private int id;
    private String categoryTitle;
    private String categoryTempTitle;

    public Category() {
    }

    public Category(int id, String categoryTitle) {
        this.id = id;
        this.categoryTitle = categoryTitle;
    }

    public Category(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Category(String categoryTitle, String categoryTempTitle) {
        this.categoryTitle = categoryTitle;
        this.categoryTempTitle = categoryTempTitle;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryTempTitle() {
        return categoryTempTitle;
    }

    public void setCategoryTempTitle(String categoryTempTitle) {
        this.categoryTempTitle = categoryTempTitle;
    }

    @Override
    public String toString() {
        return categoryTitle;
    }
}
