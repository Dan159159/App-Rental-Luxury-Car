package com.example.donostiluxdrive;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;




public class ReservaFormularioController {
    //Declaracion de varibales
    @FXML
    private ComboBox<?> colorCombo;

    @FXML
    private Label disponiblelabel;

    @FXML
    private ComboBox<?> marcaCombo;

    @FXML
    private Button masInfoComboButton;

    @FXML
    private ComboBox<?> modeloCombo;

    @FXML
    private Label precioTotalLabel;

    //@FXML
    //private ComboBox<String> seguroCombo;

    private ObservableList<String> listaSeguro = FXCollections.observableArrayList("Estandar", "Elite", "Normal");
    @FXML
    private ComboBox seguroCombo = new ComboBox(listaSeguro);
    /*public void listaSeguro() {
        seguroCombo.setItems(listaSeguro);
        seguroCombo.setValue("Estandar");
    }*/
    void goToSegurosPopUp(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("SegurosPopUp-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) masInfoComboButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
