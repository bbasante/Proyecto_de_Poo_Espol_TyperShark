/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.FileNotFoundException;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 *
 * @author basantes
 */
public class Crear_animales {
       
    
    private Palabras_y_Caracteres palabras=new Palabras_y_Caracteres("palabras.txt");
    private String pal=palabras.getPalabra();
    private Label etiquetaTextoImagen = new Label(pal);
    public Crear_animales(String animal) throws FileNotFoundException{
        
        Image Tipo_de_animal= new Image(animal);
        ImageView animal_seleccionado= new ImageView(Tipo_de_animal);
        
        
        etiquetaTextoImagen.setTextFill(Color.BLACK);
        etiquetaTextoImagen.setFont(Font.font(null, FontWeight.BOLD, 20));
        etiquetaTextoImagen.setTextAlignment(TextAlignment.CENTER);
        etiquetaTextoImagen.setContentDisplay(ContentDisplay.CENTER);
        etiquetaTextoImagen.setGraphicTextGap(1);
        etiquetaTextoImagen.setGraphic(animal_seleccionado);
    }

    public Label getEtiquetaTextoImagen() {
        return etiquetaTextoImagen;
    }

    public String getPal() {
        return pal;
    }

    public void setPal(String pal) {
        this.pal = pal;
    }
}
