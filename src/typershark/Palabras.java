/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author basantes
 */
public class Palabras {
    private Map<Integer,String> palabras;
    private String Palabra;
    private Random rnd;

    public Palabras(String texto) throws FileNotFoundException {
        File file = new File("C:\\Users\\basantes\\Documents\\NetBeansProjects\\TyperShark\\src\\"+texto+"");
        Scanner leer_archivos = new Scanner(file);
        palabras=new HashMap<Integer,String>() ;
        Integer acum=0;
        llenar((HashMap<Integer, String>) palabras, leer_archivos, acum);
//        imprimir((HashMap<Integer, String>) palabras);
        obtener();
    }
    public void llenar(HashMap <Integer,String> palabras, Scanner leer_archivos,Integer acum){
            while(leer_archivos.hasNextLine()){
             palabras.put( acum ,leer_archivos.nextLine());
             acum++;
        }
    }
    public void imprimir(HashMap <Integer,String> palabras){
        Iterator iterador = palabras.keySet().iterator();
        while(iterador.hasNext()){
          Integer key = (Integer) iterador.next();
//          System.out.println("Clave: " + key + " -> Valor: " + palabras.get(key));
        }
    }
    
    public String obtener(){
        rnd = new Random();
        int posicion_aleatoria =  (int) (rnd.nextDouble()*(palabras.size()-1));
        this.Palabra=palabras.get(posicion_aleatoria);
//        System.out.println("La posicion " +posicion_aleatoria +" y la palabra es " +Palabra);
        return Palabra;
    }
    public String getPalabra() {
        return Palabra;
    }
}
