package com.example.film.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {

    //---------------------Kuriame įrašą---------------------
    public static void create(Comment comment) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "INSERT INTO `comments`(`user_username`, `film_id`, `comment`) VALUES (?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, comment.getUser_username());
            preparedStatement.setInt(2, comment.getFilm_id());
            preparedStatement.setString(3, comment.getComment());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comment> searchById(int filmId) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "SELECT * FROM `comments` WHERE `film_id` =" + filmId + " ORDER BY `comments`.`data` DESC";

        ArrayList<Comment> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new Comment(
                        resultSet.getInt("id"),
                        resultSet.getString("user_username"),
                        resultSet.getInt("film_id"),
                        resultSet.getString("comment"),
                        resultSet.getString("data")
                ));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
