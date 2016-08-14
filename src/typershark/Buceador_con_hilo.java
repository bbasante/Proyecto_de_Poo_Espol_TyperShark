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
private Vidas_del_jugador vidas_del_jugador;

    public Buceador_con_hilo(Vidas_del_jugador vidas_del_jugador) throws FileNotFoundException {
        Image Tipo_de_animal= new Image("buceador.gif");
        ImageView animal_seleccionado= new ImageView(Tipo_de_animal);
        etiquetaTextoImagen = new Label();
        etiquetaTextoImagen.setContentDisplay(ContentDisplay.CENTER);
        etiquetaTextoImagen.setGraphicTextGap(1);
        etiquetaTextoImagen.setGraphic(animal_seleccionado);
        this.vidas_del_jugador=vidas_del_jugador;
    }

    public void run (){
        while(true){
            etiquetaTextoImagen.setTranslateX(0);
            etiquetaTextoImagen.setTranslateY(numero);
            numero++;
            
            vidas_del_jugador.Vidas_perdidas();
            vidas_del_jugador.setTiburon(vidas_del_jugador.getTiburon());
            vidas_del_jugador.setPiraña(vidas_del_jugador.getPiraña());
            vidas_del_jugador.setTiburon_negro(vidas_del_jugador.getTiburon_negro());
            
            if(numero==650){
                numero=649;
            }            
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){}
        }
    }

    public Label getEtiquetaTextoImagen() {
        return etiquetaTextoImagen;
    }

    public Vidas_del_jugador getVidas_del_jugador() {
        return vidas_del_jugador;
    }

    public void setVidas_del_jugador(Vidas_del_jugador vidas_del_jugador) {
        this.vidas_del_jugador = vidas_del_jugador;
    }
}
