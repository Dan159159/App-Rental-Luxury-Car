package com.example.donostiluxdrive;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CrudportadaController {

    @FXML
    private Button cochesButton;

    @FXML
    private Button reservasButton;

    @FXML
    private Button signOutButton;

    @FXML
    private Button usuariosButton;

    @FXML
    void goToCochesAdmin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Crudcoches-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void goToInicio(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Inicio-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) signOutButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void goToReservasAdmin(ActionEvent event) {
        //Abrir otra ventana
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Crudreservas-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        /*Abrir ventana que reemplaze la anterior
        try {
            Parent root = FXMLLoader.load(getClass().getResource(""));
            Scene scene = new Scene(root);
            Stage stage = (Stage) reservasButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

}



