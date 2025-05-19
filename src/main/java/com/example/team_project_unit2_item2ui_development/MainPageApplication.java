package com.example.team_project_unit2_item2ui_development;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 500);
        stage.setTitle("Expense Splitter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}