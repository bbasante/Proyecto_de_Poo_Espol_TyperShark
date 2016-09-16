/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpclases;

import java.util.ArrayList;
import javafx.scene.control.Label;
import TyperShark.Buceador;

/**
 *
 * @author jose.martin
 */
public class Tanteador 
{
    int intLife, intPower, intScore, intLevel;
    
    Boolean blTopTen;
    String strTanteador, strTopTen;
    Label lblTanteador, lblTopTen;
    ArrayList<Buceador> topten;

    public Tanteador() 
    {
        intLife = 0;
        intPower = 0;
        intScore = 0;       
        intLevel = 1;
        blTopTen = false;
        
        //Código aquí para cargar ArrayList topten desde archivo
        topten = new ArrayList<>();
    }
    
    public Label getTanteador()
    {
        strTanteador =  "Vidas: " + intLife + "\t\tBombas: " + intPower + "\t\tPuntaje: " + intScore + "\t\tNivel: " + intLevel;
        lblTanteador = new Label(strTanteador);
        return lblTanteador;
    }    
    
    public Label resetTanteador()
    {
        intLife = 0;
        intPower = 0;
        intScore = 0;
        lblTanteador = getTanteador();
        return lblTanteador;
    }    
    
    public void setLife(int newlife)
    {
        intLife = newlife;        
    }    
    
    public void setPower(int newbomba)
    {
        intPower = newbomba;        
    }   
    
    public void setScore(int newscore)
    {
        intScore = newscore;        
    }
    
    public void setLevel(int newlevel)
    {
        intLevel = newlevel;        
    }
    
    public int getLife()
    {
        return intLife;        
    }    
    
    public int getPower()
    {
        return intPower;        
    }    
    
    public int getScore()
    {
        return intScore;        
    }    
    
    public int getLevel()
    {
        return intLevel;        
    }
    
    public boolean setTopTen()
    {
        if ( intScore > topten.get(10).getPuntaje() )
        {
            blTopTen = true;
            //Falta código aquí
            //Preguntar por nombre de jugador y ubicar en los TopTen en forma ordenada
            //
        }        
        return blTopTen;
    }
    
    public Label getTopTen()
    {
        strTopTen =  ("Nombre" + "\t\tPuntaje: " +
                    "-------------------------------------------------" +
                    topten.get(0).getNombre() + "\t\t" + topten.get(0).getPuntaje() + "\t\t" + topten.get(0).getLevel() +
                    topten.get(1).getNombre() + "\t\t" + topten.get(1).getPuntaje() + "\t\t" + topten.get(1).getLevel() +
                    topten.get(2).getNombre() + "\t\t" + topten.get(2).getPuntaje() + "\t\t" + topten.get(2).getLevel() +
                    topten.get(3).getNombre() + "\t\t" + topten.get(3).getPuntaje() + "\t\t" + topten.get(3).getLevel() +
                    topten.get(4).getNombre() + "\t\t" + topten.get(4).getPuntaje() + "\t\t" + topten.get(4).getLevel() +
                    topten.get(5).getNombre() + "\t\t" + topten.get(5).getPuntaje() + "\t\t" + topten.get(5).getLevel() +
                    topten.get(6).getNombre() + "\t\t" + topten.get(6).getPuntaje() + "\t\t" + topten.get(6).getLevel() +
                    topten.get(7).getNombre() + "\t\t" + topten.get(7).getPuntaje() + "\t\t" + topten.get(7).getLevel() +
                    topten.get(8).getNombre() + "\t\t" + topten.get(8).getPuntaje() + "\t\t" + topten.get(8).getLevel() +
                    topten.get(9).getNombre() + "\t\t" + topten.get(9).getPuntaje() + "\t\t" + topten.get(9).getLevel() +
                    "-------------------------------------------------");
        lblTopTen = new Label(strTopTen);
        return lblTopTen;
    }
}
