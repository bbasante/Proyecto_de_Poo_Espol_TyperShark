/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.FileNotFoundException;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author basantes
 */
public class Tiburon_negro_con_hilo implements Runnable{

    private Palabras_y_Caracteres palabra_nueva = new Palabras_y_Caracteres("palabras.txt");
    private Crear_animales crear_animales;
    private Validacion_de_animales validacion_de_animales;
    
    public Tiburon_negro_con_hilo() throws FileNotFoundException {
        crear_animales=new Crear_animales("Tiburon_negro.gif"); 
        validacion_de_animales=new Validacion_de_animales(crear_animales,palabra_nueva);
    }
    public void run(){
        this.setCrear_animales(validacion_de_animales.avanza_pierde_vida_tiburon_negro());
        }
        public void palabra_completada (KeyEvent event){ 
            this.setCrear_animales(validacion_de_animales.palabra_completada_tiburon_negro(crear_animales, palabra_nueva, event));
    }
    public Label getCrear_animales() {
        return crear_animales.getEtiquetaTextoImagen();
    }
    
    public void setCrear_animales(Crear_animales crear_animales){
        this.crear_animales=crear_animales;
    } 

    public Validacion_de_animales getValidacion_de_animales() {
        return validacion_de_animales;
    }

    public void setValidacion_de_animales(Validacion_de_animales validacion_de_animales) {
        this.validacion_de_animales = validacion_de_animales;
    }
}
