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
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
/**
 *
 * @author basantes
 */
public class panel_organizador_jugar {
    private AnchorPane AnchorPane = new AnchorPane();
    private Image image = new Image("fondo_de_mar.gif"),buceador_image = new Image("buceador.gif");;
    private ImageView imagenView= new ImageView(image), buceador_imagen= new ImageView(buceador_image);;
    private Timeline timeline = new Timeline();
    public panel_organizador_jugar() {
        //AnchorPane.setStyle("-fx-background-image: url('fondo_del_mar.gif'); "+ "-fx-background-position: center center; "+ "-fx-background-repeat: stretch;"+"-fx-background-color: blue;");
        imagenView.setFitHeight(500);
        imagenView.setFitWidth(700);
        timeline.setAutoReverse(true);
        timeline.setCycleCount(timeline.INDEFINITE);
        KeyFrame f1 = new KeyFrame(Duration.ZERO, new KeyValue(buceador_imagen.translateYProperty(),0));
        KeyFrame f2 = new KeyFrame(new Duration(10000), new KeyValue(buceador_imagen.translateYProperty(),450));
        timeline.getKeyFrames().addAll(f1,f2);
        timeline.play();
        AnchorPane.getChildren().addAll(imagenView,buceador_imagen);
    }

    public AnchorPane getAnchorPane() {
        return AnchorPane;
    }

    public void setAnchorPane(AnchorPane AnchorPane) {
        this.AnchorPane = AnchorPane;
    }
    
    
}
