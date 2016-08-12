/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Platform;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author basantes
 */
public class Validacion_de_animales {

    private Crear_animales crear_animales;
    
    private String palabra[] = new String[20];
    private int avanza=0;
    private Palabras_y_Caracteres palabra_nueva;
    private int tiempo=100;
    private int vidas=3;
    private Random rnd = new Random(); 
    private int posicionX=1200;
    private int posicionY= (int) (rnd.nextDouble()*400);
    private int randomInteger=ThreadLocalRandom.current().nextInt(2, 3 + 1);
    private int acum_random=1;
    
    public Validacion_de_animales(Crear_animales crear_animales, Palabras_y_Caracteres palabra_nueva) {
        this.crear_animales=crear_animales;
        this.palabra_nueva=palabra_nueva;
    }
    public Crear_animales avanza_pierde_vida (){
            while(posicionX>50){
            crear_animales.getEtiquetaTextoImagen().setTranslateX(posicionX);
            crear_animales.getEtiquetaTextoImagen().setTranslateY(posicionY);
            posicionX=posicionX-1;
            if(posicionX<51){
                System.out.println("Usted Pierde una vida");
                posicionX=1200;
                Random rnd = new Random(); 
                this.posicionY= (int) (rnd.nextDouble()*400);               
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                    crear_animales.getEtiquetaTextoImagen().setText(palabra_nueva.obtener_una_palabra());
                    }
                });
                }
            try{
                Thread.sleep(getTiempo());
            }catch(InterruptedException ex){}
        }
        return crear_animales;
}
    
public Crear_animales palabra_completada (Crear_animales crear_animales, Palabras_y_Caracteres palabra_nueva, KeyEvent event){
        String word = crear_animales.getEtiquetaTextoImagen().getText();
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
                    crear_animales.getEtiquetaTextoImagen().setTranslateY(posicionY);
                    this.posicionX=1200;
                    crear_animales.getEtiquetaTextoImagen().setTranslateX(posicionX);
                    crear_animales.getEtiquetaTextoImagen().setText(palabra_nueva.obtener_una_palabra());
                } 
            }
        return crear_animales;
}

public Crear_animales avanza_pierde_vida_tiburon_negro (){
            while(posicionX>50){
                crear_animales.getEtiquetaTextoImagen().setTranslateX(posicionX);
                crear_animales.getEtiquetaTextoImagen().setTranslateY(posicionY);
                posicionX=posicionX-1;
                if(posicionX<51){
                    System.out.println("Usted Pierde una vida");
                    posicionX=1200;
                    Random rnd = new Random(); 
                    this.posicionY= (int) (rnd.nextDouble()*300);               
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                        crear_animales.getEtiquetaTextoImagen().setText(palabra_nueva.obtener_una_palabra());
                        }
                    });
                    }
                try{
                    Thread.sleep(getTiempo());
                }catch(InterruptedException ex){}
            }
        return crear_animales;
}
public Crear_animales palabra_completada_tiburon_negro(Crear_animales crear_animales, Palabras_y_Caracteres palabra_nueva, KeyEvent event){
        String word = crear_animales.getEtiquetaTextoImagen().getText();
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
                    
                    if(randomInteger>acum_random){
                        crear_animales.getEtiquetaTextoImagen().setText(palabra_nueva.obtener_una_palabra());
                        
                    }else{
                        this.posicionY= (int) (rnd.nextDouble()*300);
                        crear_animales.getEtiquetaTextoImagen().setTranslateY(posicionY);
                        this.posicionX=1200;
                        crear_animales.getEtiquetaTextoImagen().setTranslateX(posicionX);
                        crear_animales.getEtiquetaTextoImagen().setText(palabra_nueva.obtener_una_palabra());
                        acum_random=0;
                        randomInteger=ThreadLocalRandom.current().nextInt(2, 3 + 1);
                    }
                    acum_random++;
                } 
            }
        return crear_animales;
}
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
}
