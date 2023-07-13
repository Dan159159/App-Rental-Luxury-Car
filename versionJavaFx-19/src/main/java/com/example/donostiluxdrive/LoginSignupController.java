package com.example.donostiluxdrive;

import clases.Connectiondb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginSignupController {

    @FXML
    private PasswordField logContraTf;

    @FXML
    private TextField logEmailTf;

    @FXML
    private Button loginButton;

    @FXML
    private Pane loginPane;

    @FXML
    private Button salirVentanaButton;

    @FXML
    private TextField signApellidoTf;

    @FXML
    private PasswordField signConfirmarTf;

    @FXML
    private PasswordField signContraTf;

    @FXML
    private TextField signEmailTf;

    @FXML
    private TextField signNombreTf;

    @FXML
    private TextField signTelfTF;

    @FXML
    private Button signUpButton;

    @FXML
    private Pane signupPane;
    private static LoginSignupController instance;
    private boolean signUpBoolean;

    Connection conn = new Connectiondb().getConnection();
    // Constructor privado para evitar la creación directa de instancias
    private LoginSignupController() {
    }

    // Método estático para obtener la instancia única de la clase
    public static LoginSignupController getInstance() {
        if (instance == null) {
            instance = new LoginSignupController();
        }
        return instance;
    }

    public void setSignUpBoolean(boolean signUpBoolean) {
        this.signUpBoolean = signUpBoolean;
    }

    public boolean isSignUpBoolean() {
        return signUpBoolean;
    }

    public void initialize() {
        System.out.println(isSignUpBoolean());
        loginPane.setVisible(!isSignUpBoolean());
        loginPane.setDisable(isSignUpBoolean());
        signupPane.setDisable(!isSignUpBoolean());
        signupPane.setVisible(isSignUpBoolean());
    }

    @FXML
    void Login(ActionEvent event) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM usuarios " +
                    "WHERE usuario='"+logEmailTf.getText()+"' " +
                    "AND contrasena='"+logContraTf.getText()+"'");
            if(resultSet.next()){
                System.out.println("Usuario validado");
                this.goToCrud();
            } else {
                System.out.println("No correcto");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    public void Signup(ActionEvent event) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "INSERT INTO usuarios " +
                            "(email, contrasena, nombre, apellidos, telf)" +
                            "VALUES('"+signEmailTf.getText()+"', '"+signContraTf.getText()+"', '"+signNombreTf.getText() + "," +
                            " '"+signApellidoTf.getText()+"', '"+signTelfTF.getText()+"')"

            );
            if(resultSet.next()){
                System.out.println("Registro guardado");
                this.gotToInicio();
            }
            else {
                System.out.println("No correcto");
            }
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @FXML
    void gotToInicio() {
        Stage stage;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Inicio-view.fxml"));
            Scene scene = new Scene(root);
            stage = (Stage) salirVentanaButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void goToCrud() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Crudportada-view.fxml"));
            //root=FXMLLoader.load(getClass().getClassloader().getResource("application/Models/Views/ProductView.fxml")
            Scene scene = new Scene(root);
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

