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
public class Eleccion {
    private boolean edificio;
    private boolean contenido;

    public boolean isEdificio() {
        return edificio;
    }

    public void setEdificio(boolean edificio) {
        this.edificio = edificio;
    }

    public boolean isContenido() {
        return contenido;
    }

    public void setContenido(boolean contenido) {
        this.contenido = contenido;
    }

    public Eleccion(boolean edificio, boolean contenido) {
        this.edificio = edificio;
        this.contenido = contenido;
    }
    
    
}
