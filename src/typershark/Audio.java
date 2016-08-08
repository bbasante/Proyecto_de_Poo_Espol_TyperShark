/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.concurrent.Task;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author basantes
 */

public class Audio extends Task<Player>{
    
    Player player ;
    
    public Audio(){
        
    }
    
    @Override
    protected Player call() throws Exception {
    try {
            File file = new File("C:\\Users\\basantes\\Documents\\NetBeansProjects\\TyperShark\\src\\Kalimba.MP3");
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferInputStream = new BufferedInputStream(fileInputStream);
            try{
                player = new Player(bufferInputStream);
                player.play();
            }catch(JavaLayerException ex){   
            }
        }catch(IOException e){
        }
        return player;
    }
}