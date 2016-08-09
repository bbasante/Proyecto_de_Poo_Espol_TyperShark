/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 *
 * @author basantes
 */
public class Tiburones {

    private Image Tiburon_image = new Image("Tiburon.gif");
    private ImageView Tiburon_imagen= new ImageView(Tiburon_image);
    private Timeline timeline = new Timeline();
    private Random rnd = new Random();    
    private Label etiquetaTextoImagen;
  
    public Tiburones() {
        int posicion = (int) (rnd.nextDouble()*450);
        timeline.setAutoReverse(true);
        timeline.setCycleCount(timeline.INDEFINITE);
                
        etiquetaTextoImagen = new Label("texto");
        etiquetaTextoImagen.setTextFill(Color.BLACK);
        etiquetaTextoImagen.setFont(Font.font(null, FontWeight.BOLD, 20));
        etiquetaTextoImagen.setTextAlignment(TextAlignment.CENTER);
        etiquetaTextoImagen.setContentDisplay(ContentDisplay.CENTER);
        etiquetaTextoImagen.setGraphicTextGap(1);
        etiquetaTextoImagen.setGraphic(Tiburon_imagen);
        
        KeyFrame f1 = new KeyFrame(Duration.ZERO, new KeyValue(etiquetaTextoImagen.translateXProperty(),650));
        KeyFrame f2 = new KeyFrame(new Duration(10000), new KeyValue(etiquetaTextoImagen.translateXProperty(),0));
        KeyFrame f3 = new KeyFrame(Duration.ZERO, new KeyValue(etiquetaTextoImagen.translateYProperty(),posicion));
        KeyFrame f4 = new KeyFrame(new Duration(10000), new KeyValue(etiquetaTextoImagen.translateYProperty(),posicion));
       
        timeline.getKeyFrames().addAll(f1,f2,f3,f4);
        timeline.play();
    }

    public Label getEtiquetaTextoImagen() {
        return etiquetaTextoImagen;
    }

    
}
