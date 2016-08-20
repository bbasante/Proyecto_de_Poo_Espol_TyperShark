/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Platform;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author basantes
 */
public class Tiburon implements Animal, Runnable{

    private Label tiburon;
    private String palabra[] = new String[20];
    private int avanza=0;
    private int tiempo=500;
    private Random rnd = new Random(); 
    private int posicionX=1200;
    private int posicionY= (int) (rnd.nextDouble()*400);
    private int puntaje=0;
    private Palabras Palabras = new Palabras("palabras.txt");
    public Tiburon() throws FileNotFoundException {
        tiburon= Animal();  
    }
    
    @Override
    public void avanzar() {
        while(posicionX>50){
            tiburon.setTranslateX(posicionX);
            tiburon.setTranslateY(posicionY);
            posicionX=posicionX-1;
            if(posicionX<51){
                posicionX=1200;
                posicionY= (int) (rnd.nextDouble()*400);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                    tiburon.setText(Palabras.obtener());
                    }
                });
                
                }
            try{   
                Thread.sleep(tiempo);
            }catch(InterruptedException ex){}
        }
    }
    
    @Override
    public void run() {
        this.avanzar();    
    }
    
    @Override
    public void validacion (KeyEvent event){
            String word = tiburon.getText();  
            if(event.getText().indexOf(word.charAt(avanza),0)!=-1){
                palabra[avanza]=event.getText();
                avanza++;
                if(avanza==word.length()){
                    puntaje= puntaje +avanza; 
                    tiempo=tiempo-10;
                    if(tiempo<11){
                        tiempo=20;   
                    }
                    avanza=0;
                    String palabra[] = new String[20];
                    this.posicionX=1200;
                    posicionY= (int) (rnd.nextDouble()*400);
                    tiburon.setTranslateY(posicionY);
                    tiburon.setTranslateX(posicionX);
                    tiburon.setText(Palabras.obtener());
                } 
            }
}
    public Label Animal() throws FileNotFoundException{
        
        Image Tipo_de_animal= new Image("Tiburon.gif");
        ImageView animal_seleccionado= new ImageView(Tipo_de_animal);
        Label etiquetaTextoImagen = new Label(Palabras.obtener());
        
        etiquetaTextoImagen.setTextFill(Color.BLACK);
        etiquetaTextoImagen.setFont(Font.font(null, FontWeight.BOLD, 20));
        etiquetaTextoImagen.setTextAlignment(TextAlignment.CENTER);
        etiquetaTextoImagen.setContentDisplay(ContentDisplay.CENTER);
        etiquetaTextoImagen.setGraphicTextGap(1);
        etiquetaTextoImagen.setGraphic(animal_seleccionado);
        return etiquetaTextoImagen;
    }

    public Label getTiburon() {
        return tiburon;
    }

    public void setTiburon(Label tiburon) {
        this.tiburon = tiburon;
    }

    public int getPuntaje() {
        return puntaje;
    }

    
}
