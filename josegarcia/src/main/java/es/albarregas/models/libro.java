/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

import java.io.Serializable;

/**
 *
 * @author 1 daw
 */
public class Libro implements Serializable {
    private String titulo;
    private int cantidad;
    
    //set y get.... y estaran en memoria dependiendo de setsession o hasta que se apage el cliente.

    public String getTitulo() {
        return titulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", cantidad=" + cantidad + '}';
    }
}
