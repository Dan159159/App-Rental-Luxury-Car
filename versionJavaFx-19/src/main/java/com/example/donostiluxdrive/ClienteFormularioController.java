package com.example.donostiluxdrive;

import clases.Connectiondb;
import clases.Reserva;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteFormularioController {

    @FXML
    private TextField apellidoField;

    @FXML
    private Button confirmarButton;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField telefonoField;

    static Reserva reserva;
    boolean addedSuccessfully;


    public void confirmar(ActionEvent actionEvent) {
        if (nombreField.getText().isEmpty() || apellidoField.getText().isEmpty() || emailField.getText().isEmpty() || telefonoField.getText().isEmpty()) {
            showAlertDialog("fill all the fields");
        } else {
            reserva = new Reserva(MarcaFormularioController.cocheElejido.getId_coche(),
                    FechaFormularioController.fechaIn,
                    FechaFormularioController.fechaFin,
                    nombreField.getText(),
                    apellidoField.getText(),
                    emailField.getText(),
                    telefonoField.getText(),
                    MarcaFormularioController.precioTotal
            );
            String query = "INSERT INTO reservas (id_coche, fechaIn, fechaFin, nombreCliente, apellidoCliente, emailCliente, telefonoCliente, precioTotal) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = new Connectiondb().getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, reserva.getId_coche());
                stmt.setDate(2, Date.valueOf(reserva.getFechaIn()));
                stmt.setDate(3, Date.valueOf(reserva.getFechaFin()));
                stmt.setString(4, reserva.getNombreCliente());
                stmt.setString(5, reserva.getApellidoCliente());
                stmt.setString(6, reserva.getEmailCliente());
                stmt.setString(7, reserva.getTelefonoCliente());
                stmt.setDouble(8, reserva.getPrecioTotal());
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected == 1) {
                    System.out.println("added successfully.");
                    addedSuccessfully = true;

                } else {
                    System.out.println("Error: no rows were affected by the insert operation.");
                    addedSuccessfully = true;
                }
            } catch (SQLException e) {
                System.out.println("Error inserting new reserva: " + e.getMessage());
            }

            if (addedSuccessfully) {
                Alert info = new Alert(Alert.AlertType.INFORMATION);
                info.setTitle("informacion");
                info.setHeaderText(null);
                info.setContentText("successfully");
                info.showAndWait();
            }
            //reset all the attributes
                    reset();
            //close the form
            Stage currentStage = (Stage) confirmarButton.getScene().getWindow();
            currentStage.close();
        }
    }

    public static void showAlertDialog(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void reset() {
        FechaFormularioController.fechaIn = null;
        FechaFormularioController.fechaFin = null;
        FechaFormularioController.cochesList = null;
        MarcaFormularioController.cocheElejido = null;
        MarcaFormularioController.marcas = null;
        MarcaFormularioController.modelos = null;
        MarcaFormularioController.colores = null;
        MarcaFormularioController.marcaElejida = null;
        MarcaFormularioController.diasElejido = 0;
        MarcaFormularioController.precioTotal = 0;
        reserva = null;
    }
}
//when confirmar es clicked :
//    - check is everything is valid (all the textFields are filled)
//    - hacer un query de insert en reservas
//    - reset all the attributes (fechaIn, fechaFin, cochesLista, marcas, marcaElejida ...)

//proxima version:
//    - show an alert of fthe reserva Details
//    - controll the textField (like email )