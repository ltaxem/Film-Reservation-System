package com.example.film.controller;

import com.example.film.MainApplication;
import com.example.film.model.Category;
import com.example.film.model.CategoryDao;
import com.example.film.utils.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {
    @FXML
    private TextField categoryTitleTextField;

    @FXML
    private ChoiceBox categoryChoiceBox;

    @FXML
    private Label statusLabel;

    List<Category> list = CategoryDao.searchAll();

    @FXML
    public void onCreateButtonClick() {
        String categoryTitleTextField2 = categoryTitleTextField.getText();
        // Tikrinam ką vartotojas įrašė
        String oneCategory = String.valueOf(CategoryDao.searchByName(categoryTitleTextField2));
        if (!Validation.isValidTitle(categoryTitleTextField2)) {
            statusLabel.setText("Kategorija įvesta neteisingai");
        } else {
            if (!categoryTitleTextField2.equals(oneCategory)) {
                Category category = new Category(categoryTitleTextField2);
                CategoryDao.createCategory(category);
                statusLabel.setText("Pavyko sukurti Kategorija");
            } else {
                statusLabel.setText("Tokiu pavadinimu kategorija egzistuoja");
            }
        }
        // Atnaujiname sąrašą
        updateList();
    }

    @FXML
    public void onUpdateButtonClick() {
        String categoryTitleTextField2 = categoryTitleTextField.getText(); // Naujas pavadinimas

        // Patikrinam ar vartotojas pasirinko kategorija
        if (!categoryChoiceBox.getSelectionModel().isEmpty()) {
            if (!Validation.isValidTitle(categoryTitleTextField2)) {
                statusLabel.setText("Kategorijos pavadinimas įvestas neteisingai");
            } else {
                String categoryChoiceBox3 = categoryChoiceBox.getSelectionModel().getSelectedItem().toString();  // Senas pavadinimas
                Category category = new Category(categoryChoiceBox3, categoryTitleTextField2);
                CategoryDao.update(category);
                statusLabel.setText("Pavyko atnaujinti kategorija");
            }
        } else {
            statusLabel.setText("Pasirinkite kategorija");
        }

        // Atnaujiname sąrašą
        updateList();
    }

    @FXML
    public void onDeleteButtonClick() {
        if (!categoryChoiceBox.getSelectionModel().isEmpty()) {
            String temp = categoryChoiceBox.getSelectionModel().getSelectedItem().toString();
            CategoryDao.deleteByName(temp);
            statusLabel.setText("Pavyko ištrinti kategorija");
        } else {
            statusLabel.setText("Pasirinkite, kuria kategorija norite pašalinti ");
        }

        // Atnaujiname sąrašą
        updateList();
    }

    @FXML
    public void onReturnButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("dashboard-view.fxml"));
        Stage LoginStage = new Stage();
        LoginStage.setTitle("Filmai");
        LoginStage.setScene(new Scene(root, 1280, 760));
        LoginStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryChoiceBox.getItems().addAll(list);
    }

    // Atnaujiname categoryChoiceBox sąrašą
    private void updateList() {
        list.clear();
        categoryChoiceBox.getItems().clear();
        List<Category> list = CategoryDao.searchAll();
        categoryChoiceBox.getItems().addAll(list);
        list.clear();
    }
}
