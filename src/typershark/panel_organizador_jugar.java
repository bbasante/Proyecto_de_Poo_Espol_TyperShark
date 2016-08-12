/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.FileNotFoundException;
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
    private Tiburones tiburones,tiburones1,tiburones2,tiburones3,tiburones4,tiburones5 ;
    private Buceador_con_hilo buceador_con_hilo = new Buceador_con_hilo();
    private Tiburon_con_hilo tiburon_con_hilo,tiburon_con_hilo1,tiburon_con_hilo2,tiburon_con_hilo3,tiburon_con_hilo4,tiburon_con_hilo5;
    private TextField textField = new TextField();
    
    public panel_organizador_jugar() throws FileNotFoundException {
        Thread thread_bucedor_con_hilo= new Thread(buceador_con_hilo);
        thread_bucedor_con_hilo.start();
        cantidad_de_tiburones ();
        textField.setMaxSize(700, 500);
        imagenView.setFitHeight(500);
        imagenView.setFitWidth(700);
        AnchorPane.getChildren().addAll(textField,imagenView,tiburon_con_hilo.getTiburones().getCrear_animales().getEtiquetaTextoImagen()  ,buceador_con_hilo.getEtiquetaTextoImagen(), tiburones1.getCrear_animales().getEtiquetaTextoImagen(), 
                 tiburon_con_hilo2.getTiburones().getCrear_animales().getEtiquetaTextoImagen(), tiburon_con_hilo3.getTiburones().getCrear_animales().getEtiquetaTextoImagen(),
                 tiburon_con_hilo4.getTiburones().getCrear_animales().getEtiquetaTextoImagen(), tiburon_con_hilo5.getTiburones().getCrear_animales().getEtiquetaTextoImagen());    
        AnchorPane.getChildren().get(0).setOnKeyPressed(new KeyPressed());
    }

    public AnchorPane getAnchorPane() {
        return AnchorPane;
    }  

    private class KeyPressed implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            
            tiburon_con_hilo.palabra_completada(event); 
            tiburon_con_hilo1.palabra_completada(event);
            tiburon_con_hilo2.palabra_completada(event);
            tiburon_con_hilo3.palabra_completada(event);
            tiburon_con_hilo4.palabra_completada(event);
            tiburon_con_hilo5.palabra_completada(event);
            
        }
    }
    public void cantidad_de_tiburones () throws FileNotFoundException{
        tiburones  = new Tiburones(); tiburones1 = new Tiburones(); tiburones2 = new Tiburones();
        tiburones3 = new Tiburones(); tiburones4 = new Tiburones(); tiburones5 = new Tiburones();

        tiburon_con_hilo = new Tiburon_con_hilo(tiburones); tiburon_con_hilo1 = new Tiburon_con_hilo(tiburones1);
        tiburon_con_hilo2 = new Tiburon_con_hilo(tiburones2); tiburon_con_hilo3 = new Tiburon_con_hilo(tiburones3);
        tiburon_con_hilo4 = new Tiburon_con_hilo(tiburones4); tiburon_con_hilo5 = new Tiburon_con_hilo(tiburones5);
        
        Thread thread_tiburo_con_hilo= new Thread(tiburon_con_hilo);
        thread_tiburo_con_hilo.start();
        Thread thread_tiburo_con_hilo1= new Thread(tiburon_con_hilo1);
        thread_tiburo_con_hilo1.start();
        Thread thread_tiburo_con_hilo2= new Thread(tiburon_con_hilo2);
        thread_tiburo_con_hilo2.start();
        Thread thread_tiburo_con_hilo3= new Thread(tiburon_con_hilo3);
        thread_tiburo_con_hilo3.start();
        Thread thread_tiburo_con_hilo4= new Thread(tiburon_con_hilo4);
        thread_tiburo_con_hilo4.start();
        Thread thread_tiburo_con_hilo5= new Thread(tiburon_con_hilo5);
        thread_tiburo_con_hilo5.start();
    }
}
