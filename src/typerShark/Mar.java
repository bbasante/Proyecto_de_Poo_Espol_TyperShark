/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typerShark;

import helpclases.Const;
import helpclases.Figura;
import helpclases.ContentText;
import Animales.AnimalMarino;
import Animales.Ballena;
import Animales.Tiburon;
import Animales.TiburonNegro;
import Animales.Piraña;
import helpclases.Estadisticas;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 *
 * @author basantes
 * Clase que juega un papel importantisimo, modela al mar en su totalidad
 * cuenta con una lista de los animales y una lista de sus hilos, al ser instanciada se encarga de inicializarlos
 * en otras palabras pornerlos en ejecucion
 */
public class Mar {
    ArrayList<AnimalMarino> animales; // lista de todos mis animales
    ArrayList<Thread> hilos;// hilos en donde se ubicaron a los animales

    //Button Guardar = new Button ("Guardar"), Puntaje = new Button ("Puntaje"), Bomba = new Button ("Bomba");
    
    Buceador buceador;// El mar conoce que buceador esta en el
    String nombre;
    Estadisticas estadisticas;
    //cada animal tiene internamente un ContenText, por esa razon fueron creadas aqui para enviar tan solo una referencia
    //a cada animal y que no se tenga que crear un Contentex por cada animal, pues al final, solo se desea+
    //poder obtener el contenido aleatorio que proporciona
    
    ContentText caracteres;// proporcionara los caracteres a las pirañas
    ContentText palabras;// proporcionara las palabras a los tiburones  
    ContentText pballena;
    private int nivel;
    public Mar(int dificultad, String jugador){
        this.buceador = new Buceador(jugador,Const.RIMGBUCEADOR);
        this.buceador.setMar(this);
        this.nombre=jugador;
        caracteres = new ContentText(false,"palabras.txt");
        palabras = new ContentText(true,"palabras.txt");
        pballena = new ContentText(true,"ballena.txt");
        nivel=1;
        animales = new ArrayList<>();
        hilos =  new ArrayList<>();
        this.llenarMar(dificultad);
        this.start();
    }
    
    //recibe una dificultad y acude a una matriz constante que proporciona cuantos animales 
    //de cada especie deben ser creados
    public void llenarMar(int dificultad){
        int cantPirañas = Const.DIFICULTAD[dificultad][0];
        int canttiburones = Const.DIFICULTAD[dificultad][1];
        int canttnegros = Const.DIFICULTAD[dificultad][2];
        int cantballenas = Const.DIFICULTAD[dificultad][3];
        
        System.out.println(cantballenas);
        
        for(int i=0;i<cantPirañas;i++){
           this.animales.add(new Piraña(buceador,caracteres));
        }
        
        for(int i=0;i<canttiburones;i++){
           this.animales.add(new Tiburon(buceador,palabras));
        }
        
        for(int i=0;i<canttnegros;i++){
           this.animales.add(new TiburonNegro(buceador,palabras));
        }
        
        for(int i=0;i<cantballenas;i++){
           this.animales.add(new Ballena(buceador,pballena));
        }
    }
    
    //guarda y le da star a los run() a los animales
    public void start(){
        
        hilos.add(new Thread(this.buceador));
        for(int i=0;i<this.animales.size();i++){
            hilos.add(new Thread(this.animales.get(i)));
        }
        for(int i=0;i<this.hilos.size();i++){
            hilos.get(i).start();
        }  
    }
    
    // se encarga de darle mas velocidad a todos los animales
    public void SiguienteNivel() throws IOException{
        estadisticas=new Estadisticas();
        estadisticas.writeNivel(nivel,buceador.getNombre(),buceador.getPuntaje());
        
        
        
        AnimalMarino tmp;
        
        for(int i=0;i<this.animales.size();i++){
            tmp = this.animales.get(i);
            
            if(tmp instanceof Piraña){
                tmp.setVelocidad(Const.VINICIALPIRAÑA + Const.UPVELOCITY*this.nivel);
            }
            
            if(tmp instanceof Tiburon){
                tmp.setVelocidad(Const.VINICIALTIBURON + Const.UPVELOCITY*this.nivel);
            }
            
            if(tmp instanceof TiburonNegro){
                tmp.setVelocidad(Const.VINICIALTNEGRO + Const.UPVELOCITY*this.nivel);
            }
        }   
        
        this.nivel++;
        
    }
    
    
    
    
    
    /*
    recibe una letra siempre y busca los animales que empiecen con la misma
    luego a cada animal le elimina dicha letra que siempre sera la inicial
    y la va borrando del animal una vez que alguno llegue a no tener mas letras
    entonces este sera reiniciado, y los demas que no eran el objetivo son recuperados.
    
    
    
    */
    public void MatarAnimal(String texto){
        ArrayList<AnimalMarino> tmp = this.Buscar(texto);
        String tmpword;
        boolean mato = false;
        
        if(tmp!=null){
            for(int i=0;i<tmp.size() ;i++){
                tmpword = tmp.get(i).getFigura().getPalabra(); 
                
                if(!tmpword.equals("")){//si no esta vacia le elimino un caracter
                    tmpword = tmpword.substring(1);
                    tmp.get(i).getFigura().setPalabra(tmpword);
                }
                
                if(tmpword.equals("")){// si ya esta vacia, procedo a reiniciar y a curar.
                    
                    if(tmp.get(i) instanceof Ballena){
                        for(int j=0;j<this.animales.size();j++){
                            if(this.animales.get(j) instanceof TiburonNegro){
                                TiburonNegro tmb = (TiburonNegro)this.animales.get(j);
                                tmb.mataronBallena();
                                
                            }
                        }
                        
                    }
                    
                    tmp.get(i).reiniciar();
                    this.recuperar();
                    this.buceador.setPuntaje(this.buceador.getPuntaje() + Const.PUNTOS);
                }
                
            }
            
           
              
        }
        
         
        
    }
    
    
    // elimina a todos los animales
    public boolean MatarTodos(){
        if(this.buceador.getPuntaje()>100){
            for(int i=0;i<this.animales.size();i++){
                this.animales.get(i).reiniciar();
            }
            return true;
        }
        return false;
    }
    
    
    // se encarga de buscar una lista de todos los animales que empiezan con el texto enviado
    public ArrayList<AnimalMarino> Buscar(String texto){
        String tmp;
        
        
        
        ArrayList<AnimalMarino> coincidencias = new ArrayList<>();
         for(int i=0;i<this.animales.size();i++){
             tmp = this.animales.get(i).getFigura().getPalabra();
             if(tmp.startsWith(texto.toLowerCase()) || tmp.startsWith(texto.toUpperCase()) ){
                 coincidencias.add(this.animales.get(i));
             }
             
         }
        
        return coincidencias;
    }
    
    
    
    //añade a un panel todas los elementos de los animales como los labels y las imagenes.
    public void addInPanel(Pane panel){
        
        panel.getChildren().addAll(this.buceador.getFigura().getImgfigura(),buceador.getVisto(),buceador.getGuardar());
        for(int i=0;i<this.animales.size();i++){
            Figura tmp = this.animales.get(i).getFigura(); 
            panel.getChildren().addAll(tmp.getImgfigura(),tmp.getNodePalabra());
        }        

    }
    
    // revivir en masa
    public void recuperar(){
         for(int i=0;i<this.animales.size();i++){
            this.animales.get(i).revivir();
        }
    }

    public Buceador getBuceador() {
        return buceador;
    }

    public int getNivel() {
        return nivel;
    }
    
    
    
    
}
