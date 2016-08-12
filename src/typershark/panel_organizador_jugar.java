/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.util.Random;
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
    private Tiburones tiburones = new Tiburones();
    private Tiburones tiburones1 = new Tiburones();
    private Buceador_con_hilo buceador_con_hilo = new Buceador_con_hilo();
    private Tiburon_con_hilo tiburon_con_hilo = new Tiburon_con_hilo(tiburones);
    private Tiburon_con_hilo tiburon_con_hilo1 = new Tiburon_con_hilo(tiburones1);
    private TextField textField = new TextField();
    private String palabra[] = new String[20];
    private int avanza=0;
    
    public panel_organizador_jugar() {
        Thread thread_buceador_con_hilo = new Thread(buceador_con_hilo);
        thread_buceador_con_hilo.start();
        Thread thread_tiburo_con_hilo= new Thread(tiburon_con_hilo);
        thread_tiburo_con_hilo.start();
        Thread thread_tiburo_con_hilo1= new Thread(tiburon_con_hilo1);
        thread_tiburo_con_hilo1.start();
        textField.setMaxSize(700, 500);
        imagenView.setFitHeight(500);
        imagenView.setFitWidth(700);
        AnchorPane.getChildren().addAll(textField,imagenView,tiburon_con_hilo.getTiburones().getCrear_animales().getEtiquetaTextoImagen()  ,buceador_con_hilo.getEtiquetaTextoImagen(), tiburones1.getCrear_animales().getEtiquetaTextoImagen());    
        AnchorPane.getChildren().get(0).setOnKeyPressed(new KeyPressed());
    }

    public AnchorPane getAnchorPane() {
        return AnchorPane;
    }  

    private class KeyPressed implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            tiburon_con_hilo.palabra_completada(event); 
            tiburon_con_hilo1.palabra_completada(event);
        }
    }
}
