/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

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
    public void start (Stage stage){
        System.out.println("AÑADIDO CON EXITO AL GITHUB INGENIERO");
        Panel_Organizador panel_organizador = new Panel_Organizador();
        Scene scene = new Scene(panel_organizador.getBorderPane(),700, 500);
        stage.setScene(scene);
        stage.setTitle("TyperShark");        
        stage.show();
    }
}
