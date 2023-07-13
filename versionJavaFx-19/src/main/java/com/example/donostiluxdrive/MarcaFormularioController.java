package com.example.donostiluxdrive;

import clases.Coche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;


//when the user select the marca and he modelo required -> {
//        precioLabel.setText(precioTotal + "€");
//        precioTitleLabel.setVisible(true);
//        precioLabel.setVisible(true);
// }
public class MarcaFormularioController {

    @FXML
    private ComboBox<String> colorCombo;

    @FXML
    private ComboBox<String> marcaCombo;

    @FXML
    private ComboBox<String> modeloCombo;

    @FXML
    private Button nextButton;

    @FXML
    private Label precioLabel;

    @FXML
    private Label precioTitleLabel;

    static ObservableList<String> marcas;//tabla de las marcas disponible
    static ObservableList<String> modelos;//los modelos de la marcaElejida - siempre los disponibles
    static ObservableList<String> colores;

    static int diasElejido; //cantidad de dias elejidos
    static int precioTotal; // precioBase * dias
    static String marcaElejida;
    static String modeloElejido;
    static String colorElejido;

    static Coche cocheElejido;

    public void initialize() {
        //add listener to marcaCombo to fill the modeloCombo
        marcaCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Filter the cochesList to include only Coches with the selected marca
                modelos = FechaFormularioController.cochesList.stream().filter(coche -> coche.getMarca().equals(newValue)).map(Coche::getModelo).distinct().sorted().collect(Collectors.toCollection(FXCollections::observableArrayList));
                /* Explanation
                In this code, we use the stream method to create a stream of the cochesList elements.
                We then use the filter method to only include elements where the marca attribute is equal to marcaElejida.
                The map method is used to transform the Coche objects to their modelo attribute,
                and the resulting stream of modelo values is collected into an ObservableList<String> using the Collectors.toCollection method,
                which creates a new ObservableList instance.
                */
                modeloCombo.setItems(modelos);
            } else {
                modeloCombo.setItems(null);
            }
        } );

        //add listener to modeloCombo to fill the colorCombo
        modeloCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                marcaElejida = marcaCombo.getValue();
                if (marcaElejida != null) {
                    // Filter the cochesList to include only Coches with the selected marca, modelo
                    colores = FechaFormularioController.cochesList.stream().filter(coche -> coche.getMarca().equals(marcaElejida) && coche.getModelo().equals(newValue)).map(Coche::getColor).distinct().sorted().collect(Collectors.toCollection(FXCollections::observableArrayList));
                    colorCombo.setItems(colores);
                }
            } else {
                colorCombo.setItems(null);
            }
        });

        //add a listener to colorCombo to calculate precioTotal and set it to the precioLabel - and to save the cocheElejido
        colorCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                cocheElejido = FechaFormularioController.cochesList.filtered(coche ->
                        coche.getMarca().equals(marcaCombo.getValue()) &&
                                coche.getModelo().equals(modeloCombo.getValue()) &&
                                coche.getColor().equals(newValue)
                ).get(0);

                //calculate the days
                long diasLong = ChronoUnit.DAYS.between(FechaFormularioController.fechaIn, FechaFormularioController.fechaFin);

                diasElejido = (int) diasLong + 1;

                precioTotal = cocheElejido.getPrecio_base() * diasElejido;

                precioLabel.setText(String.valueOf(precioTotal) + "€");

                setLabelsVisible();
            } else {
                setLabelsInvisible();
            }

        });
    }

    private void setLabelsVisible() {
        precioTitleLabel.setVisible(true);
        precioLabel.setVisible(true);
    }
    private void setLabelsInvisible() {
        precioTitleLabel.setVisible(false);
        precioLabel.setVisible(false);
    }


    @FXML
    void goToClienteFormulario(ActionEvent event) throws IOException {
        //check if all the combos are filled, if not alert
        if (marcaCombo.getSelectionModel().isEmpty() || modeloCombo.getSelectionModel().isEmpty() || colorCombo.getSelectionModel().isEmpty()) {
            showAlertDialog("rellena todos los campos");
        } else {
            //save cocheElejido y fechaIn y fechaFin
            marcaElejida = marcaCombo.getValue();
            modeloElejido = modeloCombo.getValue();
            colorElejido = colorCombo.getValue();

            //go to the  ClienteFormulario
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ClienteFormulario-view.fxml"));
            Parent clienteFormParent = loader.load();
            ClienteFormularioController clienteFormController = loader.getController();
            Scene clienteFormScene = new Scene(clienteFormParent);
            Stage currentStage = (Stage) nextButton.getScene().getWindow();
            currentStage.setScene(clienteFormScene);

            //reset the attributes in case the user auit
            currentStage.setOnCloseRequest(closeEvent -> {
                marcaCombo.getSelectionModel().clearSelection();
                modeloCombo.getSelectionModel().clearSelection();
                colorCombo.getSelectionModel().clearSelection();
            });

            currentStage.show();
        }
    }

    public static void showAlertDialog(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


    public void setAvailableCars(ObservableList<Coche> cochesList) {
        //fill marcaCombo with the marcas disponibles
        marcas = cochesList.stream().map(Coche::getMarca).distinct().collect(Collectors.toCollection(FXCollections::observableArrayList));
        /*Explanation
        * The stream() method is called on cochesLista to convert it to a Stream of Coche objects.
        The map() method is used to extract the marca attribute from each Coche object.
        The distinct() method is used to keep only unique marca values.
        Finally, the collect() method is used to collect the unique marca values into an ObservableList<String> using FXCollections.observableArrayList() as the target collection supplier.*/
        marcaCombo.setItems(marcas);
    }
}

//proxima version:
//    - Añadir un button de volver
//    - Añadir unos labels para decir al cliente los informaciones que ha elejido

