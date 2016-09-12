/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typerShark;

import helpclases.Const;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author User
 */
public class PaneOrganizer {
    Pane root;
    Buceador buceador;
    Mar mar;
    public PaneOrganizer() throws InterruptedException{     
        root = new Pane();
         root.setStyle("-fx-background-image: url('" + Const.RIMGFONDO + "'); "
           + "-fx-background-position: center center; "
           + "-fx-background-repeat: stretch;");       
        mar = new Mar(0,"jorge"); 
        mar.addInPanel(root);
        buceador = mar.getBuceador();   
    }

    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }

    public void listenerKey(Scene scene){
        scene.setOnKeyPressed(new ControlIn());
    }
    
    /*cada vez que tipeo una palabra verifico si es enter si los es y hay puntos suficiente mato 
    a todos los animales 
    si no es enter entonces envio esa letra a matar animal para que se encargue de buscar cuales empiezan con la misma
    y proceda a eliminarla de la palabra de una animal, hasta que alguno quede sin mas letras, ver con mas detalle el metodo matarAnimal */
     private class ControlIn implements EventHandler<KeyEvent> {

         @Override
            public void handle(KeyEvent event) {               
                if(event.getCode().equals(KeyCode.ENTER)) {
                    if(buceador.getPuntaje()> Const.PUNTOSNECESARIOS){
                        mar.MatarTodos();
                        buceador.setPuntaje(buceador.getPuntaje()-Const.PUNTOSNECESARIOS);
                    }
                }
                else{
                    mar.MatarAnimal(event.getText());
                }
            }  
    }   
}
