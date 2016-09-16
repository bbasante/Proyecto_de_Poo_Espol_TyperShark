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
         File archivo=new File("Top.txt");
         FileWriter escribir =new FileWriter(archivo,true);

         escribir.write(getVidas+","+getPuntaje+","+getBomba+","+getNombre+","+getNivel);
         escribir.write("\r\n");
         escribir.close();
     }
     public void writeRank(HashMap<String,Integer> texto) throws IOException{
                File archivo=new File("Rankings.txt");
                FileWriter escribir =new FileWriter(archivo);
                 
                String clave;
                    Iterator <String> Top = texto.keySet().iterator();
                    while(Top.hasNext()){
                        clave=Top.next(); 
                        escribir.write(clave+","+texto.get(clave));
                        escribir.write("\r\n");
                        //System.out.println("El producto es " +clave +" con su Precio de: " +listaProductos.get(clave));
                    }
                texto.clear();
                escribir.close(); 
    }
     public HashMap<String,Integer> readTop(HashMap<String,Integer> texto) throws FileNotFoundException, IOException{
                    File archivo = new File ("Top.txt");
                    FileReader fr = new FileReader (archivo);
                    BufferedReader br = new BufferedReader(fr);

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
                                          Save.put((String)words.get(3),((String)Array[0]+","+(String)Array[1]+","+(String)Array[2]+","+(String)Array[4]));
                                      }
                                  }else{
                                      texto.put((String)words.get(3),Integer.parseInt(Array[1]));
                                      Save.put((String)words.get(3),((String)Array[0]+","+(String)Array[1]+","+(String)Array[2]+","+(String)Array[4]));
                                  }
                                  words.clear();
                         }
                         this.Save(Save);
                         
                     }catch(NullPointerException e){
                                  e.printStackTrace();
                             }
                    fr.close(); 
        return texto;
    }
     public void writeNivel(int nivel, String buceador, int puntaje) throws IOException{
         File archivo=new File("Nivel "+nivel+".txt");
         FileWriter escribir =new FileWriter(archivo,true);

         escribir.write(buceador+","+puntaje);
         escribir.write("\r\n");
         escribir.close();
    }
     public void Save (HashMap<String,String> Save) throws IOException{
        File archivo=new File("Save.txt");
        FileWriter escribir =new FileWriter(archivo);

        String clave;
            Iterator <String> Top = Save.keySet().iterator();
            while(Top.hasNext()){
                clave=Top.next(); 
                escribir.write(clave+","+Save.get(clave));
                escribir.write("\r\n");
                //System.out.println("El producto es " +clave +" con su Precio de: " +listaProductos.get(clave));
            }
        Save.clear();
        escribir.close();
     }
     public void load (String nombre, Buceador buceador, Mar mar) throws FileNotFoundException, IOException{
        File archivo = new File ("Save.txt");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);

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
                 }
             }
         }catch(NullPointerException e){
                      e.printStackTrace();
                 }
        fr.close();
     }
}
