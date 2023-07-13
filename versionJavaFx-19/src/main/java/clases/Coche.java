package clases;

public class Coche {
    //Declaracion de variables
    private int id_coche;
    private String marca;
    private String modelo;
    private String color;
    private int precio_base;
    //Metodo Constructor

    public Coche(int id_coche, String marca, String modelo, String color, int precio_base) {
        this.setId_coche(id_coche);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setColor(color);
        this.setPrecio_base(precio_base);
    }

    public int getId_coche() {
        return id_coche;
    }

    public void setId_coche(int id_coche) {
        this.id_coche = id_coche;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(int precio_base) {
        this.precio_base = precio_base;
    }

}
