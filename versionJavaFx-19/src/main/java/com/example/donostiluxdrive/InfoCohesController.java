package com.example.donostiluxdrive;

import clases.MasInfoCoche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InfoCohesController implements Initializable{


    @FXML
    private Label CaballosLabel;

    @FXML
    private Label ColorLabel;

    @FXML
    private Label anoLabel;

    @FXML
    private Button cochesButton;

    @FXML
    private Button cochesButtonNav;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private Button inicioButtonNav;

    @FXML
    private Label marcaLabel;

    @FXML
    private Label modeloLabel;

    @FXML
    private Label precioLabel;

    @FXML
    private Button segurosButtonNav;

    private static MasInfoCoche coche;

    //Metodos

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

    }

    @FXML
    void goToBeforeImage(ActionEvent event) {

    }

    @FXML
    void goToNextImage(ActionEvent event) {

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (CochesController.clickedButton == "infoCoche1Button") {
            rellenarCoche1();
        } else if (CochesController.clickedButton == "infoCoche2Button") {
            rellenarCoche2();
        } else if (CochesController.clickedButton == "infoCoche3Button") {
            rellenarCoche3();
        } else if (CochesController.clickedButton == "infoCoche4Button") {
            rellenarCoche4();
        } else if (CochesController.clickedButton == "infoCoche5Button") {
            rellenarCoche5();
        } else if (CochesController.clickedButton == "infoCoche6Button") {
            rellenarCoche6();
        }



    }
        /*
        public void setCoche(MasInfoCoche coche, String img1, String img2, String img3) {

            InfoCohesController.coche = coche;

            Image image1 = new Image(img1);
            Image image2 = new Image(img2);
            Image image3 = new Image(img3);

            this.marcaLabel.setText(InfoCohesController.coche.getMarca());
            this.modeloLabel.setText(InfoCohesController.coche.getModelo());
            this.CaballosLabel.setText(InfoCohesController.coche.getCaballos());
            this.ColorLabel.setText(InfoCohesController.coche.getColor());
            this.anoLabel.setText(InfoCohesController.coche.getAno());
            this.precioLabel.setText(InfoCohesController.coche.getPrecio_base());

            this.img1.setImage(image1);
            this.img2.setImage(image2);
            this.img3.setImage(image3);

        }
        */

        public void rellenarCoche1(){
            this.marcaLabel.setText(CochesController.coche1.getMarca());
            this.modeloLabel.setText(CochesController.coche1.getModelo());
            this.CaballosLabel.setText(CochesController.coche1.getCaballos());
            this.ColorLabel.setText(CochesController.coche1.getColor());
            this.anoLabel.setText(CochesController.coche1.getAno());
            this.precioLabel.setText(CochesController.coche1.getPrecio_base());

            this.img1.setImage(new Image("img/Coches/ferrari1-img/ferrari1-img1.png"));
            this.img2.setImage(new Image("img/Coches/ferrari1-img/ferrari1-img2.png"));
            this.img3.setImage(new Image("img/Coches/ferrari1-img/ferrari1-img3.png"));
        }

    public void rellenarCoche2(){
        this.marcaLabel.setText(CochesController.coche2.getMarca());
        this.modeloLabel.setText(CochesController.coche2.getModelo());
        this.CaballosLabel.setText(CochesController.coche2.getCaballos());
        this.ColorLabel.setText(CochesController.coche2.getColor());
        this.anoLabel.setText(CochesController.coche2.getAno());
        this.precioLabel.setText(CochesController.coche2.getPrecio_base());

        this.img1.setImage(new Image("img/Coches/ferrari2-img/ferrari2-img1.png"));
        this.img2.setImage(new Image("img/Coches/ferrari2-img/ferrari2-img2.png"));
        this.img3.setImage(new Image("img/Coches/ferrari2-img/ferrari2-img3.png"));
    }

    public void rellenarCoche3(){
        this.marcaLabel.setText(CochesController.coche3.getMarca());
        this.modeloLabel.setText(CochesController.coche3.getModelo());
        this.CaballosLabel.setText(CochesController.coche3.getCaballos());
        this.ColorLabel.setText(CochesController.coche3.getColor());
        this.anoLabel.setText(CochesController.coche3.getAno());
        this.precioLabel.setText(CochesController.coche3.getPrecio_base());

        this.img1.setImage(new Image("img/Coches/rolls-royce-spectre-img/rolls-royce-spectre-img1.png"));
        this.img2.setImage(new Image("img/Coches/rolls-royce-spectre-img/rolls-royce-spectre-img2.png"));
        this.img3.setImage(new Image("img/Coches/rolls-royce-spectre-img/rolls-royce-spectre-img3.png"));
    }

    public void rellenarCoche4(){
        this.marcaLabel.setText(CochesController.coche4.getMarca());
        this.modeloLabel.setText(CochesController.coche4.getModelo());
        this.CaballosLabel.setText(CochesController.coche4.getCaballos());
        this.ColorLabel.setText(CochesController.coche4.getColor());
        this.anoLabel.setText(CochesController.coche4.getAno());
        this.precioLabel.setText(CochesController.coche4.getPrecio_base());

        this.img1.setImage(new Image("img/Coches/rolls-royce-dawn/rolls-royce-dawn-img1.png"));
        this.img2.setImage(new Image("img/Coches/rolls-royce-dawn/rolls-royce-dawn-img2.png"));
        this.img3.setImage(new Image("img/Coches/rolls-royce-dawn/rolls-royce-dawn-img3.png"));
    }

    public void rellenarCoche5(){
        this.marcaLabel.setText(CochesController.coche5.getMarca());
        this.modeloLabel.setText(CochesController.coche5.getModelo());
        this.CaballosLabel.setText(CochesController.coche5.getCaballos());
        this.ColorLabel.setText(CochesController.coche5.getColor());
        this.anoLabel.setText(CochesController.coche5.getAno());
        this.precioLabel.setText(CochesController.coche5.getPrecio_base());

        this.img1.setImage(new Image("img/Coches/bugatti-chiron-img/bugatti-chiron-img1.png"));
        this.img2.setImage(new Image("img/Coches/bugatti-chiron-img/bugatti-chiron-img2.png"));
        this.img3.setImage(new Image("img/Coches/bugatti-chiron-img/bugatti-chiron-img3.png"));
    }

    public void rellenarCoche6(){
        this.marcaLabel.setText(CochesController.coche6.getMarca());
        this.modeloLabel.setText(CochesController.coche6.getModelo());
        this.CaballosLabel.setText(CochesController.coche6.getCaballos());
        this.ColorLabel.setText(CochesController.coche6.getColor());
        this.anoLabel.setText(CochesController.coche6.getAno());
        this.precioLabel.setText(CochesController.coche6.getPrecio_base());

        this.img1.setImage(new Image("img/Coches/mercedes-amg-gt-img/mercedes-amg-gt-img1.jpg"));
        this.img2.setImage(new Image("img/Coches/mercedes-amg-gt-img/mercedes-amg-gt-img2.jpg"));
        this.img3.setImage(new Image("img/Coches/mercedes-amg-gt-img/mercedes-amg-gt-img3.jpg"));
    }

}





