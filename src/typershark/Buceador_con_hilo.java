/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

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
private int vidas =3;
        
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
                Thread.sleep(500);
            }catch(InterruptedException ex){}
        }
    }

    public Label getEtiquetaTextoImagen() {
        return etiquetaTextoImagen;
    }
    public void buceador_tiburon (int posicionX){
        if(posicionX<51){
                    Platform.runLater(new Runnable() {

                            @Override
                            public void run() {
                                vidas--;
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Usted Pierde una vida");
                                alert.setHeaderText(null);
                                alert.setContentText("Usted le quedan=" +vidas+ "vidas");
                                alert.initStyle(StageStyle.UTILITY);
                                alert.showAndWait();
                                if(vidas<0){
                                    System.exit(0);
                                }
                            }
                        });
            }
    }
}
