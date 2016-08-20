/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.FileNotFoundException;
import java.util.Random;
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
public class Piraña implements Animal, Runnable{
    private Label piraña;
    private String palabra[] = new String[20];
    private int avanza=0;
    private int tiempo=400;
    private Random rnd = new Random(); 
    private int posicionX=1200;
    private int posicionY= (int) (rnd.nextDouble()*400);
    private int puntaje=0;
    private Palabras Palabras = new Palabras("caracteres.txt");
    public Piraña() throws FileNotFoundException {
        piraña= Animal();  
    }
    
    @Override
    public void avanzar() {
        while(posicionX>50){
            piraña.setTranslateX(posicionX);
            piraña.setTranslateY(posicionY);
            posicionX=posicionX-1;
            if(posicionX<51){
                posicionX=1200;
                posicionY= (int) (rnd.nextDouble()*400);
                
                
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
            String word = piraña.getText();  
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
                    piraña.setTranslateY(posicionY);
                    piraña.setTranslateX(posicionX);
                    piraña.setText(Palabras.obtener());
                } 
            }
}
    public Label Animal() throws FileNotFoundException{
        
        Image Tipo_de_animal= new Image("Piraña.gif");
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

    public Label getPiraña() {
        return piraña;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPiraña(Label piraña) {
        this.piraña = piraña;
    }
}
