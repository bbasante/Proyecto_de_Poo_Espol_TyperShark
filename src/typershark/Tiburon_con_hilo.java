/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author basantes
 */
public class Tiburon_con_hilo extends Thread {

     private Crear_animales crear_animales;
     Random rnd = new Random(); 
     private int posicion ;
     private int numero;
     private panel_organizador_jugar panel_organizador_jugar;
    public Tiburon_con_hilo(){
        posicion= (int) (rnd.nextDouble()*350);
        numero=550;
        crear_animales=new Crear_animales("Tiburon.gif");
    }
    public void run(){
        while(true){
            getCrear_animales().setTranslateX(numero);
            getCrear_animales().setTranslateY(posicion);
            numero--;
            if(numero<50){
//                panel_organizador_jugar = new panel_organizador_jugar();
//                panel_organizador_jugar.getTiburon_con_hilo_de_panel_organizador_jugar().stop();
//                panel_organizador_jugar.getTiburon_con_hilo_de_panel_organizador_jugar().getCrear_animales().setVisible(false);
//                
                numero=550;
            }
            try{
                sleep(10);
            }catch(InterruptedException ex){}
        }
    }
    public Label getCrear_animales() {
        return crear_animales.getEtiquetaTextoImagen();
    }
   public Tiburon_con_hilo getTiburon_con_hilo(){
       return panel_organizador_jugar.getTiburon_con_hilo_de_panel_organizador_jugar();
   }

}
