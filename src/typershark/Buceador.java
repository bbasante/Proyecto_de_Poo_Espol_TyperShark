/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author basantes
 */
public class Buceador {
    
    private Image buceador_image = new Image("buceador.gif");
    private ImageView buceador_imagen= new ImageView(buceador_image);
    private Timeline timeline = new Timeline();
    
    public Buceador(){
        timeline.setAutoReverse(true);
        timeline.setCycleCount(timeline.INDEFINITE);
        KeyFrame f1 = new KeyFrame(Duration.ZERO, new KeyValue(buceador_imagen.translateYProperty(),0));
        KeyFrame f2 = new KeyFrame(new Duration(10000), new KeyValue(buceador_imagen.translateYProperty(),450));
        timeline.getKeyFrames().addAll(f1,f2);
        timeline.play();
    }
    
    public ImageView getBuceador_imagen() {
        return buceador_imagen;
    }
}
