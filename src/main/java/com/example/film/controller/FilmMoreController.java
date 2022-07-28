package com.example.film.controller;

import com.example.film.MainApplication;
import com.example.film.model.*;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FilmMoreController implements Initializable {
    ObservableList<Film> list = FXCollections.observableArrayList();
    ObservableList<Comment> commentslist = FXCollections.observableArrayList();
    @FXML
    private ImageView imageView;

    @FXML
    private TextField searchField, commentsField;

    @FXML
    private Label usernameLabel, groupLabel, statusLabel, imdbLabel, summaryLabel, titleLabel, categorylabel, idLabel, commentsLabel;

    @FXML
    private TableView<Film> filmsTableView;

    @FXML
    private TableView<Comment> CommentsTableView;

    @FXML
    private TableColumn idColumn, titleColumn, summaryColumn, imdbColumn, categoryColumn,
            userNameColumn, commentColumn, dataColumn;

    @FXML
    public void onGoBackButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("dashboard-view.fxml"));
        Stage LoginStage = new Stage();
        LoginStage.setTitle("Filmai");
        LoginStage.setScene(new Scene(root, 1280, 760));
        LoginStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void onSearchLabelClick() {
        // Atnaujinamas sąrašas
        updateList();
    }

    //TODO Pabaigti su komentarais
    @FXML
    public void onSendButtonClick() {
        String userName = UserSingleton.getInstance().getUserName();

        // TODO VEIKIA Patikrinam ar pazymejo filma, BET reiks perdaryt su validacijom
        if(idLabel.getText().equals("ID")){
            statusLabel.setText("Pasirinkite filmą iš sąrašo");
            return;
        }
        // TODO neleisti tuscio teksto
        int filmId = Integer.parseInt(idLabel.getText());   // film_id
        String commentText = commentsField.getText();   // comment

        Comment comment = new Comment(userName, filmId, commentText);
        CommentDao.create(comment);
        statusLabel.setText("Komentaras pridėtas");
        updateCommentsList(Integer.parseInt(idLabel.getText())); // Atnaujinam comments lentele
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
                searchField.setText(newSelection.getTitle());
                titleLabel.setText(newSelection.getTitle());
                imageView.setImage(new Image(newSelection.getImage()));
                imdbLabel.setText(newSelection.getImdb());
                categorylabel.setText(newSelection.getCategory());
                summaryLabel.setText(newSelection.getSummary());
                idLabel.setText(String.valueOf(newSelection.getId()));
//                commentsLabel.setText(newSelection.getComments());
                updateCommentsList(Integer.parseInt(idLabel.getText()));
            }
        });
        // Atnaujiname sąrašą
        updateList();
    }

    private void updateList() {
        list.clear();
        String searchField2 = searchField.getText();
        List<Film> filmList = FilmDao.searchByName(searchField2);
        for (Film film : filmList) {
            list.add(new Film(film.getId(), film.getTitle(), film.getSummary(), film.getImdb(), film.getCategory(), film.getReservation(), film.getImage()));
//            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
//            summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));
//            imdbColumn.setCellValueFactory(new PropertyValueFactory<>("imdb"));
//            categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

            filmsTableView.setItems(list);
        }
        if (filmList.isEmpty()) {
            statusLabel.setText("Nepavyko atlikti paieška pagal pavadinimą");
        }
    }

    private void updateCommentsList(int filmId) {
        commentslist.clear();
        List<Comment> commentsList = CommentDao.searchById(filmId);
        for (Comment comment : commentsList) {
            commentslist.add(new Comment(comment.getUser_username(), comment.getComment(), comment.getData()));
            userNameColumn.setCellValueFactory(new PropertyValueFactory<>("user_username"));
            commentColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));
            dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
            CommentsTableView.setItems(commentslist);
        }
    }
}
