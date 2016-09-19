/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typerShark;

import helpclases.Audio;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author basantes
 */
public class TyperShark extends Application {
    
    public static Stage mainStage;
    public static boolean gameOver;
    public static PaneOrganizer panel;
    @Override//Pantalla del Juego
    public void start(Stage stage) throws InterruptedException, IOException {
        gameOver = true;
        mainStage = stage;
        panel = new PaneOrganizer();
        Audio audio = new Audio();
        new Thread(audio).start(); 
        mainStage.setScene(panel.getScene());
        mainStage.setTitle("TyperShark");
        mainStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
