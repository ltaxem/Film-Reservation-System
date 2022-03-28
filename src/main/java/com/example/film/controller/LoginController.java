package com.example.film.controller;

import com.example.film.MainApplication;
import com.example.film.model.UserDao;
import com.example.film.model.UserSingleton;
import com.example.film.utils.BCryptPassword;
import com.example.film.utils.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Label loginStatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        String username2 = username.getText();
        String password2 = password.getText();
        if (Validation.isValidUsername(username2) && Validation.isValidPassword(password2)) {
            String passwordDb = UserDao.getBCryptPassword(username2);
            if (passwordDb.equals("")) {
                loginStatus.setText("Klaidingai įvestas prisijungimo vardas");
            } else {
                boolean isValidPassword = BCryptPassword.checkPassword(password2, passwordDb);
                if (isValidPassword) {
                    loginStatus.setText("Teisingai įvestas prisijungimo vardas ir slaptažodis DB");

                    UserSingleton userSingleton = UserSingleton.getInstance();
                    userSingleton.setUserName(username2);                           // gauname username, kuri po to parodome, kai prisijungiame

                    goToDashboard(event);
                } else loginStatus.setText("Slaptažodis įvestas neteisingai");

            }

        } else {
            loginStatus.setText("Klaidinga įvestis");
        }
    }

    @FXML
    public void onRegisterButtonClick(ActionEvent event) throws IOException {
        //Vaizdo užkrovimas
        Parent root = FXMLLoader.load(MainApplication.class.getResource("register-view.fxml"));
        Stage registerStage = new Stage();
        //Stage (langas) bus vienas, scenų gali būti daug
        registerStage.setTitle("Registracijos langas");
        registerStage.setScene(new Scene(root, 1185, 660));
        //Parodymas lango
        registerStage.show();
        //Kodas reikalingas paslėpti prieš tai buvusį langą
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    public void goToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("dashboard-view.fxml"));
        Stage LoginStage = new Stage();
        LoginStage.setTitle("Filmai");
        LoginStage.setScene(new Scene(root, 1280, 760));
        LoginStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}