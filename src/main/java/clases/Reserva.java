package clases;

import java.time.LocalDate;

public class Reserva {
        int id_reserva;
        int id_coche;
        LocalDate fechaIn;
        LocalDate fechaFin;
        String nombreCliente;
        String apellidoCliente;
        String emailCliente;
        String telefonoCliente;
        int precioTotal;


    public Reserva(int id_coche, LocalDate fechaIn, LocalDate fechaFin, String nombreCliente, String apellidoCliente, String emailCliente, String telefonoCliente, int precioTotal) {
        this.id_coche = id_coche;
        this.fechaIn = fechaIn;
        this.fechaFin = fechaFin;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.emailCliente = emailCliente;
        this.telefonoCliente = telefonoCliente;
        this.precioTotal = precioTotal;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_coche() {
        return id_coche;
    }

    public void setId_coche(int id_coche) {
        this.id_coche = id_coche;
    }

    public LocalDate getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(LocalDate fechaIn) {
        this.fechaIn = fechaIn;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
}

