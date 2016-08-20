/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author basantes
 */
public class Buceador implements Runnable{
    private Label buceador;
    private int numero=250;
    private int posicionX=1200;

    private ArrayList <Tiburon> tiburon ;
    private ArrayList <Piraña> piraña;
    private ArrayList <TiburonNegro> tiburon_negro ;
    private int vidas_del_buceador =3, acumulador_pirañas=0;
    
    public Buceador() throws FileNotFoundException {
        buceador=Jugador();
    }
    public void actualizar(ArrayList <Tiburon> tiburon, ArrayList <Piraña> piraña,ArrayList <TiburonNegro> tiburon_negro){
        this.tiburon=tiburon;
        this.piraña=piraña;
        this.tiburon_negro=tiburon_negro;
    }
    public void run (){
        while(true){
            buceador.setTranslateX(0);
            buceador.setTranslateY(numero);
            numero++;
            this.Vidas();           
            if(numero==650){
                numero=250;
            }            
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){}
        }
    }
    public void Vidas() {
        for(Tiburon mostrar:getTiburon()){
            if(mostrar.getTiburon().getTranslateX()<70){
                vidas_del_buceador--;
                System.out.println("Tiburon - Usted le quedan vidas: " +vidas_del_buceador);                               
                if(vidas_del_buceador<0){
                    try{
//                        System.exit(0);
                    }catch (Exception ex){
                        
                    }
                    
                }
            }
        }
        for(Piraña mostrar:getPiraña()){
            if(mostrar.getPiraña().getTranslateX()<70){
                acumulador_pirañas++;
                if(acumulador_pirañas>3){
                    acumulador_pirañas=0;
                    vidas_del_buceador--;

                    System.out.println("Piraña - Usted le quedan vidas: " +vidas_del_buceador);                               
                    if(vidas_del_buceador<0){
                        try{
//                            System.exit(0);
                        }catch (Exception ex){

                        }
                    }
                }
            }
        }
        for(TiburonNegro mostrar:getTiburon_negro()){
            if(mostrar.getTiburon_negro().getTranslateX()<70){
                vidas_del_buceador--;

                System.out.println("Tiburon negro - Usted le quedan vidas: " +vidas_del_buceador);                               
                if(vidas_del_buceador<0){
                    try{
//                        System.exit(0);
                    }catch (Exception ex){
                        
                    }
                }
            }
        }
    }
        public Label Jugador() throws FileNotFoundException{
        Image Tipo_de_animal= new Image("buceador.gif");
        ImageView animal_seleccionado= new ImageView(Tipo_de_animal);
        Label etiquetaTextoImagen = new Label();
        etiquetaTextoImagen = new Label();
        etiquetaTextoImagen.setContentDisplay(ContentDisplay.CENTER);
        etiquetaTextoImagen.setGraphicTextGap(1);
        etiquetaTextoImagen.setGraphic(animal_seleccionado);
        return etiquetaTextoImagen;
    }

    public Label getBuceador() {
        return buceador;
    }

    public void setBuceador(Label buceador) {
        this.buceador = buceador;
    }

    public ArrayList <Tiburon> getTiburon() {
        return tiburon;
    }

    public void setTiburon(ArrayList <Tiburon> tiburon) {
        this.tiburon = tiburon;
    }

    public ArrayList <Piraña> getPiraña() {
        return piraña;
    }

    public void setPiraña(ArrayList <Piraña> piraña) {
        this.piraña = piraña;
    }

    public ArrayList <TiburonNegro> getTiburon_negro() {
        return tiburon_negro;
    }

    public void setTiburon_negro(ArrayList <TiburonNegro> tiburon_negro) {
        this.tiburon_negro = tiburon_negro;
    }
}
