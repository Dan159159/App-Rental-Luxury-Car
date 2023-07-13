package com.example.donostiluxdrive;



import clases.Crudcoche;
import clases.Connectiondb;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CrudcochesController implements Initializable {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private TableColumn<Crudcoche, String> clmnColor;

    @FXML
    private TableColumn<Crudcoche, Integer> clmnId;

    @FXML
    private TableColumn<Crudcoche, String> clmnMarca;

    @FXML
    private TableColumn<Crudcoche, String> clmnModelo;

    @FXML
    private TableColumn<Crudcoche, Integer> clmnPrecio;

    @FXML
    private TextField colorLabel;


    @FXML
    private TextField idLabel;

    @FXML
    private TextField marcaLabel;

    @FXML
    private TextField modeloLabel;

    @FXML
    private TextField precioLabel;

    @FXML
    private TableView<Crudcoche> tblCoches;

    private java.sql.Connection connection;

    private ObservableList<Crudcoche> listaCoChe;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connectiondb conn = new Connectiondb();
        conn.setConnection();

        //Inicializar listas
        listaCoChe = FXCollections.observableArrayList();
        //Llenar listas
        Crudcoche.llenarInformacionCoches(conn.getConnection(), listaCoChe);
        //Enlazar listas con tablaView
        tblCoches.setItems(listaCoChe);
        //Enlazar columnas con atributos
        clmnId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        clmnMarca.setCellValueFactory(cellData -> cellData.getValue().marcaProperty());
        clmnModelo.setCellValueFactory(cellData -> cellData.getValue().modeloProperty());
        clmnColor.setCellValueFactory(cellData -> cellData.getValue().colorProperty());
        clmnPrecio.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());

        gestionarEventos();
        conn.closeConnection();
    }
    public void gestionarEventos(){
        tblCoches.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Crudcoche>() {
                    @Override
                    public void changed(ObservableValue<? extends Crudcoche> arg0,
                                        Crudcoche valorAnterior, Crudcoche valorSeleccionado) {
                        if (valorSeleccionado!=null){
                            idLabel.setText(String.valueOf(valorSeleccionado.getId()));
                            marcaLabel.setText(String.valueOf(valorSeleccionado.getMarca()));
                            modeloLabel.setText(valorSeleccionado.getModelo());
                            colorLabel.setText(valorSeleccionado.getColor());
                            precioLabel.setText(String.valueOf(valorSeleccionado.getPrecio_base()));

                            btnGuardar.setDisable(true);
                            btnEliminar.setDisable(false);
                            btnActualizar.setDisable(false);
                        }
                    }

                }
        );
    }

    @FXML
    public void guardarRegistro(){
        Connectiondb connectiondb = new Connectiondb();
        connectiondb.setConnection();

        //Crear una nueva instancia del tipo Alumno
        Crudcoche a = new Crudcoche(
                marcaLabel.getText(),
                modeloLabel.getText(),
                colorLabel.getText(),
                Integer.valueOf(precioLabel.getText()));


        //Llamar al metodo guardarRegistro de la clase Alumno
        connectiondb.setConnection();
        int resultant = a.guardarRegistro(connectiondb.getConnection());
        connectiondb.closeConnection();

        if (resultant == 1){
            listaCoChe.add(a);
            //JDK 8u>40
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Registro agregado");
            mensaje.setContentText("El registro ha sido agregado exitosamente");
            mensaje.setHeaderText("Resultado:");
            mensaje.show();
        }
    }

    @FXML
    public void actualizarRegistro(){
        Connectiondb connectiondb = new Connectiondb();
        Crudcoche a = new Crudcoche(
                Integer.valueOf(idLabel.getText()),
                marcaLabel.getText(),
                modeloLabel.getText(),
                colorLabel.getText(),
                Integer.valueOf(precioLabel.getText()));

        connectiondb.setConnection();
        int resultado = a.actualizarRegistro(connectiondb.getConnection());
        connectiondb.closeConnection();

        if (resultado == 1){
            listaCoChe.set(tblCoches.getSelectionModel().getSelectedIndex(),a);
            //JDK 8u>40
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Registro actualizado");
            mensaje.setContentText("El registro ha sido actualizado exitosamente");
            mensaje.setHeaderText("Resultado:");
            mensaje.show();
        }
    }

    @FXML
    public void eliminarRegistro(){
        Connectiondb connectiondb = new Connectiondb();
        connectiondb.setConnection();
        int resultado = tblCoches.getSelectionModel().getSelectedItem().eliminarRegistro(connectiondb.getConnection());
        connectiondb.closeConnection();

        if (resultado == 1){
            listaCoChe.remove(tblCoches.getSelectionModel().getSelectedIndex());
            //JDK 8u>40
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Registro eliminado");
            mensaje.setContentText("El registro ha sido eliminado exitosamente");
            mensaje.setHeaderText("Resultado:");
            mensaje.show();
        }
    }

    @FXML
    public void limpiarComponentes(){
        idLabel.setText(null);
        marcaLabel.setText(null);
        modeloLabel.setText(null);
        colorLabel.setText(null);
        precioLabel.setText(null);

        btnGuardar.setDisable(false);
        btnEliminar.setDisable(true);
        btnActualizar.setDisable(true);
    }
}


