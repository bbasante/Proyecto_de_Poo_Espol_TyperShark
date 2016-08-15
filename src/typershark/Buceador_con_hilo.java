/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.StageStyle;

/**
 *
 * @author basantes
 */
public class Buceador_con_hilo implements Runnable{
private Label etiquetaTextoImagen;
private int numero=250;
private int posicionX=1200;

private ArrayList <Animales> tiburon;
private ArrayList <Animales> piraña;
private ArrayList <Animales> tiburon_negro;
private int vidas_del_buceador =3, acumulador_pirañas=0;

    public Buceador_con_hilo(ArrayList <Animales> tiburon, ArrayList <Animales> piraña,ArrayList <Animales> tiburon_negro) throws FileNotFoundException {
        Image Tipo_de_animal= new Image("buceador.gif");
        ImageView animal_seleccionado= new ImageView(Tipo_de_animal);
        etiquetaTextoImagen = new Label();
        etiquetaTextoImagen.setContentDisplay(ContentDisplay.CENTER);
        etiquetaTextoImagen.setGraphicTextGap(1);
        etiquetaTextoImagen.setGraphic(animal_seleccionado);

        this.tiburon=tiburon;
        this.piraña=piraña;
        this.tiburon_negro=tiburon_negro;
    }

    public void run (){
        while(true){
            etiquetaTextoImagen.setTranslateX(0);
            etiquetaTextoImagen.setTranslateY(numero);
            numero++;
            this.Vidas_perdidas();           
            if(numero==650){
                numero=649;
            }            
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){}
        }
    }
    public void Vidas_perdidas() {
        for(Animales mostrar:getTiburon()){
            if(mostrar.getCrear_animales_tiburon().getTranslateX()<70){
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
        for(Animales mostrar:getPiraña()){
            if(mostrar.getCrear_animales_piraña().getTranslateX()<70){
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
        for(Animales mostrar:getTiburon_negro()){
            if(mostrar.getCrear_animales_tiburon_negro().getTranslateX()<70){
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

    public ArrayList <Animales> getTiburon() {
        return tiburon;
    }

    public void setTiburon(ArrayList <Animales> tiburon) {
        this.tiburon = tiburon;
    }

    public ArrayList <Animales> getPiraña() {
        return piraña;
    }

    public void setPiraña(ArrayList <Animales> piraña) {
        this.piraña = piraña;
    }

    public ArrayList <Animales> getTiburon_negro() {
        return tiburon_negro;
    }

    public void setTiburon_negro(ArrayList <Animales> tiburon_negro) {
        this.tiburon_negro = tiburon_negro;
    }

    public int getVidas_del_buceador() {
        return vidas_del_buceador;
    }

    public void setVidas_del_buceador(int vidas_del_buceador) {
        this.vidas_del_buceador = vidas_del_buceador;
    }

    public Label getEtiquetaTextoImagen() {
        return etiquetaTextoImagen;
    }
}
