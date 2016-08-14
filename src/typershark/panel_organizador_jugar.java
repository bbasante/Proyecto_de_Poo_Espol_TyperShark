/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Buceador_con_hilo buceador_con_hilo;
    private Tiburon_con_hilo tiburon_con_hilo,tiburon_con_hilo1,tiburon_con_hilo2,tiburon_con_hilo3,tiburon_con_hilo4,tiburon_con_hilo5;
    private Pirañas_con_hilo piraña_con_hilo,piraña_con_hilo1;
    private Tiburon_negro_con_hilo tiburon_negro_con_hilo,tiburon_negro_con_hilo1;
    private TextField textField = new TextField();
    
    private ArrayList <Tiburon_con_hilo> tiburon = new ArrayList <Tiburon_con_hilo>();
    private ArrayList <Pirañas_con_hilo> piraña = new ArrayList <Pirañas_con_hilo>();
    private ArrayList <Tiburon_negro_con_hilo> tiburon_negro = new ArrayList <Tiburon_negro_con_hilo>();
    private Vidas_del_jugador vidas_del_jugador;
    
    public panel_organizador_jugar() throws FileNotFoundException {
        cantidad_de_tiburones ();
        cantidad_de_pirañas();
        cantidad_de_tiburones_negros();
        vidas_del_jugador= new Vidas_del_jugador(tiburon,piraña,tiburon_negro);
        buceador_con_hilo= new Buceador_con_hilo(vidas_del_jugador); 
        Thread thread_bucedor_con_hilo= new Thread(buceador_con_hilo);
        thread_bucedor_con_hilo.start();
        
        textField.setMaxSize(1200, 700);
        imagenView.setFitHeight(700);
        imagenView.setFitWidth(1250);
        AnchorPane.getChildren().addAll(textField,imagenView,tiburon_con_hilo.getCrear_animales(),tiburon_con_hilo1.getCrear_animales(),buceador_con_hilo.getEtiquetaTextoImagen(),piraña_con_hilo.getCrear_animales(),piraña_con_hilo1.getCrear_animales(),tiburon_negro_con_hilo.getCrear_animales(),tiburon_negro_con_hilo1.getCrear_animales()); 
        AnchorPane.getChildren().get(0).setOnKeyPressed(new KeyPressed());
        
    }

    public AnchorPane getAnchorPane() {
        return AnchorPane;
    }  

    private class KeyPressed implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            
            tiburon_con_hilo.palabra_completada(event); 
            tiburon_con_hilo1.palabra_completada(event);
            
            piraña_con_hilo.palabra_completada(event);
            piraña_con_hilo1.palabra_completada(event);
            
            
            tiburon_negro_con_hilo.palabra_completada(event);
            tiburon_negro_con_hilo1.palabra_completada(event);
//            tiburon_con_hilo2.palabra_completada(event);
//            tiburon_con_hilo3.palabra_completada(event);
//            tiburon_con_hilo4.palabra_completada(event);
//            tiburon_con_hilo5.palabra_completada(event);   
        }
    }
    public void cantidad_de_tiburones () throws FileNotFoundException{
        
        tiburon_con_hilo = new Tiburon_con_hilo();
        tiburon_con_hilo1 = new Tiburon_con_hilo();
        
        tiburon.add(tiburon_con_hilo);
        tiburon.add(tiburon_con_hilo1);
        
        
        
        
        
        Thread thread_tiburo_con_hilo= new Thread(tiburon_con_hilo);
        thread_tiburo_con_hilo.start();
        Thread thread_tiburo_con_hilo1= new Thread(tiburon_con_hilo1);
        thread_tiburo_con_hilo1.start();
//        Thread thread_tiburo_con_hilo2= new Thread(tiburon_con_hilo2);
//        thread_tiburo_con_hilo2.start();
//        Thread thread_tiburo_con_hilo3= new Thread(tiburon_con_hilo3);
//        thread_tiburo_con_hilo3.start();
//        Thread thread_tiburo_con_hilo4= new Thread(tiburon_con_hilo4);
//        thread_tiburo_con_hilo4.start();
//        Thread thread_tiburo_con_hilo5= new Thread(tiburon_con_hilo5);
//        thread_tiburo_con_hilo5.start();
    }
    public void cantidad_de_pirañas () throws FileNotFoundException{
        piraña_con_hilo=new Pirañas_con_hilo();
        piraña_con_hilo1=new Pirañas_con_hilo();

        piraña.add(piraña_con_hilo);
        piraña.add(piraña_con_hilo1);
        
        Thread thread_piraña_con_hilo= new Thread(piraña_con_hilo);
        thread_piraña_con_hilo.start();
        Thread thread_piraña_con_hilo1= new Thread(piraña_con_hilo1);
        thread_piraña_con_hilo1.start();
    }
    public void cantidad_de_tiburones_negros () throws FileNotFoundException{
        tiburon_negro_con_hilo=new Tiburon_negro_con_hilo();
        tiburon_negro_con_hilo1=new Tiburon_negro_con_hilo();
        
        tiburon_negro.add(tiburon_negro_con_hilo);
        tiburon_negro.add(tiburon_negro_con_hilo1);
       
        Thread thread_tiburon_negro_con_hilo= new Thread(tiburon_negro_con_hilo);
        thread_tiburon_negro_con_hilo.start();
        Thread thread_tiburon_negro_con_hilo1= new Thread(tiburon_negro_con_hilo1);
        thread_tiburon_negro_con_hilo1.start();
    }
}
