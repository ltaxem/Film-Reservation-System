package com.example.film.model;

public class UserSingleton {
    private static UserSingleton instance;

    private String userName;

    private UserSingleton() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static UserSingleton getInstance(){
        if(instance == null){
            instance = new UserSingleton();
        }
        return instance;
    }
}
