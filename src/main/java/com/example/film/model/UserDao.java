package com.example.film.model;


import java.sql.*;

public class UserDao {
    public static void create(User user) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "INSERT INTO `users`(`username`, `password`, `email`, `admin`) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setBoolean(4, user.isAdmin());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getBCryptPassword(String username) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "SELECT password FROM `users` WHERE `username` = ?";

        String passwordBCrypted = "";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                passwordBCrypted = resultSet.getString("password");
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passwordBCrypted;
    }

    //---------------------Įrašo paieška pagal username, kuris grazina ROLE---------------------
    public static String searchByUsername(String username) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "SELECT * FROM `users` WHERE `username` = ?";

        String username2 = "";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);

            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                username2 = resultSet.getBoolean("admin") ? "ADMINISTRATORIUS" : "VARTOTOJAS";
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return username2;
    }

    //---------------------Įrašo paieška pagal username---------------------
    public static int searchByUsernameReturnID(String username) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "SELECT id FROM `users` WHERE `username` = ?";

        int username2 = 0;
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                username2 = resultSet.getInt("id");
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return username2;
    }

}
