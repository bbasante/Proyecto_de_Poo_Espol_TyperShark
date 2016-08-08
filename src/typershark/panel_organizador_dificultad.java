/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author basantes
 */
public class panel_organizador_dificultad {
    
    private AnchorPane AnchorPane = new AnchorPane();
    private Boton easy = new Boton(100,100,110,310,"Easy.jpg");
    private Boton normal = new Boton(100,100,240,310,"Normal.jpg");
    private Boton very_hard = new Boton(110,100,370,310,"Very_Hard.jpg");
    private Boton ludicrous = new Boton(100,100,500,310,"Ludicrous.jpg");
    
    public panel_organizador_dificultad(){       
        AnchorPane.getChildren().addAll(easy.getBtn(),normal.getBtn(),very_hard.getBtn(),ludicrous.getBtn());
        AnchorPane.setStyle("-fx-background-image: url('Dificultad.jpg'); "+ "-fx-background-position: center center; "+ "-fx-background-repeat: stretch;"+"-fx-background-color: blue;");
        easy.getBtn().setOnAction((EventHandler<ActionEvent>) new ClickHandler());
    }

    public AnchorPane getAnchorPane() {
        return AnchorPane;
    }

    public void setAnchorPane(AnchorPane AnchorPane) {
        this.AnchorPane = AnchorPane;
    }

    private class ClickHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            panel_organizador_jugar  panel_organizador_jugar = new panel_organizador_jugar();
            Scene scene = new Scene(panel_organizador_jugar.getAnchorPane(),700, 500);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("TyperShark");        
            stage.show();
        }
    }         
}
