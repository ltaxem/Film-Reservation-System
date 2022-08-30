package com.example.film.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDao {
    //---------------------Kurti įrašą------------------------------
    public static void create(Film film) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "INSERT INTO `films`(`title`, `summary`, `imdb`, `category`, `image`) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, film.getTitle());
            preparedStatement.setString(2, film.getSummary());
            preparedStatement.setString(3, film.getImdb());
            preparedStatement.setString(4, film.getCategory());
            preparedStatement.setString(5, film.getImage());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //---------------------Ieškoti įrašo----------------------------
    public static List<Film> searchByName(String title) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "SELECT * FROM `films` WHERE `title` LIKE '%" + title + "%'";

        ArrayList<Film> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new Film(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("summary"),
                        resultSet.getString("imdb"),
                        resultSet.getString("category"),
                        resultSet.getInt("reservation"),
                        resultSet.getString("image")
                ));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //---------------------Atnaujinti įrašą-------------------------
    public static void update(Film film) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String update = "UPDATE `films` SET `title`= ?,`summary`= ?,`imdb`= ?, `category`= ?,`image`= ? WHERE `id` = ?";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, film.getTitle());
            preparedStatement.setString(2, film.getSummary());
            preparedStatement.setString(3, film.getImdb());
            preparedStatement.setString(4, film.getCategory());
            preparedStatement.setString(5, film.getImage());
            preparedStatement.setInt(6, film.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //---------------------Trinti įrašą-----------------------------
    public static void deleteById(int id) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String delete = "DELETE FROM films WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //------------------Ieskome rezervacija pagal id------------------
    public static Film searchTitleById(int id) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "SELECT `reservation` FROM films WHERE id = ?";

        ArrayList<Film> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new Film(
                        resultSet.getInt("reservation")
                ));
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            return list.get(0);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    //---------------------Atnaujiname rezervacija--------------------------
    public static void reserve(Film film) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String update = "UPDATE `films` SET `reservation`= ? WHERE `id` = ?";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setInt(1, film.getReservation());
            preparedStatement.setInt(2, film.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //---------------------Įrašo paieška pagal id---------------------
    public static Film searchById(int id) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "SELECT * FROM `films` WHERE `id` = ?";

        ArrayList<Film> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new Film(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("summary"),
                        resultSet.getString("imdb"),
                        resultSet.getString("category"),
                        resultSet.getString("image")
                ));
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            return list.get(0);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }


    public static void updateComment(Film film){
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String update = "UPDATE `films` SET `comments`= ? WHERE `id` = ?";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, film.getComments());
            preparedStatement.setInt(2, film.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
