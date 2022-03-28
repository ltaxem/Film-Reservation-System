package com.example.film.controller;

import com.example.film.MainApplication;
import com.example.film.model.*;
import com.example.film.utils.Validation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FavoriteController implements Initializable {
    ObservableList<Favorite> list = FXCollections.observableArrayList();

    @FXML
    private TextField idField;

    @FXML
    private Label usernameLabel, groupLabel, statusLabel;

    @FXML
    private TableView<Favorite> filmsTableView;

    @FXML
    private TableColumn idColumn, titleColumn, summaryColumn, imdbColumn, categoryColumn;

    @FXML
    public void onDeleteButtonClick() {
        String idField2 = idField.getText();

        if (!Validation.isValidId(idField2)) {
            statusLabel.setText("Neteisingai įvestas ID");
        } else {
            int idField3 = Integer.parseInt(idField.getText());
            FavoriteDao.deleteById(idField3);
            statusLabel.setText("Įrašas pašalintas iš sąrašo");
        }

        // Atnaujiname sąrašą
        updateList();
    }

    @FXML
    public void onGoBackButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("dashboard-view.fxml"));
        Stage LoginStage = new Stage();
        LoginStage.setTitle("Filmai");
        LoginStage.setScene(new Scene(root, 1280, 760));
        LoginStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Parodomas prisijunges vartotojas
        String username = UserSingleton.getInstance().getUserName();
        usernameLabel.setText(username);

        // Parodoma prisijungusio vartotojo role
        String role = UserDao.searchByUsername(username);
        groupLabel.setText(role);

        filmsTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                idField.setText(String.valueOf(newSelection.getId()));
                statusLabel.setText("");
            }
        });

        // Atnaujiname sąrašą
        updateList();
    }

    private void updateList() {
        list.clear();
        int userID = UserDao.searchByUsernameReturnID(usernameLabel.getText());
        List<Favorite> favoriteList = FavoriteDao.searchByUserId(userID);

        for (Favorite favorite : favoriteList) {
            list.add(new Favorite(favorite.getId(), favorite.getUser_id(), favorite.getTitle(), favorite.getSummary(), favorite.getImdb(), favorite.getCategory()));
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));
            imdbColumn.setCellValueFactory(new PropertyValueFactory<>("imdb"));
            categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

            filmsTableView.setItems(list);
        }
        if (favoriteList.isEmpty()) {
            statusLabel.setText("Sąraše nieko nėra");
        }
    }
}
