package com.example.donostiluxdrive;
import clases.MasInfoCoche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CochesController {

    @FXML
    private Button alquilarCoche0_0Button;

    @FXML
    private Button alquilarCoche0_1Button;

    @FXML
    private Button alquilarCoche1_0Button;

    @FXML
    private Button alquilarCoche1_1Button;

    @FXML
    private Button alquilarCoche2_0Button;

    @FXML
    private Button alquilarCoche2_1Button;

    @FXML
    private Button cochesButtonNav;

    @FXML
    private Button infoCoche1Button;

    @FXML
    private Button infoCoche2Button;

    @FXML
    private Button infoCoche3Button;

    @FXML
    private Button infoCoche4Button;

    @FXML
    private Button infoCoche5Button;

    @FXML
    private Button infoCoche6Button;

    @FXML
    private Button inicioButtonNav;

    @FXML
    private Button segurosButtonNav;

    @FXML
    private Button signInButton;

    public static String clickedButton;


    //creacion de objetos de MasInfoCoches
    static MasInfoCoche coche1 = new MasInfoCoche("Ferrari", "812GTS", "600", "rojo", "1990", "1000");
    static MasInfoCoche coche2 = new MasInfoCoche("Ferrari", "SF90STRADALE", "650", "rojo", "2002", "1200");
    static MasInfoCoche coche3 = new MasInfoCoche("Rolls-Royce", "Spectre", "570", "amarillo", "2000", "1500");
    static MasInfoCoche coche4 = new MasInfoCoche("Rolls-Royce", "Dawn", "550", "azul", "2005", "1100");
    static MasInfoCoche coche5 = new MasInfoCoche("Bugatti", "Chiron", "600", "azul", "2010", "1550");
    static MasInfoCoche coche6 = new MasInfoCoche("Mercedes", "AMGGT", "450", "gris", "2014", "1400");


    @FXML
    void goToCoches(ActionEvent event) {
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
    void goToInfoCoche(ActionEvent event) {
        if (event.getSource() == infoCoche1Button) {
            clickedButton = "infoCoche1Button";
        } else if (event.getSource() == infoCoche2Button) {
            clickedButton = "infoCoche2Button";
        } else if (event.getSource() == infoCoche3Button) {
            clickedButton = "infoCoche3Button";
        } else if (event.getSource() == infoCoche4Button) {
            clickedButton = "infoCoche4Button";
        } else if (event.getSource() == infoCoche5Button) {
            clickedButton = "infoCoche5Button";
        } else if (event.getSource() == infoCoche6Button) {
            clickedButton = "infoCoche6Button";
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("InfoCoche-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) infoCoche1Button.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
/*
        if (event.getSource()==infoCoche2Button)
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoCoche-view.fxml"));
                Parent root = loader.load();

                InfoCohesController controller = loader.getController();
                //controller.setCoche(coche2);

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            } */



    /*void infoCocheContenido(MasInfoCoche coche, String img1, String img2, String img3) {
        //make the photos in MasInfoCoches desde elos parametros img... y
        //make los labels desde los infos de coche -> mejor ser otro metodo
        InfoCohesController.class.get
        InfoCohesController.modeloLabel.setText(coche1.getMarca());
        InfoCohesController.anoLabel.setText(coche1.getMarca());
        InfoCohesController.colorLabel.setText(coche1.getMarca());
        InfoCohesController.prclabel.setText(coche1.getMarca());
        InfoCohesController.cvLabel.setText(coche1.getMarca());
        //crear un scene con el contenido y stage.setScene(esteScene);

    }*/



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
    void goToReserva(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FechaFormulario-view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (Exception e) {
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
    void goToSignIn(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginSignup-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) signInButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
