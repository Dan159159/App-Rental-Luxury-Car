package com.example.donostiluxdrive;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioController   {
    @FXML
    private Button cochesButton;
    @FXML
    private Button cochesButtonNav;
    @FXML
    private Button inicioButtonNav;
    @FXML
    private Button segurosButtonNav;
    @FXML
    private Button signInButton;
    @FXML
    private Button signUpButton;

    @FXML
    void goToCoches()   {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Coches-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) cochesButtonNav.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    void goToInicio(ActionEvent event) {
        Stage stage;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Inicio-view.fxml"));
            Scene scene = new Scene(root);
            stage = (Stage) inicioButtonNav.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void goToSeguros(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Seguros-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) segurosButtonNav.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void goToSignin() {
        goToSign(signInButton, false);
    }

    @FXML
    public void goToSignup() {
        goToSign(signUpButton, true);
    }

    public void goToSign(Button button, boolean show) {
        LoginSignupController loginSignupController = LoginSignupController.getInstance();
        loginSignupController.setSignUpBoolean(show);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginSignup-view.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
