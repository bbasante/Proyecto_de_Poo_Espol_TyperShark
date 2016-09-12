/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpclases;

import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author User
 * tiene dos label una con una palabra y otra con una imagen imgfigura, que para la resolucion del problema
 * fue necesaria crear, esta clase se encarga del estilo y de como mostrar las palabras de cada animal y la forma del 
 * mismo, trata a ambas label como una unidad, los metodos estan enfocados a afectar a ambas, especialmente en movimiento
 * si muevo una se mueve la otra.
 * 
 * 
 */
public class Figura {
    Label imgfigura;
    Label palabra;
    ImageView forma;
    
    public Figura(String ruta, String palabra){
        
        Image imganimal = new Image(ruta);
        forma = new ImageView(imganimal);
        this.imgfigura = new Label();
        this.imgfigura.setGraphic(forma);
        this.palabra = new Label(palabra);
        this.palabra.setAlignment(Pos.CENTER);
        this.palabra.setStyle("-fx-background-color: #000;\n" + 
                                 "-fx-background-radius: 30; -fx-opacity: 0.6; -fx-font-family: \"Segoe UI Light\";" );
        this.palabra.setFont(new Font(20.0));
        this.palabra.setTextFill(Color.web("#fff"));       
    }

    public void MoverEnX(int x){
        this.imgfigura.setTranslateX(this.imgfigura.getTranslateX()- x);
        this.palabra.setTranslateX(this.palabra.getTranslateX()- x);
    }
    
    public void MoverEnY(int y){
        this.imgfigura.setTranslateY(this.imgfigura.getTranslateY()+y);
        this.palabra.setTranslateY(this.palabra.getTranslateY()+ y);
    }
    
    public void SetposicionX(int x){
        this.imgfigura.setTranslateX(x);
        this.palabra.setTranslateX(x);
    }
    
    public void SetposicionY(int y){
        this.imgfigura.setTranslateY(y);
        this.palabra.setTranslateY(y);
    }
    
    public void RandonPosicionY(){
        Random rnd = new Random();
        int aleatorio = (int)(rnd.nextDouble() * (Const.HEIGHTSCREEN - this.getHeigth()));
        this.SetposicionY(aleatorio);
    }

    public String getPalabra() {
        return palabra.getText();
    }

    public void setPalabra(String palabra) {
        this.palabra.setText(palabra);
    }
    
    public double getPosicionX(){
        return this.imgfigura.getTranslateX();
    }
    
    public double getPosicionY(){
        return this.imgfigura.getTranslateY();
    }

    public Label getImgfigura() {
        return imgfigura;
    }

    public void setImgfigura(Label imgfigura) {
        this.imgfigura = imgfigura;
    }

    public Label getNodePalabra() {
        return palabra;
    }

    public void setPalabra(Label palabra) {
        this.palabra = palabra;
    }
    
    public double getWidth(){
        return this.forma.getImage().getWidth();
    }
    
    public double getHeigth(){
        return this.forma.getImage().getHeight();
    }
}