/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animales;

import helpclases.Const;
import helpclases.ContentText;
import typerShark.Buceador;

/**
 *
 * @author Administrador
 */
public class Ballena extends AnimalMarino {
    
     public Ballena(Buceador buceador ,ContentText contBallena){
        super((Const.VINICIALPIRAÑA+Const.VINICIALTIBURON+Const.VINICIALTNEGRO)/3,Const.RIMBALLENA,contBallena,buceador);   
    }
}
