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

/**
 *
 * @author basantes
 */
public class Estadisticas {

    public Estadisticas() {
    }
     public void writeRank(int getVidas,int getPuntaje,int getBomba,String getNombre, int getNivel) throws IOException{
         File archivo=new File("Rankings.txt");
         FileWriter escribir =new FileWriter(archivo,true);

         escribir.write(getVidas+","+getPuntaje+","+getBomba+","+getNombre+","+getNivel);
         escribir.write("\r\n");
         escribir.close();
     }
     public void writeTop(HashMap<String,Integer> texto) throws IOException{
             File archivo11=new File("Top.txt");
                 FileWriter escribir1 =new FileWriter(archivo11);
                 
                 String clave;
                    Iterator <String> Top = texto.keySet().iterator();
                    while(Top.hasNext()){
                        clave=Top.next();
                        
                        escribir1.write(clave+","+texto.get(clave));
                        escribir1.write("\r\n");
                        //System.out.println("El producto es " +clave +" con su Precio de: " +listaProductos.get(clave));
                    }
                 texto.clear();
                 escribir1.close(); 
    }
     public HashMap<String,Integer> readRank(HashMap<String,Integer> texto) throws FileNotFoundException, IOException{
             File archivo1 = new File ("Rankings.txt");
                    FileReader fr = new FileReader (archivo1);
                    BufferedReader br = new BufferedReader(fr);

                    try{
                        String linea;
                         while((linea=br.readLine())!=null){

                             String Array[]= linea.split(",");
                             ArrayList <String> words = new ArrayList();
                             for(int i=0; i<Array.length-1;i++){
                                 words.add((String)Array[i]);
                             }
                                  if (texto.containsKey(words.get(3))) {
                                      if(texto.get(words.get(3)) < Integer.parseInt(Array[1]) ){
                                          texto.put((String)words.get(3),Integer.parseInt(Array[1]));
                                      }
                                  }else{
                                      texto.put((String)words.get(3),Integer.parseInt(Array[1]));
                                  }
                                  words.clear();
                         }
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
}