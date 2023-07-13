package clases;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.sql.*;

public class CrudReserva {
    //Declaracion de variables
        IntegerProperty id;
        Crudcoche crudcoche;
        Date fechaIn;
        Date fechaFin;
        StringProperty nombreCliente;
        StringProperty apellidoCliente;
        StringProperty emailCliente;
        StringProperty telefonoCliente;
        IntegerProperty precioTotal;

        //Constructor
    public CrudReserva(Integer id, Crudcoche crudcoche, Date fechaIn, Date fechaFin, String nombreCliente, String apellidoCliente, String emailCliente, String telefonoCliente, Integer precioTotal) {
        this.id = new SimpleIntegerProperty(id);
        this.crudcoche = crudcoche ;
        this.fechaIn = fechaIn;
        this.fechaFin = fechaFin;
        this.nombreCliente = new SimpleStringProperty(nombreCliente);
        this.apellidoCliente = new SimpleStringProperty(apellidoCliente);
        this.emailCliente = new SimpleStringProperty(emailCliente);
        this.telefonoCliente = new SimpleStringProperty(telefonoCliente);
        this.precioTotal = new SimpleIntegerProperty(precioTotal);
    }
    //Mestodos getter, setter y Property
    //id
    public int getId(){
        return id.get();
    }

    public void setId(int id_coche){
        this.id = new SimpleIntegerProperty(id_coche);
    }
    public IntegerProperty idProperty(){
        return id;
    }


    public Crudcoche getCrudcoche() {
        return crudcoche;
    }

    public void setCrudcoche(Crudcoche crudcoche) {
        this.crudcoche = crudcoche;
    }

    //Fecha Inicio
    public Date getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
    }
    // Fecha Fin
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    //Nombre
    public String getNombreCliente() {
        return nombreCliente.get();
    }

    public StringProperty nombreClienteProperty() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente.set(nombreCliente);
    }
    //Apellido
    public String getApellidoCliente() {
        return apellidoCliente.get();
    }

    public StringProperty apellidoClienteProperty() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente.set(apellidoCliente);
    }
    //Email
    public String getEmailCliente() {
        return emailCliente.get();
    }

    public StringProperty emailClienteProperty() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente.set(emailCliente);
    }
    //Telefono
    public String getTelefonoCliente() {
        return telefonoCliente.get();
    }

    public StringProperty telefonoClienteProperty() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente.set(telefonoCliente);
    }
    //Precio
    public int getPrecioTotal() {
        return precioTotal.get();
    }

    public IntegerProperty precioTotalProperty() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal.set(precioTotal);
    }

    public static void llenarInformacionReservas(Connection connectiondb, ObservableList<CrudReserva> listaReserva){
        try {
            Statement instruccion = connectiondb.createStatement();
            ResultSet resultado = instruccion.executeQuery(
                    "SELECT A.id," +
                            " A.id_coche, " +
                            "A.fechaIn, " +
                            "A.fechaFin, " +
                            "A.nombreCliente, " +
                            "A.apellidoCliente, " +
                            "A.emailCliente, " +
                            "A.telefonoCliente, " +
                            "A.precioTotal " +
                            "FROM reservas A " +
                            "INNER JOIN coches B " +
                            "ON (A.id_coche = B.id) "

            );
            while(resultado.next()){
                listaReserva.add(
                        new CrudReserva(
                                resultado.getInt("id"),
                                new Crudcoche(
                                        resultado.getInt("id_coche")),
                                resultado.getDate("fechaIn"),
                                resultado.getDate("fechaFin"),
                                resultado.getString("nombreCliente"),
                                resultado.getString("apellidoCliente"),
                                resultado.getString("emailCliente"),
                                resultado.getString("telefonoCliente"),
                                resultado.getInt("precioTotal")

                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

