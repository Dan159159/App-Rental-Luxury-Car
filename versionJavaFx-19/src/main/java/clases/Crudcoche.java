package clases;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.*;

public class Crudcoche {
    private IntegerProperty id;
    private StringProperty marca;
    private StringProperty modelo;
    private StringProperty color;
    private IntegerProperty precioBase;

    public Crudcoche(int id, String marca, String modelo, String color, int precioBase) {

        this.id = new SimpleIntegerProperty(id);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.color = new SimpleStringProperty(color);
        this.precioBase = new SimpleIntegerProperty(precioBase);
    }

    public Crudcoche(String marca, String modelo, String color, int precioBase) {
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.color = new SimpleStringProperty(color);
        this.precioBase = new SimpleIntegerProperty(precioBase);
    }
    public Crudcoche(int id) {

        this.id = new SimpleIntegerProperty(id);

    }



    //Metodos getter, setter and property
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

    //Marca
    public String getMarca(){
        return marca.get();
    }

    public void setMarca(String marca){
        this.marca = new SimpleStringProperty(marca);
    }
    public StringProperty marcaProperty(){
        return marca;
    }
    //Modelo
    public String getModelo(){
        return modelo.get();
    }

    public void setModelo(String modelo){
        this.modelo = new SimpleStringProperty(modelo);
    }
    public StringProperty modeloProperty(){
        return modelo;
    }
    //Color
    public String getColor(){
        return color.get();
    }

    public void setColor(String color){
        this.color = new SimpleStringProperty(color);
    }
    public StringProperty colorProperty(){
        return color;
    }
    //Precio Base
    public Integer getPrecio_base(){
        return precioBase.get();
    }

    public void setPrecio_base(Integer precio_base){
        this.precioBase = new SimpleIntegerProperty(precio_base);
    }

    public IntegerProperty precioProperty(){
        return precioBase;
    }


    public int guardarRegistro(Connection connectiondb){
        try {
            //Evitar inyeccion SQL.
            PreparedStatement instruccion =
                    connectiondb.prepareStatement("INSERT INTO coches (marca, modelo, color, precioBase) "+
                            "VALUES (?, ?, ?, ?)");
            instruccion.setString(1, modelo.get());
            instruccion.setString(2, marca.get());
            instruccion.setString(3, color.get());
            instruccion.setInt(4, precioBase.get());
            return instruccion.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int actualizarRegistro(Connection connectiondb){
        try {
            PreparedStatement instruccion =
                    connectiondb.prepareStatement(
                            "UPDATE coches "+
                                    " SET 	id = ?,  "+
                                    " marca = ?,  "+
                                    " modelo = ?, "+
                                    " color = ?,  "+
                                    " precioBase = ?"

                    );
            instruccion.setString(1, modelo.get());
            instruccion.setString(2, marca.get());
            instruccion.setString(3, color.get());
            instruccion.setInt(4, precioBase.get());
            return instruccion.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int eliminarRegistro(Connection connectiondb){
        try {
            PreparedStatement instruccion = connectiondb.prepareStatement(
                    "DELETE FROM coches "+
                            "WHERE id = ?"
            );
            instruccion.setInt(1, getId());
            return instruccion.executeUpdate();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Este esta reservado, no se puede eliminar");
            alert.showAndWait();
            e.printStackTrace();
            return 0;
        }
    }

    public static void llenarInformacionCoches(Connection connectiondb, ObservableList<Crudcoche> listaCoChe){
        try {
            Statement instruccion = connectiondb.createStatement();
            ResultSet resultado = instruccion.executeQuery(
                    "SELECT id," +
                            " marca, " +
                            " modelo, " +
                            " color, " +
                            " precioBase " +
                            "FROM coches "

            );
            while(resultado.next()){
                listaCoChe.add(
                        new Crudcoche(
                                resultado.getInt("id"),
                                resultado.getString("marca"),
                                resultado.getString("modelo"),
                                resultado.getString("color"),
                                resultado.getInt("precioBase")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
