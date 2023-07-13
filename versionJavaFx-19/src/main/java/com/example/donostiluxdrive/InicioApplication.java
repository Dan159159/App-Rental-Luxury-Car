package com.example.donostiluxdrive;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioApplication extends Application {
    private Stage paginaCochesStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InicioApplication.class.getResource("Inicio-view.fxml"));
        Scene sceneInico = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Inicio");
        primaryStage.setScene(sceneInico);
        primaryStage.show();


    }



    public static void main(String[] args) {
        launch();
    }
}