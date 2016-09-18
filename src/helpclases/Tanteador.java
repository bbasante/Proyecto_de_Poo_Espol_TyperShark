/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpclases;

import java.util.ArrayList;
import javafx.scene.control.Label;
import TyperShark.Buceador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author jose.martin
 */
public class Tanteador 
{
    int intLife, intPower, intScore, intLevel;
    Boolean blTopTen;
    String strTanteador, strTopTen, strGames;
    Label lblTanteador, lblTopTen, lblGames;
    ArrayList<Buceador> topten;
    ArrayList<Buceador> games;

    public Tanteador() 
    {
        intLife = 0;
        intPower = 0;
        intScore = 0;       
        intLevel = 1;
        blTopTen = false;        
        
        //Se carga el topten y los juegos guardados (games)desde el archivo
        topten = new ArrayList<>();
        games = new ArrayList<>();
        readTopTenFile();
        readGamesFile();
    }
    
    public Label getTanteador()
    {
        //Se establece el formato del tanteador
        strTanteador =  "Vidas: " + intLife + "\t\tBombas: " + intPower + "\t\tPuntaje: " + intScore + "\t\tNivel: " + intLevel;
        lblTanteador = new Label(strTanteador);
        return lblTanteador;
    }    
    
    public Label resetTanteador()
    {
        //Se resetea el tanteador
        intLife = 0;
        intPower = 0;
        intScore = 0;
        lblTanteador = getTanteador();
        return lblTanteador;
    }    
    
    public void setLife(int newlife)
    {
        //Para establecer en el tanteador las vidas del jugador
        if (newlife < 0)
            intLife = 0;
        else
            intLife = newlife;        
    }    
    
    public void setPower(int newbomba)
    {
        //Para establecer en el tanteador las bombas del jugador
        intPower = newbomba;        
    }   
    
    public void setScore(int newscore)
    {
        //Para establecer en el tanteador el puntaje del jugador
        intScore = newscore;        
    }
    
    public void setLevel(int newlevel)
    {
        //Para establecer en el tanteador el nivel del juego del jugador
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
    
    private void readTopTenFile()
    {
        //Carga los datos del TopTen desde el archivo
        BufferedReader br = null;
        String strLine = "";
        String cvs =",";
        
        try
        {
            br = new BufferedReader(new FileReader(Const.RUTATOPTEN));
        
            for (int i = 0; i < Const.MAXSCORES; i++)
            {
                Buceador ttBuceador;
                ttBuceador = new Buceador();
                if ((strLine = br.readLine()) != null)
                {
                    String[] arrBuceador = strLine.split(cvs);
                    ttBuceador.setPuntaje(Integer.parseInt(arrBuceador[0]));
                    ttBuceador.setLevel(Integer.parseInt(arrBuceador[1]));
                    ttBuceador.setNombre(arrBuceador[2]);
                }
                else
                {
                    ttBuceador.setPuntaje(0);
                    ttBuceador.setLevel(0);
                    ttBuceador.setNombre("-");
                }
                topten.add(ttBuceador);
            }
        }
        catch (FileNotFoundException e)
        {
            //Si el archivo no existe, se lo crea con valores en cero
            try 
            {
                File file = new File(Const.RUTATOPTEN);
                file.createNewFile();
                for (int i = 0; i < Const.MAXSCORES; i++)
                {
                    Buceador ttBuceador;
                    ttBuceador = new Buceador();
                    ttBuceador.setPuntaje(0);
                    ttBuceador.setLevel(0);
                    ttBuceador.setNombre("-");
                    topten.add(ttBuceador);
                }
            }
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void writeTopTenFile(ArrayList<Buceador> topten)
    {
        //Registra en el archivo las lista TopTen ya ordenada previamente
        BufferedWriter bw;
        
        try 
        {
            bw = new BufferedWriter(new FileWriter(Const.RUTATOPTEN));
            
            for (int i = 0; i < Const.MAXSCORES; i++)
            {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(topten.get(i).getPuntaje()));
                sb.append(",");
                sb.append(String.valueOf(topten.get(i).getLevel()));
                sb.append(",");
                sb.append(String.valueOf(topten.get(i).getNombre()));
                bw.write(sb.toString());
                bw.newLine();                
            }
            bw.close();
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public boolean setTopTen(Buceador buceador)
    {
        //Se verifica si el jugador está dentro del topten, si es así se lo registra
        if ( intScore > topten.get(Const.MAXSCORES - 1).getPuntaje() )
        {
            blTopTen = true;
            topten.add(Const.MAXSCORES, buceador);
            Collections.sort(topten, new Comparator<Buceador>()
            {
                @Override
                public int compare(Buceador t2, Buceador t1) 
                {
                    return Integer.compare(t1.getLevel(), t2.getLevel());
                }
            });
            writeTopTenFile(topten);
        }
        else
        {
            blTopTen = false;
        }
        return blTopTen;
    }
    
    public Label getTopTen()
    {   
        //Devuelve el Label del TopTen listo para presentarlo en pantalla
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < Const.MAXSCORES; i++)
        {
            sb.append("  " + (i + 1) + " \t\t\t");
            sb.append(String.valueOf(topten.get(i).getLevel()));
            sb.append("\t\t\t");
            sb.append(String.valueOf(topten.get(i).getPuntaje()));
            sb.append("\t\t\t");
            sb.append(String.valueOf(topten.get(i).getNombre()));
            sb.append("\n"); 
        }
        strTopTen = ("                 MEJORES PUNTAJES POR NIVEL\n" + 
                    "---------------------------------------------------------------\n" + 
                    "Puesto" + "\t\tNivel" + "\t\tPuntaje: " + "\t\tJugador: " + "\n" + 
                    "---------------------------------------------------------------\n" + 
                    sb + 
                    "---------------------------------------------------------------\n\n\n" +
                    Const.RIMGABOUT);
        
        lblTopTen = new Label(strTopTen);
        return lblTopTen;
    }
    
    private void readGamesFile()
    {
        //Carga los datos de los juegos guardados desde el archivo
        BufferedReader br = null;
        String strLine = "";
        String cvs =",";
        
        try
        {
            br = new BufferedReader(new FileReader(Const.RUTAGAMES));
        
            for (int i = 0; i < Const.MAXGAMES; i++)
            {
                Buceador ttBuceador;
                ttBuceador = new Buceador();
                if ((strLine = br.readLine()) != null)
                {
                    String[] arrBuceador = strLine.split(cvs);
                    ttBuceador.setPuntaje(Integer.parseInt(arrBuceador[0]));
                    ttBuceador.setLevel(Integer.parseInt(arrBuceador[1]));
                    ttBuceador.setNombre(arrBuceador[2]);
                    ttBuceador.setPower(Integer.parseInt(arrBuceador[3]));
                }
                else
                {
                    ttBuceador.setPuntaje(0);
                    ttBuceador.setLevel(0);
                    ttBuceador.setNombre("-");
                    ttBuceador.setPower(0);
                }
                games.add(ttBuceador);
            }
        }
        catch (FileNotFoundException e)
        {
            //Si el archivo no existe, se lo crea con valores en cero
            try 
            {
                File file = new File(Const.RUTAGAMES);
                file.createNewFile();
                for (int i = 0; i < Const.MAXGAMES; i++)
                {
                    Buceador ttBuceador;
                    ttBuceador = new Buceador();
                    ttBuceador.setPuntaje(0);
                    ttBuceador.setLevel(0);
                    ttBuceador.setNombre("-");
                    ttBuceador.setPower(0);
                    games.add(ttBuceador);
                }
            }
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void writeGamesFile(ArrayList<Buceador> games)
    {
        //Registra en el archivo las lista games ya ordenada previamente
        BufferedWriter bw;
        
        try 
        {
            bw = new BufferedWriter(new FileWriter(Const.RUTAGAMES));
            
            for (int i = 0; i < Const.MAXGAMES; i++)
            {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(games.get(i).getPuntaje()));
                sb.append(",");
                sb.append(String.valueOf(games.get(i).getLevel()));
                sb.append(",");
                sb.append(String.valueOf(games.get(i).getNombre()));
                sb.append(",");
                sb.append(String.valueOf(games.get(i).getPower()));
                bw.write(sb.toString());
                bw.newLine();                
            }
            bw.close();
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void saveGame(Buceador buceador)
    {
        //Se registra el juego
        games.add(Const.MAXGAMES, buceador);
        Collections.sort(games, new Comparator<Buceador>()
        {
            @Override
            public int compare(Buceador t2, Buceador t1) 
            {
                return Integer.compare(t1.getPuntaje(), t2.getPuntaje());
            }
        });
            
        writeGamesFile(games);
    }
    
     
    public Label getGames()
    {   
        //Devuelve el Label de los juegos guardados ya listo para presentarlo en pantalla
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < Const.MAXGAMES; i++)
        {
            sb.append("  " + (i + 1) + " \t\t\t");
            sb.append(String.valueOf(games.get(i).getLevel()));
            sb.append("\t\t\t");
            sb.append(String.valueOf(games.get(i).getPower()));
            sb.append("\t\t\t");
            sb.append(String.valueOf(games.get(i).getPuntaje()));
            sb.append("\t\t\t");
            sb.append(String.valueOf(games.get(i).getNombre()));
            sb.append("\n");
        }
        strGames = ("Juego" + "\t\tNivel" + "\t\tBombas" + "\t\tPuntaje: " + "\t\tJugador: " + "\n" + 
                    "-----------------------------------------------------------------------------\n" + 
                    sb + 
                    "-----------------------------------------------------------------------------\n\n\n" +
                    Const.RIMGRECOVER);
        lblGames = new Label(strGames);
        return lblGames;
    }
    
    public String[] getGame(int intRecover)
    {   
        //Devuelve los datos de un juego guardado según la selección del usuario
        String [] arrGame = new String[4];
        
        arrGame[0] = String.valueOf(games.get(intRecover - 1).getPuntaje());
        arrGame[1] = String.valueOf(games.get(intRecover - 1).getLevel());
        arrGame[2] = String.valueOf(games.get(intRecover - 1).getNombre());
        arrGame[3] = String.valueOf(games.get(intRecover - 1).getPower());
            
        return arrGame;
    }
}
