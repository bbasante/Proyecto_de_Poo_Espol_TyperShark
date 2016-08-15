/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;


import static com.sun.glass.ui.Cursor.setVisible;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author basantes
 */
public class Panel_Organizador{
    
    private AnchorPane _AnchorPane = new AnchorPane();
    private Button button, easy, normal, very_hard, ludicrous;
    
    private Image image = new Image("fondo_de_mar.gif");
    private ImageView imagenView= new ImageView(image);
    private Buceador_con_hilo buceador_con_hilo;
    private Animales tiburon_con_hilo,tiburon_con_hilo1,tiburon_con_hilo2,tiburon_con_hilo3,tiburon_con_hilo4,tiburon_con_hilo5;
    private Animales piraña_con_hilo,piraña_con_hilo1;
    private Animales tiburon_negro_con_hilo,tiburon_negro_con_hilo1;
    private TextField textField = new TextField();
    
    private ArrayList <Animales> tiburon = new ArrayList <Animales>();
    private ArrayList <Animales> piraña = new ArrayList <Animales>();
    private ArrayList <Animales> tiburon_negro = new ArrayList <Animales>();
    
    public Panel_Organizador(){  
    button=Boton(75, 80, 520, 370, "Ancla.jpg");
    _AnchorPane.setStyle("-fx-background-image: url('fondo_de_pantalla.jpg'); "+ "-fx-background-position: center center; " +"-fx-background-repeat: stretch;"+ "-fx-background-color: blue;");
    _AnchorPane.getChildren().addAll(button);
    button.setOnAction((EventHandler<ActionEvent>) new CLickHandler_Jugar());
    }

    public AnchorPane getAnchorPane() {
        return _AnchorPane;
    }

    private class CLickHandler_Jugar implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event) {
            easy=Boton(100,100,400,410,"Easy.jpg");normal=Boton(100,100,530,410,"Normal.jpg");           
            very_hard=Boton(110,100,640,410,"Very_Hard.jpg");ludicrous=Boton(100,100,780,410,"Ludicrous.jpg");
            _AnchorPane.getChildren().setAll(easy,normal,very_hard,ludicrous);
            _AnchorPane.setStyle("-fx-background-image: url('Dificultad.jpg'); "+ "-fx-background-position: center center; "+ "-fx-background-repeat: stretch;"+"-fx-background-color: blue;");
            easy.setOnAction((EventHandler<ActionEvent>) new ClickHandler());
        }
    }
    private class ClickHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event){
            try {
                cantidad_de_tiburones ();
            } catch (FileNotFoundException ex) {}
            try {
                cantidad_de_pirañas();
            } catch (FileNotFoundException ex) {}
            try {
                cantidad_de_tiburones_negros();
            } catch (FileNotFoundException ex) {}
    
            try { 
                buceador_con_hilo= new Buceador_con_hilo(tiburon,piraña,tiburon_negro);
            } catch (FileNotFoundException ex) {}
            Thread thread_bucedor_con_hilo= new Thread(buceador_con_hilo);
            thread_bucedor_con_hilo.start();

            textField.setMaxSize(1200, 700);
            imagenView.setFitHeight(700);
            imagenView.setFitWidth(1250);
            
            _AnchorPane.getChildren().setAll(textField,imagenView,tiburon_con_hilo.getCrear_animales_tiburon(),tiburon_con_hilo1.getCrear_animales_tiburon(),buceador_con_hilo.getEtiquetaTextoImagen(),piraña_con_hilo.getCrear_animales_piraña(),piraña_con_hilo1.getCrear_animales_piraña(),tiburon_negro_con_hilo.getCrear_animales_tiburon_negro(),tiburon_negro_con_hilo1.getCrear_animales_tiburon_negro()); 
            _AnchorPane.getChildren().get(0).setOnKeyPressed(new KeyPressed());            
        }
    } 
    
    public Button Boton(int presizeX, int presizeY, int transX, int transY, String imagen){
        Button btn = new Button();
        btn.setPrefSize(presizeX, presizeY);
        btn.setTranslateX(transX);
        btn.setTranslateY(transY);
        btn.setStyle("-fx-background-image: url("+imagen+"); ");
        return btn;
    }
    
    private class KeyPressed implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            
            tiburon_con_hilo.palabra_completada(event,0); 
            tiburon_con_hilo1.palabra_completada(event,0);
            
            piraña_con_hilo.palabra_completada(event,1);
            piraña_con_hilo1.palabra_completada(event,1);
                        
            tiburon_negro_con_hilo.palabra_completada(event,2);
            tiburon_negro_con_hilo1.palabra_completada(event,2);  
        }
    }
    public void cantidad_de_tiburones () throws FileNotFoundException{
        
        tiburon_con_hilo = new Animales(0);
        tiburon_con_hilo1 = new Animales(0);
        
        tiburon.add(tiburon_con_hilo);
        tiburon.add(tiburon_con_hilo1);
        
        Thread thread_tiburo_con_hilo= new Thread(tiburon_con_hilo);
        thread_tiburo_con_hilo.start();
        Thread thread_tiburo_con_hilo1= new Thread(tiburon_con_hilo1);
        thread_tiburo_con_hilo1.start();
    }
    public void cantidad_de_pirañas () throws FileNotFoundException{
        piraña_con_hilo=new Animales(1);
        piraña_con_hilo1=new Animales(1);

        piraña.add(piraña_con_hilo);
        piraña.add(piraña_con_hilo1);
        
        Thread thread_piraña_con_hilo= new Thread(piraña_con_hilo);
        thread_piraña_con_hilo.start();
        Thread thread_piraña_con_hilo1= new Thread(piraña_con_hilo1);
        thread_piraña_con_hilo1.start();
    }
    public void cantidad_de_tiburones_negros () throws FileNotFoundException{
        tiburon_negro_con_hilo=new Animales(2);
        tiburon_negro_con_hilo1=new Animales(2);
        
        tiburon_negro.add(tiburon_negro_con_hilo);
        tiburon_negro.add(tiburon_negro_con_hilo1);
       
        Thread thread_tiburon_negro_con_hilo= new Thread(tiburon_negro_con_hilo);
        thread_tiburon_negro_con_hilo.start();
        Thread thread_tiburon_negro_con_hilo1= new Thread(tiburon_negro_con_hilo1);
        thread_tiburon_negro_con_hilo1.start();
    }
}
