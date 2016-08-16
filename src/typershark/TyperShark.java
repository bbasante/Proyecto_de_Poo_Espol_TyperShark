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
public class TyperShark extends Application
{
    /**
     * @param args the command line arguments
     */
    public static Stage mainStage;

    public static void main(String[] args) 
    {
        // TODO code application logic here
        launch(args);
    }
    
    @Override
    public void start (Stage stage) throws Exception
    {
        mainStage = stage;
        Audio audio = new Audio();
        new Thread(audio).start();  
        Panel_Organizador panel_organizador = new Panel_Organizador();
        mainStage.setScene(panel_organizador.getScene());                
        mainStage.setTitle("TyperShark"); 
        mainStage.show();
    }       
}
