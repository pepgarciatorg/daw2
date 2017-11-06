/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import models.CalculaCuota;



/**
 *
 * @author 1 daw
 */
public class Edificio {
    private String tipoedificio;
    private String habitaciones;
    private String fechacons;
    private String tipoconstruc;
    private String valor;
    private double cuota;
public Edificio(){
    
}
public Edificio(String tipoedificio, String habitaciones, String fechacons, String tipoconstruc, String valor) {
        this.tipoedificio = tipoedificio;
        this.habitaciones = habitaciones;
        this.fechacons = fechacons;
        this.tipoconstruc = tipoconstruc;
        this.valor = valor;
        
        CalculaCuota cuota1=new CalculaCuota();
        this.cuota=cuota1.CalculaCuota(tipoedificio,habitaciones,fechacons,tipoconstruc,valor);
        
    }
    public String getTipoedificio() {
        return tipoedificio;
    }

    public void setTipoedificio(String tipoedificio) {
        this.tipoedificio = tipoedificio;
    }

    public String getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(String habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getFechacons() {
        return fechacons;
    }

    public void setFechacons(String fechacons) {
        this.fechacons = fechacons;
    }

    public String getTipoconstruc() {
        return tipoconstruc;
    }

    public void setTipoconstruc(String tipoconstruc) {
        this.tipoconstruc = tipoconstruc;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    
    
    
    
}
