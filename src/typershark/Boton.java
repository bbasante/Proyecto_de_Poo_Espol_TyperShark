/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import javafx.scene.control.Button;

/**
 *
 * @author basantes
 */
public class Boton {
    private Button btn = new Button();
    public Boton(int presizeX, int presizeY, int transX, int transY, String imagen){
        btn.setPrefSize(presizeX, presizeY);
        btn.setTranslateX(transX);
        btn.setTranslateY(transY);
        btn.setStyle("-fx-background-image: url("+imagen+"); ");
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
    
}
