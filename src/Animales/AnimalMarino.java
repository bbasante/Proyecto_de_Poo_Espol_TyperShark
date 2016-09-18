/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animales;


import java.util.Random;
import javafx.application.Platform;
import typerShark.Buceador;
import helpclases.Const;
import helpclases.ContentText;
import helpclases.Figura;

/**
 *
 * @author User
 * 
 * clase de las que heredan piraña, tiburon, tiburon negro.
 */
public class AnimalMarino implements Runnable {
    int velocidad; //velocidad del animal
    Figura figura; //todo animal marino tiene una forma o figura, este tipo de dato nos permite darsela, ver clase Figura. 
    ContentText MyWords;// proporciona el contenido del animal
    Buceador buceador;// se debe tener la referencia al buceador para poder quitarle vidas si lo alcanzo
    boolean ataque; // sirve para que el animal solo ataque una vez cada vez que su posicion es igual o pasó al buceador 
    String before; // la palabra que tenia antes de que empezaran a tipearlo(Matarlo) si el no era el objetivo, revive
    
    public AnimalMarino(int velocidad,String ruta, ContentText words,Buceador buceador){
        this.MyWords = words; 
        this.velocidad = velocidad;
        this.figura=new Figura(ruta,this.MyWords.getRandomContent());
        this.before = this.figura.getPalabra();
        this.figura.RandonPosicionY();
        this.figura.SetposicionX(Const.WIDTHSCREEN); //posicion de inicio, final de pantalla
        this.buceador=buceador;
        this.ataque = false;
        
        
    }

    public AnimalMarino() {
    
    }
    
    /*
    el run del animal marino se encarga de moverlo hacia la direccion del buceador, tomando en cuent que si 
    lo alcanza lo muerde por eso el primer if, y que si se sale de la pantalla la misma distancia que el ancho
    de su figura tiene que reiniciarse.
    */
    @Override
    public void run() {
        while(true){  
             Platform.runLater(new Runnable(){
                 @Override public void run() {
                      figura.MoverEnX(velocidad);
                    
                      if(buceador.getFigura().getWidth()>figura.getPosicionX() && ataque==false){
                          Morder();
                          ataque = true;
                      }
                      if(figura.getPosicionX()<(-1*figura.getWidth())){
                         reiniciar();
                         ataque=false;
                      }   
                         
                    }


             });

            try{
              Thread.sleep(50);
            }catch(InterruptedException e){} 
       }
       
       
    }
    
    
    /*reubica en x al animal, le da una posicion random en y reset le da una nueva palabra y guardo la misma en before*/
    public void reiniciar(){
        
            this.figura.SetposicionX(Const.WIDTHSCREEN);
            this.figura.RandonPosicionY();
            this.reset();
            this.before = this.figura.getPalabra();
            
            
            
    }
    
    public void Morder(){
            this.buceador.setVidas(this.buceador.getVidas() - 1);
    }
    
    public void reset(){
        this.figura.setPalabra(this.MyWords.getRandomContent());
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    public Buceador getBuceador() {
        return buceador;
    }

    public void setBuceador(Buceador buceador) {
        this.buceador = buceador;
    }
    
    
    //siempre tipeamos y sin darnos cuenta hay palabras iguales, entonces yo como animal digo, si no era mi palabra 
    //no me mataron entonces revivo. 
    public void revivir(){
        this.figura.setPalabra(this.before);
    }
    
    
}