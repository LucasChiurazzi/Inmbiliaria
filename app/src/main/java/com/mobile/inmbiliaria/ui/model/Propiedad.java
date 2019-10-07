package com.mobile.inmbiliaria.ui.model;

public class Propiedad {
    private int id;
    private int foto;
    private String direccion;
    private double precio;



    public Propiedad(int id, int foto, String direccion, double precio) {
        this.id= id;
        this.foto = foto;
        this.direccion = direccion;
        this.precio = precio;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
