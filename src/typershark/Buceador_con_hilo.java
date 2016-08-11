/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

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
public class Buceador_con_hilo extends Thread{
private Label etiquetaTextoImagen;
private int numero=250;

        
    public Buceador_con_hilo() {
        Image Tipo_de_animal= new Image("buceador.gif");
        ImageView animal_seleccionado= new ImageView(Tipo_de_animal);
        etiquetaTextoImagen = new Label();
        etiquetaTextoImagen.setContentDisplay(ContentDisplay.CENTER);
        etiquetaTextoImagen.setGraphicTextGap(1);
        etiquetaTextoImagen.setGraphic(animal_seleccionado);
    }
    public void run (){
        while(true){
            etiquetaTextoImagen.setTranslateX(0);
            etiquetaTextoImagen.setTranslateY(numero);
            numero++;
            if(numero==450){
                numero=449;
            }
            try{
                sleep(500);
            }catch(InterruptedException ex){}
        }
    }

    public Label getEtiquetaTextoImagen() {
        return etiquetaTextoImagen;
    }
    
}
