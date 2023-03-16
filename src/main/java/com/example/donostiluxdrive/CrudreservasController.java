package com.example.donostiluxdrive;

import clases.CrudReserva;
import clases.Crudcoche;
import clases.Conexion;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class CrudreservasController implements Initializable {

    @FXML
    private TextField apellidoLabel;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private TextField emaiLabel;

    @FXML
    private TableColumn<CrudReserva, String> emailColumn;

    @FXML
    private DatePicker fechInlabel;

    @FXML
    private TableColumn<CrudReserva, Date> fechaFinColumn;

    @FXML
    private DatePicker fechaFinLabel;

    @FXML
    private TableColumn<CrudReserva, Date> fechaInColumn;

    @FXML
    private TableColumn<CrudReserva, Crudcoche> idCocheColumn ;

    @FXML
    private TextField idCocheLabel ;

    @FXML
    private TableColumn<CrudReserva, Integer> idColumn;

    @FXML
    private TextField idLabel;

    @FXML
    private TextField nombreLabel;

    @FXML
    private TableColumn<CrudReserva, Integer> precioToalColumn;

    @FXML
    private TextField precioLabel;

    @FXML
    private TableView<CrudReserva> tblReserva;

    @FXML
    private TableColumn<CrudReserva, String> tefColumn;

    @FXML
    private TextField tefLabel;

    private ObservableList<CrudReserva> listaReserva;

    @FXML
    void actualizarRegistro(ActionEvent event) {

    }

    @FXML
    void eliminarRegistro(ActionEvent event) {

    }

    @FXML
    void guardarRegistro(ActionEvent event) {

    }

    @FXML
    void limpiarComponentes(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Conexion conexion = new Conexion();
        conexion.setConnection();

        //Inicializar listas
        listaReserva = FXCollections.observableArrayList();
        //Llenar listas
        CrudReserva.llenarInformacionReservas(conexion.getConexion(), listaReserva);
        //Enlazar listas con tablaView
        tblReserva.setItems(listaReserva);
        //Enlazar columnas con atributos
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        //idCocheColumn.setCellValueFactory(cellData -> (ObservableValue<Crudcoche>) new PropertyValueFactory<CrudReserva, Crudcoche>("id"));
        fechaInColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<Date>(cellData.getValue().getFechaIn()));
        fechaFinColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<Date>(cellData.getValue().getFechaFin()));
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailClienteProperty());
        tefColumn.setCellValueFactory(cellData -> cellData.getValue().telefonoClienteProperty());
        precioToalColumn.setCellValueFactory(cellData -> cellData.getValue().precioTotalProperty().asObject());
        gestionarEventos();
        conexion.closeConnection();

    }
    public void gestionarEventos(){
        tblReserva.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<CrudReserva>() {
                    @Override
                    public void changed(ObservableValue<? extends CrudReserva> arg0,
                                        CrudReserva valorAnterior, CrudReserva valorSeleccionado) {
                        if (valorSeleccionado!=null){
                            idLabel.setText(String.valueOf(valorSeleccionado.getId()));
                            idCocheLabel.setText(String.valueOf(valorSeleccionado.getCrudcoche().idProperty()));
                            fechaInColumn.setText(valorSeleccionado.getFechaIn().toString());
                            fechaFinColumn.setText(valorSeleccionado.getFechaFin().toString());

                            emaiLabel.setText(String.valueOf(valorSeleccionado.getEmailCliente()));
                            nombreLabel.setText(String.valueOf(valorSeleccionado.getNombreCliente()));
                            apellidoLabel.setText(String.valueOf(valorSeleccionado.getApellidoCliente()));
                            tefLabel.setText(String.valueOf(valorSeleccionado.getTelefonoCliente()));
                            precioLabel.setText(String.valueOf(valorSeleccionado.getPrecioTotal()));

                            btnGuardar.setDisable(true);
                            btnEliminar.setDisable(false);
                            btnActualizar.setDisable(false);
                        }
                    }

                }
        );
    }
}
