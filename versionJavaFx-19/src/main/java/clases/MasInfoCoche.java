package clases;

public class MasInfoCoche {
    private String marca;
    private String modelo;
    private String caballos;
    private String color;
    private String ano;
    private String precio_base;

    public MasInfoCoche(String marca, String modelo, String caballos, String color, String ano, String precio_base) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setCaballos(caballos);
        this.setColor(color);
        this.setAno(ano);
        this.setPrecio_base(precio_base);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCaballos() {
        return caballos;
    }

    public void setCaballos(String caballos) {
        this.caballos = caballos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(String precio_base) {
        this.precio_base = precio_base;
    }

}
