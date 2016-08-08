/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
/**
 *
 * @author basantes
 */
public class panel_organizador_jugar {
    
    private AnchorPane AnchorPane = new AnchorPane();
    private Image image = new Image("fondo_de_mar.gif");
    private ImageView imagenView= new ImageView(image);
    private Timeline timeline = new Timeline();
    private Buceador buceador = new Buceador();
    
    public panel_organizador_jugar() {
        imagenView.setFitHeight(500);
        imagenView.setFitWidth(700);
        AnchorPane.getChildren().addAll(imagenView,buceador.getBuceador_imagen());
    }

    public AnchorPane getAnchorPane() {
        return AnchorPane;
    }
}
