/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author 1 daw
 */
public class Contenido {
    private boolean danos;
    private String cantidad;
    private String franquicia;

    public boolean isDanos() {
        return danos;
    }

    public void setDaños(boolean danos) {
        this.danos = danos;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public Contenido(boolean danos, String cantidad, String franquicia) {
        this.danos = danos;
        this.cantidad = cantidad;
        this.franquicia = franquicia;
    }
    
}
