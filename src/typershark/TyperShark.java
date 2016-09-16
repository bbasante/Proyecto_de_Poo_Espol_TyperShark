/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import helpclases.Const;
import helpclases.Audio;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author basantes
 */
public class TyperShark extends Application {
    
    @Override
    public void start(Stage stage) throws InterruptedException, IOException {
        PaneOrganizer panel = new PaneOrganizer();
        Audio audio = new Audio();
        new Thread(audio).start();  
        Scene scene = new Scene(panel.getRoot(),Const.WIDTHSCREEN,Const.HEIGHTSCREEN);
        panel.listenerKey(scene);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
