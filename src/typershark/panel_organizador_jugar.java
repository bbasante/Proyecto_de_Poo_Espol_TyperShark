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
    private Buceador_con_hilo buceador_con_hilo = new Buceador_con_hilo();
    private Tiburon_con_hilo tiburon_con_hilo = new Tiburon_con_hilo();
    private TextField textField = new TextField();
    private String palabra[] = new String[20];
    private int avanza=0;
    
    public panel_organizador_jugar() {
        buceador_con_hilo.start();
        tiburon_con_hilo.start();
        textField.setMaxSize(700, 500);
        imagenView.setFitHeight(500);
        imagenView.setFitWidth(700);
        AnchorPane.getChildren().addAll(textField,imagenView,tiburon_con_hilo.getCrear_animales(),buceador_con_hilo.getEtiquetaTextoImagen());
        double posiciones = tiburon_con_hilo.getCrear_animales().getTranslateX();
        if(posiciones<50){
                System.out.println("Usted Pierde una vida");
            }     
        AnchorPane.getChildren().get(0).setOnKeyPressed(new KeyPressed());
    }

    public AnchorPane getAnchorPane() {
        return AnchorPane;
    }

    public Tiburon_con_hilo getTiburon_con_hilo_de_panel_organizador_jugar() {
        return tiburon_con_hilo;
    }
    public Tiburon_con_hilo getTiburon_con_hilo_crear_tiburon() {
        return tiburon_con_hilo= new Tiburon_con_hilo();
    }

    private class KeyPressed implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            String word = tiburon_con_hilo.getCrear_animales().getText();          
            System.out.println(event.getText());  
            
            if(event.getText().indexOf(word.charAt(avanza),0)!=-1){
                palabra[avanza]=event.getText();
                avanza++;
                System.out.println("Entro");
                if(avanza==word.length()){
                    avanza=0;
                    String palabra[] = new String[20];
                    System.out.println("Difito la palabra correcta");
                    
                    tiburon_con_hilo.getCrear_animales().setVisible(false);
                    tiburon_con_hilo.stop();
                    
                    tiburon_con_hilo = new Tiburon_con_hilo();
                    tiburon_con_hilo.start();
                    AnchorPane.getChildren().set(2,tiburon_con_hilo.getCrear_animales());
                    
                }
                
            }   
        }
    }
}
