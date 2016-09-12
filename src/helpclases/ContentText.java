/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpclases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author User
 * 
 * contiente un arraylizt, se llena de palabras de un archivo si se instancia con true o crea una lista de letras 
 * si se instancia con flase; y tiene un metodo para poder obtener aletoriamente el contenido del arraylist.
 */
public class ContentText {
    
    ArrayList<String> texto; 
    public ContentText(boolean tex, String ruta){
      texto = new ArrayList<>(); 
      if(tex==true){  
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null; 
        try {
           archivo = new File (ruta);
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);
           String linea;
           while((linea=br.readLine())!=null)
             texto.add(linea);
           }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }       
      }    
      else{       
         String letras = "abcdefghijklnñopqrstuvwxyz";
         for(int i=0;i<letras.length();i++){
             texto.add("" + letras.charAt(i));
         }  
      }
   }
    public String getRandomContent(){        
        int indice;
        Random rnd = new Random();
        indice = (int)(rnd.nextDouble() * (texto.size()-1));
        return texto.get(indice);       
    } 
}