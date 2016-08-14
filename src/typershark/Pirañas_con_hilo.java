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
public class Pirañas_con_hilo implements Runnable{

    private Palabras_y_Caracteres palabra_nueva = new Palabras_y_Caracteres("caracteres.txt");
    private Crear_animales crear_animales;
    private Validacion_de_animales validacion_de_animales;

    public Pirañas_con_hilo() throws FileNotFoundException {
        crear_animales = new Crear_animales("Piraña.gif");
        crear_animales.getEtiquetaTextoImagen().setText(palabra_nueva.obtener_una_palabra());
        validacion_de_animales=new Validacion_de_animales(crear_animales,palabra_nueva);
    }
    
    @Override
    public void run() {
        this.setCrear_animales(validacion_de_animales.avanza_pierde_vida_piraña());  
    }
    
    public void palabra_completada (KeyEvent event){          
        this.setCrear_animales(validacion_de_animales.palabra_completada_piraña(crear_animales, palabra_nueva, event));
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
}
