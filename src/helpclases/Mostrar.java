/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpclases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

/**
 *
 * @author basantes
 */
public class Mostrar {
    public Mostrar() {
    }
    //Muestra el Ranking de forma Ascendente por pantalla
    public Label Rankings () throws FileNotFoundException, IOException{ 
        BufferedReader br = new BufferedReader(new FileReader(new File("Rankings_top_10.txt")));
        String linea,strGames;
        StringBuilder sb=new StringBuilder();
        int cont=1;
        while((linea=br.readLine())!=null){
            String Array[]= linea.split(",");
            sb.append(cont+ " \t\t\t" + Array[1]+" \t\t\t"+ Array[0]+ "\n");
            cont++;
        }
        strGames = ("-------------------------------------------\n" + 
                    "Juego" + "\t\tPuntaje " + "\t\tJugador" + "\n" + 
                    "-------------------------------------------\n" + 
                    sb + 
                    "-------------------------------------------\n\n\n");        
        return (new Label(strGames));
    }
    //Muestra las Partidas Guardadas de todos los usuarios que han jugados con sus maximos
    //Niveles y Puntajes de forma Ascendente por pantalla
    public TextArea Save() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(new File("Save.txt")));
        TextArea save = new TextArea();
        String linea,strGames;
        StringBuilder sb=new StringBuilder();
        int cont=1;
        while((linea=br.readLine())!=null){
            String Array[]= linea.split(",");
            sb.append(cont+ " \t\t\t"+ Array[1]+ " \t\t"+ Array[2]+" \t\t\t"+ Array[3]+" \t\t\t"+ Array[4]+" \t\t\t" + Array[0]+"\n");
            cont++;
        }
        strGames = (" --------------------------------------------------------------------------------------"+"\n"+
                    "|              PARA CARGAR SU PARTIDA DE CLICK FUERA DEL RECUADRO            |   "+"\n"+
                    " --------------------------------------------------------------------------------------"+"\n"+
                    "Juego" +  "\t\tVida" + "\t\tPuntaje " +  "\t\tBombas" +"\t\tNivel" + "\t\tJugador " + "\n" + 
                    "---------------------------------------------------------------------------------------\n" + 
                    sb + 
                    "----------------------------------------------------------------------------------------\n\n\n");
        save.setMaxSize(Const.WIDTHSCREEN-Const.HEIGHTSCREEN, Const.HEIGHTSCREEN);
        save.setText(strGames);
        br.close();
        return save;
    }
    //Muestra todos los Niveles Guardados de forma Ascendente por pantalla
    public TextArea Niveles() throws FileNotFoundException, IOException {
        TextArea save = new TextArea();  
        int nivel =1, acum=0;
        Boolean bandera=true;
        String strGames="";
        StringBuilder finales= new StringBuilder(),todo=new StringBuilder(),sb=new StringBuilder();
        todo.append("");
        while(bandera==true){
            File file= new File("Nivel "+nivel+".txt");
            if(file.exists()){
                acum++;
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea;                
                int cont=1;
                while((linea=br.readLine())!=null){
                    String Array[]= linea.split(",");
                    sb.append(cont+ " \t\t\t" + Array[1]+" \t\t\t"+ Array[0]+ "\n");
                    cont++;
                }
                strGames = ("-------------------------------------------\n" + 
                            "                          Nivel " +acum  +"\n"+
                            "Juego" + "\t\tPuntaje " +   "\t\tJugador"+"\n" + 
                            "-------------------------------------------\n" + 
                            todo + "\n" + sb+"\n"+
                            "-------------------------------------------\n\n\n");                
                todo=new StringBuilder();
                sb=new StringBuilder();
                finales.append(strGames+"\n");
                nivel++;
            }else{
                bandera=false;
            } 
        }
        save.setMaxSize(Const.WIDTHSCREEN, Const.HEIGHTSCREEN);
        strGames=(""+finales);
        save.setText(strGames);
        save.setTranslateX(500);
        return save;
   } 
    //Muestra las Instrucciones por pantalla
    public StackPane Instrucciones(){
        StackPane ayuda = new StackPane();
        ayuda.getChildren().addAll(new Label(Const.INTRUCCIONES));
        ayuda.setAlignment(Pos.CENTER);
        return ayuda;
    }    
    //Muestra los Creditos por pantalla
    public StackPane AcercaDe(){
        StackPane ayuda = new StackPane();
        ayuda.getChildren().addAll(new Label(Const.Creditos));
        ayuda.setAlignment(Pos.CENTER);
        return ayuda;
    }         
}