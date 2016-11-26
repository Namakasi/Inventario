/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

/**
 *
 * @author Namakasi
 */
public class Producto<Key extends Comparable> {
    private Key nombre;
    private int serie,cantidad;
    private double precio;
    
    public Producto(Key nombre,int serie,int cantidad,double precio){
        this.nombre=nombre;
        this.serie=serie;
        this.cantidad=cantidad;
        this.precio=precio;
    }

    public Key getNombre() {
        return nombre;
    }

    public void setNombre(Key nombre) {
        this.nombre = nombre;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
