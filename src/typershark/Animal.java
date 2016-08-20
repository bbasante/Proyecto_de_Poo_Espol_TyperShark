/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import javafx.scene.input.KeyEvent;

/**
 *
 * @author basantes
 */
public interface Animal {
    public abstract void avanzar();
    public abstract void validacion(KeyEvent event);
}
