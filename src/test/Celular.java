/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Victor
 */
public class Celular {

    private int id;
    private String modelo;
    private String marca;
    private double precio;
    private int unNumero;

    public Celular(int id, String modelo, String marca, double precio, int unNumero) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.unNumero = unNumero;
    }

    public int getUnNumero() {
        return unNumero;
    }

    public void setUnNumero(int unNumero) {
        this.unNumero = unNumero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Celular{" + "id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", unNumero=" + unNumero + '}';
    }

}
