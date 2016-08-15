/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author basantes
 */
public class Validacion_de_animales {

    private Label crear_animales;
    
    private String palabra[] = new String[20];
    private int avanza=0;
    private Palabras_y_Caracteres palabra_nueva;
    private int tiempo=100;
    private int vidas=3;
    private Random rnd = new Random(); 
    private int posicionX=1200;
    private int posicionY= (int) (rnd.nextDouble()*400);
    private int posicionY_tiburon_negro=(int) (rnd.nextDouble()*300);
    private int randomInteger=ThreadLocalRandom.current().nextInt(2, 3 + 1);
    private int acum_random=1;
    public int puntaje=0;

    public Validacion_de_animales(Label crear_animales, Palabras_y_Caracteres palabra_nueva) {
        this.crear_animales=crear_animales;
        this.palabra_nueva=palabra_nueva;
    }
    public Label avanza_pierde_vida_tiburon (){
        this.avanzar_animales(0);
        return crear_animales;
}
    
public Label palabra_completada_tiburon (Label crear_animales, Palabras_y_Caracteres palabra_nueva, KeyEvent event){
        this.palabra_completa_animales(event, 19, 0);
        return crear_animales;
}

    public Label avanza_pierde_vida_piraña (){
        this.avanzar_animales(0);
        return crear_animales;
}
    
public Label palabra_completada_piraña (Label crear_animales, Palabras_y_Caracteres palabra_nueva, KeyEvent event){
        this.palabra_completa_animales(event, 19, 0);
        return crear_animales;
}

public Label avanza_pierde_vida_tiburon_negro (){
    this.avanzar_animales(1);
        return crear_animales;
}
public Label palabra_completada_tiburon_negro(Label crear_animales, Palabras_y_Caracteres palabra_nueva, KeyEvent event){
        this.palabra_completa_animales(event, 19, 1);
        return crear_animales;
}
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    public void avanzar_animales (int elegir){
        while(posicionX>50){
            crear_animales.setTranslateX(posicionX);
            if(elegir==0){
                crear_animales.setTranslateY(getPosicionY());
            }else{
                crear_animales.setTranslateY(getPosicionY_tiburon_negro());
            }
            
            posicionX=posicionX-1;
            if(posicionX<51){
//                System.out.println("Usted Pierde una vida");
                posicionX=1200;
                Random rnd = new Random();
                if(elegir == 0){
                    //this.posicionY= (int) (rnd.nextDouble()*400);
                    this.setPosicionY((int) (rnd.nextDouble()*400));
                }else{
                    this.setPosicionY_tiburon_negro((int) (rnd.nextDouble()*300)); 
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                    crear_animales.setText(palabra_nueva.obtener_una_palabra());
                    }
                });
                }
            try{
                
                Thread.sleep(getTiempo());
            }catch(InterruptedException ex){}
        }
    }
    public void palabra_completa_animales (KeyEvent event, int disminuir, int elegir){
        String word = crear_animales.getText();
//        System.out.println(event.getText());  
            
            if(event.getText().indexOf(word.charAt(avanza),0)!=-1){
                palabra[avanza]=event.getText();
                avanza++;
//                System.out.println("Entro");
                
                if(avanza==word.length()){
                    
                    puntaje= puntaje +avanza; 
                    //System.out.println(puntaje_acum);
                    setPuntaje(puntaje);
//                    this.setPuntaje(getPuntaje() + avanza);
//                    System.out.println("Su puntaje es: " +getPuntaje());
                    tiempo=tiempo-disminuir;
//                    System.out.println(tiempo);
                    this.setTiempo(tiempo);
                    if(tiempo<11){
                        tiempo=10;   
                    }
                    avanza=0;
                    String palabra[] = new String[20];
//                    System.out.println("Digito la palabra correcta");
                    Random rnd = new Random(); 
                    if(elegir==0){
                    this.setPosicionY((int) (rnd.nextDouble()*500));
                    crear_animales.setTranslateY(getPosicionY());
                    this.posicionX=1200;
                    crear_animales.setTranslateX(posicionX);
                    crear_animales.setText(palabra_nueva.obtener_una_palabra());
                    }else{
                        if(randomInteger>acum_random){
                        crear_animales.setText(palabra_nueva.obtener_una_palabra());
                        
                        }else{
                            this.setPosicionY_tiburon_negro((int) (rnd.nextDouble()*400)); 
                            crear_animales.setTranslateY(getPosicionY_tiburon_negro());
                            this.posicionX=1200;
                            crear_animales.setTranslateX(posicionX);
                            crear_animales.setText(palabra_nueva.obtener_una_palabra());
                            acum_random=0;
                            randomInteger=ThreadLocalRandom.current().nextInt(2, 3 + 1);
                        }
                        acum_random++;
                    } 
            
                } 
            }
        }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getPosicionY_tiburon_negro() {
        return posicionY_tiburon_negro;
    }

    public void setPosicionY_tiburon_negro(int posicionY_tiburon_negro) {
        this.posicionY_tiburon_negro = posicionY_tiburon_negro;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}