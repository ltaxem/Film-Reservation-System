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
        String querry = "SELECT password, username FROM `users` WHERE `username` = ?";

        String passwordBCrypted = "";
        String usernameMatch = "";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                usernameMatch = resultSet.getString("username");
                if(username.equals(usernameMatch)){                                 // Tikrinam ar sutampa field username su db username, jei sutampa grazinam password BCrypted
                    passwordBCrypted = resultSet.getString("password");
                }
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

    //---------------------Įrašo paieška pagal username, kuris grazins username jei ji aptiks---------------------
    public static String searchByUsernameReturnUsername(String username) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "SELECT * FROM `users` WHERE `username` = ?";

        String username2 = "";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);

            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                username2 = resultSet.getString("username");
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

    //---------------------Įrašo paieška pagal email, kuris grazins email jei ji aptiks---------------------
    public static String searchByEmailReturnEmail(String email) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "SELECT * FROM `users` WHERE `email` = ?";

        String returnEmail = "";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                returnEmail = resultSet.getString("email");
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnEmail;
    }

}
