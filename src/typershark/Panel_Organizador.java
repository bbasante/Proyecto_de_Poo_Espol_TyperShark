/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author basantes
 */
public class Panel_Organizador {
    
    private AnchorPane _AnchorPane = new AnchorPane(),_dificultad = new AnchorPane();
    private Boton button = new Boton(75, 80, 245, 270, "Ancla.jpg");
    public Panel_Organizador(){    
    _AnchorPane.setStyle("-fx-background-image: url('fondo_de_pantalla.jpg'); "+ "-fx-background-position: center center; " +"-fx-background-repeat: stretch;"+ "-fx-background-color: blue;");
    _AnchorPane.getChildren().addAll(button.getBtn());
    button.getBtn().setOnAction((EventHandler<ActionEvent>) new CLickHandler_Jugar());
    }

    public AnchorPane getAnchorPane() {
        return _AnchorPane;
    }

    public void setAnchorPane(AnchorPane _AnchorPane) {
        this._AnchorPane = _AnchorPane;

    }
    private class CLickHandler_Jugar implements EventHandler<ActionEvent>{

        public void handle(ActionEvent event) {
            panel_organizador_dificultad  panel_organizador_dificultad = new panel_organizador_dificultad();
            Scene scene = new Scene(panel_organizador_dificultad.getAnchorPane(),700, 500);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("TyperShark");        
            stage.show();
        }
    }
}
