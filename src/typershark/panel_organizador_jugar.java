/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    private Tiburones tiburon = new Tiburones();
    private Pirañas pirañas = new Pirañas();
    private TextField textField = new TextField();
    private String palabra[] = new String[20];
    private int avanza=0;
    
    public panel_organizador_jugar() {
        textField.setMaxSize(700, 500);
        imagenView.setFitHeight(500);
        imagenView.setFitWidth(700);
        AnchorPane.getChildren().addAll(textField,imagenView,buceador.getBuceador_imagen(),tiburon.getCrear_animales(),pirañas.getCrear_animales());
        double posicion = tiburon.getCrear_animales().getTranslateX();
        if(posicion<50){
                System.out.println("Usted Pierde una vida");
            }
        System.out.println(tiburon.getCrear_animales().getTranslateX());
        AnchorPane.getChildren().get(0).setOnKeyPressed(new KeyPressed());
    }

    public AnchorPane getAnchorPane() {
        return AnchorPane;
    }

    private class KeyPressed implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            String word = tiburon.getCrear_animales().getText();          
            System.out.println(event.getText());  
            
            if(event.getText().indexOf(word.charAt(avanza),0)!=-1){
                palabra[avanza]=event.getText();
                avanza++;
                System.out.println("Entro");
                if(avanza==word.length()){
                    avanza=0;
                    String palabra[] = new String[20];
                    System.out.println("Difito la palabra correcta");
                    tiburon.getCrear_animales().setVisible(false);
                    tiburon = new Tiburones();
                    AnchorPane.getChildren().add(tiburon.getCrear_animales());
                }
                
            }   
        }
    }
}
