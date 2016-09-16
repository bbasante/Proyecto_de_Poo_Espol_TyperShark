/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typerShark;

import helpclases.Const;
import helpclases.Estadisticas;
import helpclases.Figura;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author basantes
 * esta clase va a mandar en el juego si las vidas llegan a 0 el juego termina.
 * 
 * 
 */
public class Buceador implements Runnable, Serializable{
    String Nombre;
    Figura figura;
    Mar mar; // es necesario que el buceador conozca el Mar porque cuando el llega al fondo del mismo lo hace subir al siguiente nivel.
    int picpiraña;
    int vidas;
    int puntaje;
    boolean nextLevel;
    private int Bomba;
    HashMap<String,Integer> texto;
    private Label Visto = new Label();
    private Button Guardar = new Button ("Guardar");
    Estadisticas estadisticas;
    public Buceador(String Nombre, String ruta) {
        
        this.figura=new Figura(ruta,"");
        this.figura.SetposicionX(0);
        this.figura.SetposicionY(0);
        
        this.Nombre = Nombre;
        this.vidas=3;
        this.puntaje=0;
        this.nextLevel = false;
    }

    public int getPicpiraña() {
        return picpiraña;
    }

    public void setPicpiraña(int picpiraña) {
        this.picpiraña = picpiraña;
    }
    
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    public boolean NextLevel() {
        return nextLevel;
    }

    public void setNextLevel(boolean nextLevel) {
        this.nextLevel = nextLevel;
    }

    public Mar getMar() {
        return mar;
    }

    public void setMar(Mar mar) {
        this.mar = mar;
    }
    
    
    /*se encarga de mover al buceador en Y y si se encuentra en el fondo del mar
    este avanza al siguiente nivel y si las vidas del mismo llegan a 0 se termina el juego*/
    @Override
    public void run() {
        while(true){  
             Platform.runLater(new Runnable(){
                 @Override 
                 public void run() {
                    figura.MoverEnY(Const.VBUCEADOR);
                    if(fondoMar()){
                        figura.SetposicionY(0);
                        try {
                            mar.SiguienteNivel();
                        } catch (IOException ex) {}
                    }
                    
                     
                    if(vidas==0){
                        System.exit(0);
                    }
                     setBomba((int) (getPuntaje())/100);
                    Visto.setText("Vidas: " + getVidas() + "            " + "Puntaje: " +getPuntaje() + "         " + "Bombas: " + getBomba() + "          " + "Nombre: " +Nombre +"          " + "Nivel: " +mar.getNivel());            
                    Visto.setStyle("-fx-background-color: Orange;\n"+"    -fx-background-insets: 0;\n" + "-fx-border-color: Red;"+"    -fx-text-fill: white;");
                    Guardar.setTranslateX(Const.HEIGHTSCREEN);
                    Guardar.setOnAction(new ClickHandler());
                 }
             });

            try{
              Thread.sleep(100);
            }catch(InterruptedException e){} 
       }
    }
    
    public boolean fondoMar(){
        return this.figura.getPosicionY() >= Const.HEIGHTSCREEN - this.figura.getHeigth();
    }

    public Label getVisto() {
        return Visto;
    }

    public Button getGuardar() {
        return Guardar;
    }

    public int getBomba() {
        return Bomba;
    }

    public void setBomba(int Bomba) {
        this.Bomba = Bomba;
    }
    private class ClickHandler implements EventHandler<ActionEvent> {

         @Override
            public void handle(ActionEvent event) {
             try {
                 estadisticas=new Estadisticas();
                 estadisticas.writeTop(getVidas(),getPuntaje(),getBomba(),getNombre(),mar.getNivel());
                 texto = new HashMap<String,Integer>();
                 estadisticas.writeRank(estadisticas.readTop(texto)); 
             } catch (IOException ex) { }
                }
            }
    }
