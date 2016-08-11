/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.util.Random;
import javafx.scene.control.Label;

/**
 *
 * @author basantes
 */
public class Tiburones {

    private Crear_animales crear_animales;
  
    public Tiburones() {
        crear_animales=new Crear_animales("Tiburon.gif");
    }
    
    public Label getCrear_animales() {
        return crear_animales.getEtiquetaTextoImagen();
    }
}