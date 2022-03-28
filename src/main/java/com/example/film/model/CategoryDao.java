package com.example.film.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public static void createCategory(Category category) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "INSERT INTO `category`(`categoryTitle`) VALUES (?)";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, category.getCategoryTitle());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Category> searchAll() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String uzklausa = "SELECT id, categoryTitle FROM `category`";
        List<Category> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(uzklausa);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("categoryTitle")
                ));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void deleteByName(String name) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String delete = "DELETE FROM `category` WHERE `categoryTitle` = ?";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Category category) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String update = "UPDATE `category` SET `categoryTitle` = '" + category.getCategoryTempTitle() + "' WHERE `categoryTitle` = ?";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, category.getCategoryTitle());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Category searchByName(String categoryTitle){
        String jdbcUrl = "jdbc:mysql://localhost:3306/examV2";
        String querry = "SELECT * FROM `category` WHERE `categoryTitle` = ?";

        ArrayList<Category> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, categoryTitle);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new Category(
                        resultSet.getString("categoryTitle")
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

}
