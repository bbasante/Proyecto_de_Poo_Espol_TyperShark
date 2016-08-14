/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.util.ArrayList;

/**
 *
 * @author basantes
 */
public class Vidas_del_jugador {

    private ArrayList <Tiburon_con_hilo> tiburon;
    private ArrayList <Pirañas_con_hilo> piraña;
    private ArrayList <Tiburon_negro_con_hilo> tiburon_negro;
    private int vidas_del_buceador =3, acumulador_pirañas=0;
    
    public Vidas_del_jugador(ArrayList <Tiburon_con_hilo> tiburon, ArrayList <Pirañas_con_hilo> piraña,ArrayList <Tiburon_negro_con_hilo> tiburon_negro) {
        this.tiburon=tiburon;
        this.piraña=piraña;
        this.tiburon_negro=tiburon_negro;
    }
    
    public void Vidas_perdidas() {
        for(Tiburon_con_hilo mostrar:getTiburon()){
            if(mostrar.getCrear_animales().getTranslateX()<55){
                vidas_del_buceador--;
                System.out.println("Tiburon - Usted le quedan vidas: " +vidas_del_buceador);                               
                if(vidas_del_buceador<0){
                    try{
                        System.exit(0);
                    }catch (Exception ex){
                        
                    }
                    
                }
            }
        }
        for(Pirañas_con_hilo mostrar:getPiraña()){
            if(mostrar.getCrear_animales().getTranslateX()<55){
                acumulador_pirañas++;
                if(acumulador_pirañas>3){
                    acumulador_pirañas=0;
                    vidas_del_buceador--;

                    System.out.println("Piraña - Usted le quedan vidas: " +vidas_del_buceador);                               
                    if(vidas_del_buceador<0){
                        try{
                            System.exit(0);
                        }catch (Exception ex){

                        }
                    }
                }
            }
        }
        for(Tiburon_negro_con_hilo mostrar:getTiburon_negro()){
            if(mostrar.getCrear_animales().getTranslateX()<55){
                vidas_del_buceador--;

                System.out.println("Tiburon negro - Usted le quedan vidas: " +vidas_del_buceador);                               
                if(vidas_del_buceador<0){
                    try{
                        System.exit(0);
                    }catch (Exception ex){
                        
                    }
                }
            }
        }
    } 

    public ArrayList <Tiburon_con_hilo> getTiburon() {
        return tiburon;
    }

    public void setTiburon(ArrayList <Tiburon_con_hilo> tiburon) {
        this.tiburon = tiburon;
    }

    public ArrayList <Pirañas_con_hilo> getPiraña() {
        return piraña;
    }

    public void setPiraña(ArrayList <Pirañas_con_hilo> piraña) {
        this.piraña = piraña;
    }

    public ArrayList <Tiburon_negro_con_hilo> getTiburon_negro() {
        return tiburon_negro;
    }

    public void setTiburon_negro(ArrayList <Tiburon_negro_con_hilo> tiburon_negro) {
        this.tiburon_negro = tiburon_negro;
    }

    public int getVidas_del_buceador() {
        return vidas_del_buceador;
    }

    public void setVidas_del_buceador(int vidas_del_buceador) {
        this.vidas_del_buceador = vidas_del_buceador;
    }
}
