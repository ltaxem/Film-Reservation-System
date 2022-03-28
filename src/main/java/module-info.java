module com.example.filmai {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.xml;
    requires java.sql;


    opens com.example.film to javafx.fxml;
    exports com.example.film;
    exports com.example.film.controller;
    opens com.example.film.controller to javafx.fxml;
    exports com.example.film.model;
    opens com.example.film.model to javafx.fxml;
}