package com.example.donostiluxdrive;

import clases.Coche;
import clases.Connectiondb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class FechaFormularioController {

    @FXML
    private DatePicker fechaFinPicker;

    @FXML
    private DatePicker fechaInPicker;

    @FXML
    private Button nextButton;
    static ObservableList<Coche> cochesList;
    static LocalDate fechaIn;
    static LocalDate fechaFin;
    static Stage currentStage;


    @FXML
    void goToMarcaFormulario(ActionEvent event) throws IOException {
        // assuming fechaInPicker and fechaFinPicker are instances of DatePicker
        fechaIn = fechaInPicker.getValue();
        fechaFin = fechaFinPicker.getValue();

        //mostrar un alert si el usuario o ha elijido nada
        if (fechaIn == null || fechaFin == null) {
            showAlertDialog("Please select both start and end dates.");
        }

        //mostrar un alert si el usuario o ha elijo un fecha invalida
        if (fechaIn.isAfter(fechaFin)) {
            showAlertDialog("End date must be on or after start date.");
        } else {

            // assuming conn is a Connection object representing the MySQL database connection
            String query = "SELECT * FROM coches WHERE id NOT IN " +
                    "(SELECT id_coche FROM reservas " +
                    "WHERE (fechaIn <= ? AND fechaFin >= ?) OR " +
                    "(fechaIn <= ? AND fechaFin >= ?) OR " +
                    "(fechaIn >= ? AND fechaFin <= ?))";
            cochesList = FXCollections.observableArrayList();
            Connectiondb connectiondb = new Connectiondb();
            connectiondb.setConnection();
            try (Connection conn = new Connectiondb().getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setDate(1, Date.valueOf(fechaIn));
                stmt.setDate(2, Date.valueOf(fechaIn));
                stmt.setDate(3, Date.valueOf(fechaFin));
                stmt.setDate(4, Date.valueOf(fechaFin));
                stmt.setDate(5, Date.valueOf(fechaIn));
                stmt.setDate(6, Date.valueOf(fechaFin));
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String marca = rs.getString("marca");
                    String modelo = rs.getString("modelo");
                    String color = rs.getString("color");
                    int precioBase = rs.getInt("precioBase");
                    Coche coche = new Coche(id, marca, modelo, color, precioBase);
                    cochesList.add(coche);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //mostrar un alert si no hay ningun  coche disponible en la fecha elejida
            if (cochesList.isEmpty()) {
                showAlertDialog("There are no cars available in the specified date range.");
            }

            //To pass the list of available cars to the next form, you can add the following code to the section that handles the case where one or more cars are available:
            if (!cochesList.isEmpty()) {
                goToMarcaFormulario();
            }
        }
    }

    public static void showAlertDialog(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void goToMarcaFormulario() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MarcaFormulario-view.fxml"));
        Parent marcaFormParent = loader.load();
        MarcaFormularioController marcaFormController = loader.getController();
        marcaFormController.setAvailableCars(cochesList);
        Scene marcaFormScene = new Scene(marcaFormParent);
        currentStage = (Stage) nextButton.getScene().getWindow();
        currentStage.setScene(marcaFormScene);

        //reset the attributes in case the user auit
        currentStage.setOnCloseRequest(event -> {
            System.out.println("you have guit from MarcaForm");
            cochesList = null;
            fechaIn = null;
            fechaFin = null;
        });
        currentStage.show();

    }

}
