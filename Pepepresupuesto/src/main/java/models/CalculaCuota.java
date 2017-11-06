/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author daw1
 */
public class CalculaCuota {
    public double CalculaCuota(String tipoedificio,String habitaciones,String fechacons,String tipoconstruc,String valor){
       double prima=0.0d;
       try {
           double cuotabasica=Integer.parseInt(valor)*0.005;
           switch (tipoedificio){
               case "piso":
                   prima=cuotabasica*0.95;
                   break;
               case "casa":
                   prima=cuotabasica*1;
                   break;
               case "adosado":
                   prima=cuotabasica*1.05;
                   break;
               case "duplex":
                   prima=cuotabasica*1.10;
                   break;
               case "chalet":
                   prima=cuotabasica*1.20;
                   break;
           }
           prima+=(prima/100)*Integer.parseInt(habitaciones);
           switch (fechacons){
               case "1949":
                   prima+=prima*0.09;
                   break;
               case "1950":
                   prima+=prima*0.06;
                   break;
               case "1991":
                   prima+=prima*0.04;
                   break;
               case "2006":
                   prima+=prima*0.02;
                   break;
               case "2016":
                   prima+=prima*0.01;
                   break;
           }
           if (tipoconstruc=="madera"){
               prima+=prima*0.1;
           }
           
       }
       catch (NumberFormatException e){
           //error de numeros (en este caso será díficil ya que lo hemos controlado nosotros
       }
        return prima;
    }
    public double CalculaCuota(boolean danos,String cantidad,String franquicia){
        double prima=Integer.parseInt(cantidad)*0.008;
        if (danos){
            prima+=prima*1.25;
        }
        switch (franquicia){
            
            case "500":
                prima-=prima*0.1;
                break;
            case "1000":
                prima-=prima*0.2;
        }
        return prima;
    }
}
