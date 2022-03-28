package com.example.film;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Vaizdo užkrovimas
        FXMLLoader loginView = new FXMLLoader(MainApplication.class.getResource("login-view.fxml"));
        //Sukūrimas scenos iš vaizdo
        Scene scene = new Scene(loginView.load(), 1185, 660);
        //Stage (langas) bus vienas, scenų gali būti daug
        stage.setTitle("Prisijungimo langas");
        //Langui priskiriama scena
        stage.setScene(scene);
        //Parodymas lango
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}