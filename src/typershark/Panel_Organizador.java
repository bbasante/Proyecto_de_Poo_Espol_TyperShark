/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author basantes
 */
public class Panel_Organizador {
    
    private BorderPane _BorderPane = new BorderPane();
    private HBox _HBox = new HBox();
    private Button button = new Button("Jugar");
    public Panel_Organizador(){
    
    
    _HBox.setAlignment(Pos.CENTER);
    _HBox.getChildren().add(button);
    _BorderPane.setBottom(_HBox);
    _BorderPane.setStyle("-fx-background-image: url('fondo_de_pantalla.jpg'); "
           + "-fx-background-position: center center; "
           + "-fx-background-repeat: stretch;"
           +"-fx-background-color: blue;");
    button.setOnAction((EventHandler<ActionEvent>) new CLickHandler_Jugar());
    }

    public BorderPane getBorderPane() {
        return _BorderPane;
    }

    public void setBorderPane(BorderPane _BorderPane) {
        this._BorderPane = _BorderPane;

    }

    private class CLickHandler_Jugar implements EventHandler<ActionEvent>{

        public void handle(ActionEvent event) {
            System.exit(0);
            
        }

    }
    
    
}
