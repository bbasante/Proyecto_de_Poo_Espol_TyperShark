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
 */
public class Piraña extends AnimalMarino {
    public Piraña(Buceador buceador ,ContentText contPiraña){
        super(Const.VINICIALPIRAÑA,Const.RIMGPIRAÑA,contPiraña,buceador);
        
    }
    // si una piraña alcanza al buceador le aumenta su contador de pirañas, si llega a mas de 3 ya le quito una vida
    @Override
    public void Morder(){
        int mordeduras = 0;
       this.buceador.setPicpiraña(this.buceador.getPicpiraña()+1); ;  //
        mordeduras = this.buceador.getPicpiraña();
        if(mordeduras>4){
            this.buceador.setPicpiraña(0);
            this.buceador.setVidas(this.buceador.getVidas() - 1);    
        }
    }
}
