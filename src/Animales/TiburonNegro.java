/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animales;


import java.util.Random;
import TyperShark.Buceador;
import helpclases.Const;
import helpclases.ContentText;

/**
 *
 * @author User
 * tiene un canreset=puedo reiniciar? y un actualreset=cuantas veces me he recinicado.
 * al reiniciar, el contador actualreset aumenta y luego se verifica si mi tiburon negro no este afuera
 * de los limites de la pantalla o si llego a su maxima capacidad para reiniciarse y si esta al fondo del mar
 * la ultima condicion serviria para avanzar al siguiente nivel y dejar a todos los animales en su lugar. 
 * 
 * yo llamo al metodo reiniciar desde dos lugares, con la primera condicion se si es que lo llame desde el run()
 * en ese caso deberia funcionar como normalmente lo hacem, pero si no se da esa condicion quiere decir que lo llame
 * desde el mar, porque alguien escribio la totalidad de la palabra de un animal, entonces como es un tiburon megro
 * no se regresa al inicio, simplemente cambia su palabra. 
 * 
 */
public class TiburonNegro extends Tiburon {
    int cantreset;
    int actualreset;
    
    
    public TiburonNegro(Buceador buceador ,ContentText contTiburon)
    {
        super(Const.VINICIALTNEGRO,Const.RIMGTNEGRO,contTiburon,buceador);
        Random rnd = new Random();
        cantreset = (int)(rnd.nextDouble() * 1 + 2); // aqui se decide cuantas veces se puede reiniciar
        actualreset = 0;
    }
    
    public void mataronBallena()
    {
        this.figura.SetposicionX(Const.WIDTHSCREEN);
        this.figura.RandonPosicionY();
        this.reset(); 
        this.before = this.figura.getPalabra();
    }
    
    @Override
    public void reiniciar()
    {
        actualreset++;
        
        if(figura.getPosicionX()<(-1*figura.getWidth()) || cantreset==actualreset || super.buceador.fondoMar())
        {
            this.figura.SetposicionX(Const.WIDTHSCREEN);
            this.figura.RandonPosicionY();
            this.reset();
            this.before = this.figura.getPalabra();
            setActualreset(0);
            Random rnd = new Random();
            setCantreset((int)(rnd.nextDouble() * 1 + 2));
        }
        else 
        {
            if(cantreset>actualreset)
            {
                this.reset();
                this.before = this.figura.getPalabra();
            }
        }
    }
    
    public void setCantreset(int cantreset) 
    {
        this.cantreset = cantreset;
    }

    public void setActualreset(int actualreset) 
    {
        this.actualreset = actualreset;
    }
}