/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;
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
    private ImageView imagen= new ImageView(image);
    public panel_organizador_jugar() {
        //AnchorPane.setStyle("-fx-background-image: url('fondo_del_mar.gif'); "+ "-fx-background-position: center center; "+ "-fx-background-repeat: stretch;"+"-fx-background-color: blue;");
        imagen.setFitHeight(500);
        imagen.setFitWidth(700);
        AnchorPane.getChildren().addAll(imagen);
    }

    public AnchorPane getAnchorPane() {
        return AnchorPane;
    }

    public void setAnchorPane(AnchorPane AnchorPane) {
        this.AnchorPane = AnchorPane;
    }
    
    
}
