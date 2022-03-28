package com.example.film.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDao {

    //---------------------Kuriame įrašą---------------------
    public static void create(Favorite favorite) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "INSERT INTO `favorite`(`user_id`, `title`, `summary`, `imdb`, `category`) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, favorite.getUser_id());
            preparedStatement.setString(2, favorite.getTitle());
            preparedStatement.setString(3, favorite.getSummary());
            preparedStatement.setString(4, favorite.getImdb());
            preparedStatement.setString(5, favorite.getCategory());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    //---------------------Paieška pagal vartotojo id---------------------
    public static List<Favorite> searchByUserId(int user_id) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "SELECT * FROM `favorite` WHERE `user_id` = '" + user_id + "'";

        ArrayList<Favorite> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Favorite(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("title"),
                        resultSet.getString("summary"),
                        resultSet.getString("imdb"),
                        resultSet.getString("category")
                ));
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //---------------------Triname įrašą---------------------
    public static void deleteById(int id) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String delete = "DELETE FROM favorite WHERE id = '" + id + "'";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
