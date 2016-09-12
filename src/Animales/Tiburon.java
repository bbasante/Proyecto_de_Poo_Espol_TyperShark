/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animales;

import typerShark.Buceador;
import helpclases.Const;
import helpclases.ContentText;

/**
 *
 * @author User
 * hereda de animalMarino y sigue a rajatabla su modelo, no fue necesario sobreescribir algun metodo.
 */
public class Tiburon extends AnimalMarino {
    
    public Tiburon(Buceador buceador ,ContentText contTiburon){
        super(Const.VINICIALTIBURON,Const.RIMGTIBURON,contTiburon,buceador);
    }
    
    public Tiburon(int velocidad,String ruta,ContentText contTiburon,Buceador buceador ){
        super(velocidad,ruta,contTiburon,buceador);
    }
    
    public String getPalabra(){
        return super.figura.getPalabra();
    }
    
}
