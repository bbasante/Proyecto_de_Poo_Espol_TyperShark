/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import java.io.FileNotFoundException;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author basantes
 */
public class Animales implements Runnable  {
    
    private Palabras_y_Caracteres palabra_nueva_tiburon = new Palabras_y_Caracteres("palabras.txt");
    private Palabras_y_Caracteres palabra_nueva_tiburon_negro = new Palabras_y_Caracteres("palabras.txt");
    private Label crear_animales_tiburon,crear_animales_piraña,crear_animales_tiburon_negro;
    private Validacion_de_animales validacion_de_animales_tiburon,validacion_de_animales_piraña,validacion_de_animales_tiburon_negro;
    private Palabras_y_Caracteres caracter_nueva = new Palabras_y_Caracteres("caracteres.txt");
    private int animal;
    private Palabras_y_Caracteres palabras=new Palabras_y_Caracteres("palabras.txt");
    private String pal=palabras.getPalabra();
    //private Label etiquetaTextoImagen = new Label(pal);
    public Animales(int animal) throws FileNotFoundException{
        this.animal=animal;
        if(animal==0){
            crear_animales_tiburon= Crear_Animales("Tiburon.gif");  
            validacion_de_animales_tiburon=new Validacion_de_animales(crear_animales_tiburon,palabra_nueva_tiburon);
        }
        if(animal==1){
            crear_animales_piraña =  Crear_Animales("Piraña.gif");
            crear_animales_piraña.setText(caracter_nueva.obtener_una_palabra());
            validacion_de_animales_piraña=new Validacion_de_animales(crear_animales_piraña,caracter_nueva);
        }
        if(animal==2){
            crear_animales_tiburon_negro=Crear_Animales("Tiburon_negro.gif"); 
            validacion_de_animales_tiburon_negro=new Validacion_de_animales(crear_animales_tiburon_negro,palabra_nueva_tiburon_negro);}
    }
    public void run(){
        if(getAnimal()==0){
            this.setCrear_animales_tiburon(validacion_de_animales_tiburon.avanza_pierde_vida_tiburon());   
        }
        if(getAnimal()==1){
            this.setCrear_animales_piraña(validacion_de_animales_piraña.avanza_pierde_vida_piraña());   
        }
        if(getAnimal()==2){
            this.setCrear_animales_tiburon_negro(validacion_de_animales_tiburon_negro.avanza_pierde_vida_tiburon_negro());  
        }     
    }
    
    public void palabra_completada (KeyEvent event, int valor){
        if(valor==0){
            this.setCrear_animales_tiburon(validacion_de_animales_tiburon.palabra_completada_tiburon(crear_animales_tiburon, palabra_nueva_tiburon, event));
        }
        if(valor==1){
            this.setCrear_animales_piraña(validacion_de_animales_piraña.palabra_completada_piraña(crear_animales_piraña, caracter_nueva, event));
        }
        if(valor==2){
            this.setCrear_animales_tiburon_negro(validacion_de_animales_tiburon_negro.palabra_completada_tiburon_negro(crear_animales_tiburon_negro, palabra_nueva_tiburon_negro, event));
            }
    }
    
    public Label Crear_Animales(String animal) throws FileNotFoundException{
        
        Image Tipo_de_animal= new Image(animal);
        ImageView animal_seleccionado= new ImageView(Tipo_de_animal);
        Label etiquetaTextoImagen = new Label(pal);
        
        etiquetaTextoImagen.setTextFill(Color.BLACK);
        etiquetaTextoImagen.setFont(Font.font(null, FontWeight.BOLD, 20));
        etiquetaTextoImagen.setTextAlignment(TextAlignment.CENTER);
        etiquetaTextoImagen.setContentDisplay(ContentDisplay.CENTER);
        etiquetaTextoImagen.setGraphicTextGap(1);
        etiquetaTextoImagen.setGraphic(animal_seleccionado);
        return etiquetaTextoImagen;
    }

    public String getPal() {
        return pal;
    }

    public void setPal(String pal) {
        this.pal = pal;
    }
    
    public Label getCrear_animales_tiburon() {
        return crear_animales_tiburon;
    }
        
    public Label getCrear_animales_piraña() {
            return crear_animales_piraña;
        }
      public Label getCrear_animales_tiburon_negro() {
        return crear_animales_tiburon_negro;
    }      

    public int getAnimal() {
        return animal;
    }

    public Palabras_y_Caracteres getPalabra_nueva_tiburon() {
        return palabra_nueva_tiburon;
    }

    public void setPalabra_nueva_tiburon(Palabras_y_Caracteres palabra_nueva_tiburon) {
        this.palabra_nueva_tiburon = palabra_nueva_tiburon;
    }

    public Palabras_y_Caracteres getPalabra_nueva_tiburon_negro() {
        return palabra_nueva_tiburon_negro;
    }

    public void setPalabra_nueva_tiburon_negro(Palabras_y_Caracteres palabra_nueva_tiburon_negro) {
        this.palabra_nueva_tiburon_negro = palabra_nueva_tiburon_negro;
    }

    public Label getCrear_animales_tiburon_() {
        return crear_animales_tiburon;
    }

    public void setCrear_animales_tiburon(Label crear_animales_tiburon) {
        this.crear_animales_tiburon = crear_animales_tiburon;
    }

    public Label getCrear_animales_piraña_() {
        return crear_animales_piraña;
    }

    public void setCrear_animales_piraña(Label crear_animales_piraña) {
        this.crear_animales_piraña = crear_animales_piraña;
    }

    public Label getCrear_animales_tiburon_negro_() {
        return crear_animales_tiburon_negro;
    }

    public void setCrear_animales_tiburon_negro(Label crear_animales_tiburon_negro) {
        this.crear_animales_tiburon_negro = crear_animales_tiburon_negro;
    }

    public Validacion_de_animales getValidacion_de_animales_tiburon() {
        return validacion_de_animales_tiburon;
    }

    public void setValidacion_de_animales_tiburon(Validacion_de_animales validacion_de_animales_tiburon) {
        this.validacion_de_animales_tiburon = validacion_de_animales_tiburon;
    }

    public Validacion_de_animales getValidacion_de_animales_piraña() {
        return validacion_de_animales_piraña;
    }

    public void setValidacion_de_animales_piraña(Validacion_de_animales validacion_de_animales_piraña) {
        this.validacion_de_animales_piraña = validacion_de_animales_piraña;
    }

    public Validacion_de_animales getValidacion_de_animales_tiburon_negro() {
        return validacion_de_animales_tiburon_negro;
    }

    public void setValidacion_de_animales_tiburon_negro(Validacion_de_animales validacion_de_animales_tiburon_negro) {
        this.validacion_de_animales_tiburon_negro = validacion_de_animales_tiburon_negro;
    }

    public Palabras_y_Caracteres getCaracter_nueva() {
        return caracter_nueva;
    }

    public void setCaracter_nueva(Palabras_y_Caracteres caracter_nueva) {
        this.caracter_nueva = caracter_nueva;
    }
}
