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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import typerShark.Buceador;
import typerShark.Mar;

/**
 *
 * @author basantes
 */
public class Estadisticas {
    public Estadisticas() {
    }
     public void writeTop(int getVidas,int getPuntaje,int getBomba,String getNombre, int getNivel) throws IOException{
         FileWriter escribir =new FileWriter(new File("Top.txt"),true);
         escribir.write(getVidas+","+getPuntaje+","+getBomba+","+getNombre+","+getNivel);
         escribir.write("\r\n");
         escribir.close();
     }
     public void writeRank(HashMap<String,Integer> texto) throws IOException{
                FileWriter escribir =new FileWriter(new File("Rankings.txt"));
                FileWriter write_top_ten = new FileWriter(new File("Rankings_top_10.txt"));
                this.FileWrite(texto, escribir);
                this.FileWrite(this.mejores10(texto), write_top_ten);
                texto.clear();
                this.mejores10(texto).clear();
                escribir.close(); 
                write_top_ten.close();
    }
     public HashMap <String,Integer> mejores10 (HashMap<String,Integer> texto){
             HashMap<String,Integer> Rank = new HashMap<String,Integer>();
             LinkedHashMap<String,Integer> ascendente = new LinkedHashMap<String,Integer>();
                    String clave, cambioRankMenor="";
                    Iterator <String> Top = texto.keySet().iterator();
                    while(Top.hasNext()){
                        clave=Top.next();
                        if(Rank.size()<10){
                            if(Rank.containsKey(clave)){
                                if(Rank.get(clave) < texto.get(clave)){
                                    Rank.put(clave,texto.get(clave));
                                }
                            }else{
                                Rank.put(clave,texto.get(clave));
                            }
                        }else{
                            String RankMenor, ordenados;
                            Iterator <String> mejores = Rank.keySet().iterator();
                            int i=0;
                            Integer menor=0;
                            while(mejores.hasNext()){
                                RankMenor=mejores.next();
                                if(i==0){
                                    menor= Rank.get(RankMenor);
                                    cambioRankMenor=RankMenor;
                                    i++;
                                }
                                if(Rank.get(RankMenor) < menor){
                                    menor=Rank.get(RankMenor);
                                    cambioRankMenor=RankMenor;
                                }
                            }
                            if(Rank.containsKey(clave)){
                                if(Rank.get(cambioRankMenor)<texto.get(clave)){
                                    Rank.put(clave,texto.get(clave) );
                                }
                            }else{
                                if(texto.get(clave)>menor){
                                    Rank.remove(cambioRankMenor);
                                    Rank.put(clave,texto.get(clave));
                                } 
                            }
                        }    
                    }
                    while(Rank.size()>0){
                            String RankMayor="",cambioRankMayor="";
                            Iterator <String> mejores = Rank.keySet().iterator();
                            int i=0;
                            Integer mayor=0;
                            while(mejores.hasNext()){
                                RankMayor=mejores.next();
                                if(i==0){
                                    mayor= Rank.get(RankMayor);
                                    cambioRankMayor=RankMayor;
                                    i++;
                                }
                                if(Rank.get(RankMayor) > mayor){
                                    mayor=Rank.get(RankMayor);
                                    cambioRankMayor=RankMayor;
                                }
                            }
                            Rank.remove(cambioRankMayor);
                            ascendente.put(cambioRankMayor, mayor);
                    }
        return ascendente;
                    }
     public HashMap<String,Integer> readTop() throws FileNotFoundException, IOException{
                    HashMap<String,Integer> texto = new HashMap<String,Integer>();
                    BufferedReader br = new BufferedReader(new FileReader (new File ("Top.txt")));
                    try{
                        String linea;
                        HashMap<String,String> Save=new HashMap<String,String> ();
                         while((linea=br.readLine())!=null){
                             String Array[]= linea.split(",");
                             ArrayList <String> words = new ArrayList();
                             for(int i=0; i<Array.length;i++){
                                 words.add((String)Array[i]);
                             }
                                  if (texto.containsKey(words.get(3))) {
                                      if(texto.get(words.get(3)) < Integer.parseInt(Array[1]) ){
                                          texto.put((String)words.get(3),Integer.parseInt(Array[1]));
                                          String niveles[]= Save.get((String)words.get(3)).split(",");
                                          if(Integer.parseInt( Array[4]) > Integer.parseInt( niveles [3]) ){
                                              Save.put((String)words.get(3),((String)Array[0]+","+(String)Array[1]+","+(String)Array[2]+","+(String)Array[4]));
                                          }else{
                                          Save.put((String)words.get(3),((String)Array[0]+","+(String)niveles[1]+","+(String)Array[2]+","+(String)niveles[3]));
                                         }
                                    }
                                  }else{
                                      texto.put((String)words.get(3),Integer.parseInt(Array[1]));
                                      Save.put((String)words.get(3),((String)Array[0]+","+(String)Array[1]+","+(String)Array[2]+","+(String)Array[4]));
                                  }
                                  words.clear();
                         }
                         this.Save(Save); 
                     }catch(NullPointerException e){}
                    br.close(); 
        return texto;
    }
     public void writeNivel(int nivel, String buceador, int puntaje) throws IOException{
         FileWriter escribir =new FileWriter(new File("Nivel "+nivel+".txt"),true);
         escribir.write(buceador+","+puntaje);
         escribir.write("\r\n");
         escribir.close();
        HashMap<String,Integer> texto = new HashMap<String,Integer>();
        BufferedReader br = new BufferedReader(new FileReader (new File ("Nivel "+nivel+".txt")));
        try{
            String linea;
             while((linea=br.readLine())!=null){
                 String Array[]= linea.split(",");
                 ArrayList <String> words = new ArrayList();
                 for(int i=0; i<Array.length;i++){
                     words.add((String)Array[i]);
                 }
                      if (texto.containsKey(words.get(0))) {
                          if(texto.get(words.get(0)) < Integer.parseInt(Array[1]) ){
                              texto.put((String)words.get(0),Integer.parseInt(Array[1]));
                        }
                      }else{
                          texto.put((String)words.get(0),Integer.parseInt(Array[1]));
                          }
                      words.clear();
             }
                    this.FileWriteNivel((LinkedHashMap<String, Integer>) this.mejores10(texto),nivel);
                    this.mejores10(texto).clear();        
         }catch(NullPointerException e){}
        br.close(); 
    }
     public void FileWriteNivel(LinkedHashMap<String,Integer> Rank , int nivel) throws IOException{
         FileWriter escribir =new FileWriter(new File("Nivel "+nivel+".txt"));
         this.FileWrite(Rank, escribir);
         escribir.close();
     }
     public void Save (HashMap<String,String> Save) throws IOException{
        FileWriter escribir =new FileWriter(new File("Save.txt"));
        String clave;
            Iterator <String> Top = Save.keySet().iterator();
            while(Top.hasNext()){
                clave=Top.next(); 
                escribir.write(clave+","+Save.get(clave));
                escribir.write("\r\n");
            }
        Save.clear();
        escribir.close();
     }
     public void load (String nombre, Buceador buceador, Mar mar) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader (new File ("Save.txt")));
        Boolean bandera=false, acierto=false;
        try{
            String linea;
             while((linea=br.readLine())!=null){
                 String Array[]= linea.split(",");
                 if(Array[0].contains(nombre)){
                     buceador.setNombre(nombre);
                     buceador.setVidas(Integer.parseInt(Array[1]));
                     buceador.setPuntaje(Integer.parseInt(Array[2]));
                     buceador.setBomba(Integer.parseInt(Array[3]));
                     mar.setNivel(Integer.parseInt(Array[4]));
                     bandera=true;
                 }else{
                     acierto=true;
                 }
             }
             if(bandera==false && acierto==true){
                 JOptionPane.showMessageDialog(null, "El nombre: "+nombre +" No existe. Por lo tanto Usted Juega una nueva Partida");
             }else{
                 JOptionPane.showMessageDialog(null, "El nombre: "+nombre +" Si existe. Su Partida fue cargada con exito");
             }
         }catch(NullPointerException e){}
        br.close();
     }
     public void FileWrite (HashMap<String,Integer> texto, FileWriter escribir) throws IOException{
        String General;
        Iterator <String> Generico = texto.keySet().iterator();
        while(Generico.hasNext()){
            General=Generico.next();
            escribir.write(General+","+texto.get(General));
            escribir.write("\r\n");
        }
     }
}