/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.FileNotFoundException;
import java.util.Random;
import javafx.scene.control.Label;

/**
 *
 * @author basantes
 */
public class Pirañas {
    
    private Crear_animales crear_animales;
    
    public Pirañas() throws FileNotFoundException{

        crear_animales=new Crear_animales("Piraña.gif");
    }

    public Label getCrear_animales() {
        return crear_animales.getEtiquetaTextoImagen();
    }
}
