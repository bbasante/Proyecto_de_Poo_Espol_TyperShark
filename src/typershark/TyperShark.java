/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author USER
 */
public class TyperShark extends Application{
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    @Override
    public void start (Stage stage) throws Exception{
        Audio audio = new Audio();
        new Thread(audio).start();  
        Panel_Organizador panel_organizador = new Panel_Organizador();
        Scene scene = new Scene(panel_organizador.getAnchorPane(),700, 500);
        stage.setScene(scene);
        stage.setTitle("TyperShark"); 
        stage.show();
    }   
}
