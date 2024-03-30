package com.proyect_app.proyectomovilpos;

public class CarritoModel {
    String nameProducto;
    String precioProducto;

    public CarritoModel(String nameProducto, String precioProducto) {
        this.nameProducto = nameProducto;
        this.precioProducto = precioProducto;
    }

    public String getNameProducto() {
        return nameProducto;
    }

    public void setNameProducto(String nameProducto) {
        this.nameProducto = nameProducto;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }
}
