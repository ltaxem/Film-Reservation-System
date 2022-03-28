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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class DashboardController implements Initializable {
    @FXML
    private ImageView imageView;

    @FXML
    private TextField idField, titleField, summaryField, imdbField, searchField;

    @FXML
    private ChoiceBox choiceBoxCategory;

    @FXML
    private TableView<Film> filmTableView;

    @FXML
    private TableColumn idColumn, titleColumn, summaryColumn, imdbColumn, categoryColumn, reservationColumn, imageColumn;

    @FXML
    private Label statusLabel, idLabel, groupLabel, usernameLabel;

    private String imageFile;
    ObservableList<Film> list = FXCollections.observableArrayList();

    @FXML
    public void onSearchLabelClick() {
        // Atnaujinamas sąrašas
        updateList();
    }

    @FXML
    public void onCreateButtonClick() {
        String titleField2 = titleField.getText();
        String summaryField2 = summaryField.getText();
        String imdbField2 = imdbField.getText();

        String category = "";
        if (!choiceBoxCategory.getSelectionModel().isEmpty()) {
            category = choiceBoxCategory.getSelectionModel().getSelectedItem().toString();
        }

        if (groupLabel.getText().equals("ADMINISTRATORIUS")) {
            // Tikriname pagal Validacijas
            if (!Validation.isValidTitle(titleField2)) {
                statusLabel.setText("Neteisingai įvedėt filmo pavadinimą");
            } else if (!Validation.isValidSummary(summaryField2)) {
                statusLabel.setText("Neteisingai parašėte filmo aprašymą");
            } else if (!Validation.isValidIMDB(imdbField2)) {
                statusLabel.setText("Neteisingai įrašėte IMDB ");
            } else if (imageView.getImage() == null) {
                statusLabel.setText("Prašome pasirinkti filmo nuotrauką");
            } else {
                // Keičia tipą
                // Pridedam knygos nuotraukos URL
                String image = imageView.getImage().getUrl();

                // Kuriame įrašą DB
                Film film = new Film(titleField2, summaryField2, imdbField2, category, image);
                FilmDao.create(film);
                statusLabel.setText("Pavyko sukurti įrašą");

                // Atnaujinamas sąrašas
                updateList();
            }
        } else {
            statusLabel.setText("Sukurti įraša gali tik administratorius.");
        }
    }

    @FXML
    public void onUpdateButtonClick() {
        String idField2 = idField.getText();
        String titleField2 = titleField.getText();
        String imdbField2 = imdbField.getText();
        String summaryField2 = summaryField.getText();


        if (groupLabel.getText().equals("ADMINISTRATORIUS")) {
            String category = "";
            if (!choiceBoxCategory.getSelectionModel().isEmpty()) {
                category = choiceBoxCategory.getSelectionModel().getSelectedItem().toString();
            }
            // Tikriname pagal Validacijas
            if (!Validation.isValidId(idField2)) {
                statusLabel.setText("Neteisingai įvestas ID");
            } else if (!Validation.isValidTitle(titleField2)) {
                statusLabel.setText("Neteisingai įvedėt filmo pavadinimą");
            } else if (!Validation.isValidSummary(summaryField2)) {
                statusLabel.setText("Neteisingai parašėte santrauką");
            } else if (!Validation.isValidIMDB(imdbField2)) {
                statusLabel.setText("Neteisingai įrašėte IMDB ");
            } else if (imageView.getImage() == null) {
                statusLabel.setText("Prašome pasirinkti filmo nuotrauką");
            } else {
                // Keiciame kintamuju tipus pagal konstruktoriu
                int idField3 = Integer.parseInt(idField.getText());

                // Pridedam paveiksliuko URL
                String image = imageView.getImage().getUrl();

                // Kuriame įrašą DB
                Film film = new Film(idField3, titleField2, summaryField2, imdbField2, category, image);
                FilmDao.update(film);
                statusLabel.setText("Pavyko redaguoti įrašą");

                // Atnaujinamas sąrašas
                updateList();
            }
        } else {
            statusLabel.setText("Redaguoti įraša gali tik administratorius.");
        }
    }

    @FXML
    public void onDeleteButtonClick() {
        String idField2 = idField.getText();

        if (groupLabel.getText().equals("ADMINISTRATORIUS")) {
            if (!Validation.isValidId(idField2)) {
                statusLabel.setText("Neteisingai įvestas ID");
            } else {
                int idField3 = Integer.parseInt(idField.getText());
                FilmDao.deleteById(idField3);
                statusLabel.setText("Pavyko sėkmingai ištrinti įrašą");
                // Atnaujinamas sąrašas
                updateList();
            }
        } else {
            statusLabel.setText("Trinti įraša gali tik administratorius");
        }
    }

    @FXML
    public void onImageBrowseButtonClick() throws MalformedURLException {
        if (groupLabel.getText().equals("ADMINISTRATORIUS")) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pasirinkite nuotrauką");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files",
                            "*.bmp", "*.png", "*.jpg", "*.gif"));
            File selectedFile = fileChooser.showOpenDialog(statusLabel.getScene().getWindow());

            if (selectedFile != null) {
                imageFile = selectedFile.toURI().toURL().toString();

                Image image = new Image(imageFile);
                imageView.setImage(image);
                statusLabel.setText("Nuotrauka pridėta");
            } else {
                statusLabel.setText("Nuotrauka nepridėta");
            }
        } else {
            statusLabel.setText("Pridėti nuotrauką gali tik administratorius.");
        }
    }

    @FXML
    public void onAddCategoryButtonClick(ActionEvent event) throws IOException {
        if (groupLabel.getText().equals("ADMINISTRATORIUS")) {
            Parent root = FXMLLoader.load(MainApplication.class.getResource("category-view.fxml"));
            Stage LoginStage = new Stage();
            LoginStage.setTitle("Kategorijos");
            LoginStage.setScene(new Scene(root, 600, 400));
            LoginStage.show();
            ((Node) event.getSource()).getScene().getWindow().hide();
        } else {
            statusLabel.setText("Pridėti kategorija gali tik administratorius.");
        }
    }

    @FXML
    public void onReservationButtonClick() {
        String idField2 = idField.getText();

        if (!Validation.isValidId(idField2)) {
            statusLabel.setText("Neteisingai įvestas ID");
        } else {
            int idField3 = Integer.parseInt(idField.getText());
            // Gauname ivesta id
            Film film = FilmDao.searchTitleById(idField3);

            // Tikranm ar toks ID egzistuoja
            if (film == null) {
                statusLabel.setText("Tokio ID duombazei nėra");
            } else {
                // Pasiemame savo ID
                int userID = UserDao.searchByUsernameReturnID(usernameLabel.getText());

                if (film.getReservation() == 0) {
                    Film movie2 = new Film(idField3, userID);
                    FilmDao.reserve(movie2);
                    statusLabel.setText("Jums pavyko rezervuoti filmą");

                    // Atnaujinamas sąrašas
                    updateList();
                } else if (film.getReservation() == userID) {
                    statusLabel.setText("Filmą jau rezervavote ankščiau, rinkites kita");
                } else if (film.getReservation() != userID) {
                    statusLabel.setText("Filmas rezervuotas kito vartotojo");
                }
            }
        }
    }

    @FXML
    public void onFavoritesListButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("favorites-view.fxml"));
        Stage LoginStage = new Stage();
        LoginStage.setTitle("Mėgstamas filmas");
        LoginStage.setScene(new Scene(root, 980, 720));
        LoginStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void onAddFavoriteButtonClick() {
        // user_id
        int userID = UserDao.searchByUsernameReturnID(usernameLabel.getText());

        String idField2 = idField.getText();
        if (!Validation.isValidId(idField2)) {
            statusLabel.setText("Neteisingai įvestas ID");
        } else {
            // Title ID
            int idField3 = Integer.parseInt(idField.getText());

            // Sąrašo paieška pagal id
            Film filmList = FilmDao.searchById(idField3);

            // Tikranm ar toks ID egzistuoja
            if (filmList == null) {
                statusLabel.setText("Tokio ID duombazei nėra");
            } else {
                Favorite favorite = new Favorite(userID, filmList.getTitle(), filmList.getSummary(), filmList.getImdb(), filmList.getCategory());
                FavoriteDao.create(favorite);
                statusLabel.setText("Sėkmingai pridėjote Filmą į mėgstamų sąrašą.");
            }
        }
    }

    @FXML
    public void onLogOutButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("login-view.fxml"));
        Stage LoginStage = new Stage();
        LoginStage.setTitle("Prisijungimo langas");
        LoginStage.setScene(new Scene(root, 1185, 660));
        LoginStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void onMoreButtonClick(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("films-more-view.fxml"));
        Stage LoginStage = new Stage();
        LoginStage.setTitle("Skaityti plašiau");
        LoginStage.setScene(new Scene(root, 980, 720));
        LoginStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Pridedame reikšmes į ChoiceBox
        List<Category> sarasas = CategoryDao.searchAll();
        choiceBoxCategory.getItems().addAll(sarasas);
        choiceBoxCategory.getSelectionModel().selectFirst();


        // Paspaudus ant lentelės laukelio užkraunami laukeliai
        filmTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                try {
                    imageView.setImage(new Image(newSelection.getImage()));
                    statusLabel.setText("");
                } catch (IllegalArgumentException e) {
                    statusLabel.setText("Paveiksliukas nepridėtas");
                }
                idField.setText(String.valueOf(newSelection.getId()));
                titleField.setText(newSelection.getTitle());
                summaryField.setText(newSelection.getSummary());
                imdbField.setText(newSelection.getImdb());
                // Nededam kategorijos nes ji gali buti istrinta
            }
        });

        // Parodomas prisijunges vartotojas
        String username = UserSingleton.getInstance().getUserName();
        usernameLabel.setText(username);

        // Parodoma prisijungusio vartotojo role
        String role = UserDao.searchByUsername(username);
        groupLabel.setText(role);

        // Parodomas prisijungusio vartotojo ID
        String userID = String.valueOf(UserDao.searchByUsernameReturnID(usernameLabel.getText()));
        idLabel.setText(userID);

        // Atnaujinamas sąrašas
        updateList();
    }

    public void updateList() {
        list.clear();
        String searchField2 = searchField.getText();
        List<Film> filmList = FilmDao.searchByName(searchField2);
        for (Film film : filmList) {
            list.add(new Film(film.getId(), film.getTitle(), film.getSummary(), film.getImdb(), film.getCategory(), film.getReservation(), film.getImage()));
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));
            imdbColumn.setCellValueFactory(new PropertyValueFactory<>("imdb"));
            categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
            reservationColumn.setCellValueFactory(new PropertyValueFactory<>("reservation"));
            imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));

            filmTableView.setItems(list);
        }
        if (filmList.isEmpty()) {
            statusLabel.setText("Nepavyko atlikti paieška pagal pavadinimą");
        }
    }
}
