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
public class TiburonNegro implements Animal, Runnable{
    
    private Label tiburon_negro;
    private String palabra[] = new String[20];
    private int avanza=0;
    private Palabras Palabras = new Palabras("palabras.txt");;
    private int tiempo=300;
    private Random rnd = new Random(); 
    private int posicionX=1200;
    private int posicionY= (int) (rnd.nextDouble()*400);
    private int randomInteger=ThreadLocalRandom.current().nextInt(2, 3 + 1);
    private int acum_random=1;
    public int puntaje=0;
    public TiburonNegro() throws FileNotFoundException {
        tiburon_negro= Animal();  
    }
    
    @Override
    public void avanzar() {
        while(posicionX>50){
            tiburon_negro.setTranslateX(posicionX);
            tiburon_negro.setTranslateY(posicionY);
            posicionX=posicionX-1;
            if(posicionX<51){
                posicionX=1200;
                posicionY= (int) (rnd.nextDouble()*400);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                    tiburon_negro.setText(Palabras.obtener());
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
            String word = tiburon_negro.getText();  
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
                    if(randomInteger>acum_random){
                        tiburon_negro.setText(Palabras.obtener());
                        }else{
                            posicionY= (int) (rnd.nextDouble()*400);
                            tiburon_negro.setTranslateY(posicionY);
                            this.posicionX=1200;
                            tiburon_negro.setTranslateX(posicionX);
                            tiburon_negro.setText(Palabras.obtener());
                            acum_random=0;
                            randomInteger=ThreadLocalRandom.current().nextInt(2, 3 + 1);
                        }
                        acum_random++;
                    }
                } 
}
    public Label Animal() throws FileNotFoundException{
        
        Image Tipo_de_animal= new Image("Tiburon_negro.gif");
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

    public int getPuntaje() {
        return puntaje;
    }

    public Label getTiburon_negro() {
        return tiburon_negro;
    }

    public void setTiburon_negro(Label tiburon_negro) {
        this.tiburon_negro = tiburon_negro;
    }
}
