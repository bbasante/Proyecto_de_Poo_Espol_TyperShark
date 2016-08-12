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
    private Random rnd = new Random(); 
    private int posicionX;
    private int posicionY= (int) (rnd.nextDouble()*400);
    public Tiburones() {
        crear_animales=new Crear_animales("Tiburon.gif");
        crear_animales.getEtiquetaTextoImagen();
        this.posicionX=600;
    }
    
    public Crear_animales getCrear_animales() {
        return crear_animales;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setCrear_animales(Crear_animales crear_animales) {
        this.crear_animales = crear_animales;
    }

    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
}