/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author basantes
 */
public class Tiburon_con_hilo implements Runnable {

     private Tiburones tiburones;
     private int posicionX;
     private int posicionY;
     private String palabra[] = new String[20];
     private int avanza=0;
     private Palabras palabra_nueva;
     private int tiempo=100;
     
    public Tiburon_con_hilo(Tiburones tiburones) throws FileNotFoundException{
        this.palabra_nueva = new Palabras();
        this.posicionX=tiburones.getPosicionX();
        this.posicionY=tiburones.getPosicionY();
        this.tiburones=tiburones;
    }
    public void run(){
        while(posicionX>50){
            
            tiburones.getCrear_animales().getEtiquetaTextoImagen().setTranslateX(posicionX);
            tiburones.getCrear_animales().getEtiquetaTextoImagen().setTranslateY(posicionY);
            posicionX=posicionX-1;
            
            if(posicionX<51){
                System.out.println("Usted Pierde una vida");
                posicionX=650;
                Random rnd = new Random(); 
                this.posicionY= (int) (rnd.nextDouble()*400);
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        tiburones.getCrear_animales().getEtiquetaTextoImagen().setText(palabra_nueva.obtener_una_palabra());
                    }
                });
                }
            try{
                Thread.sleep(getTiempo());
            }catch(InterruptedException ex){}
        }
    }
    
    public void palabra_completada (KeyEvent event){
        
        String word = tiburones.getCrear_animales().getEtiquetaTextoImagen().getText();          
            System.out.println(event.getText());  
            
            if(event.getText().indexOf(word.charAt(avanza),0)!=-1){
                palabra[avanza]=event.getText();
                avanza++;
                System.out.println("Entro");
                if(avanza==word.length()){
                    tiempo=tiempo-9;
                    System.out.println(tiempo);
                    this.setTiempo(tiempo);
                    if(tiempo<11){
                        tiempo=10;
                        
                    }
                    avanza=0;
                    String palabra[] = new String[20];
                    System.out.println("Digito la palabra correcta");
                    Random rnd = new Random(); 
                    this.posicionY= (int) (rnd.nextDouble()*400);
                    tiburones.getCrear_animales().getEtiquetaTextoImagen().setTranslateY(posicionY);
                    this.posicionX=600;
                    tiburones.getCrear_animales().getEtiquetaTextoImagen().setTranslateX(posicionX);
                    
                    tiburones.getCrear_animales().getEtiquetaTextoImagen().setText(palabra_nueva.obtener_una_palabra());
                }
                
            }
    }
    public Tiburones getTiburones() {
        return tiburones;
    }

    public void setTiburones(Tiburones tiburones) {
        this.tiburones = tiburones;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getTiempo() {
        return tiempo;
    }
}
