/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;


import static com.sun.glass.ui.Cursor.setVisible;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author basantes
 */
public class Panel_Organizador{
    //REVISION DEL ARCHIVO CLONADO PARA VER LOS CAMBIOS
    //private AnchorPane _AnchorPane = new AnchorPane();
    private AnchorPane _gamePane = new AnchorPane();
    private AnchorPane _introPane = new AnchorPane();
    private AnchorPane _selectPane = new AnchorPane();
    private Button button, easy, normal, very_hard, ludicrous;
    
    private Image image = new Image("fondo_de_mar.gif");
    private ImageView imagenView= new ImageView(image);
    private Buceador_con_hilo buceador_con_hilo;
    private Animales tiburon_con_hilo,tiburon_con_hilo1,tiburon_con_hilo2,tiburon_con_hilo3,tiburon_con_hilo4,tiburon_con_hilo5;
    private Animales piraña_con_hilo,piraña_con_hilo1;
    private Animales tiburon_negro_con_hilo,tiburon_negro_con_hilo1;
    private TextField textField = new TextField();
    
    private ArrayList <Animales> tiburon = new ArrayList <Animales>();
    private ArrayList <Animales> piraña = new ArrayList <Animales>();
    private ArrayList <Animales> tiburon_negro = new ArrayList <Animales>();
    
    private Scene onairScene, mainScene, secondScene;
    private BorderPane mainPane, secondPane; 
    private Pane helpPane, aboutPane;
    
    private HBox btmainPane, btsecondPane;
    
    Label lblHelp = new Label("Aquí va el texto de ayuda\n" +
                                "y guía para comprender el juego");
    Label lblAbout = new Label("Aquí van los autores\n" +
                                "y la tabla de los puntajes más altos");
    Button btHelp = new Button("Ayuda");
    Button btAbout = new Button("Acerca de");
    Button btBack1 = new Button("Retornar");  
    Button btBack2 = new Button("Retornar");  
    Button btQuit = new Button("Quit"); 
    
    public Panel_Organizador()
    {  
        button=Boton(75, 80, 520, 370, "Ancla.jpg");
        _introPane.setStyle("-fx-background-image: url('fondo_de_pantalla.jpg'); "+ "-fx-background-position: center center; " +"-fx-background-repeat: stretch;"+ "-fx-background-color: blue;");
        _introPane.getChildren().addAll(button);
        button.setOnAction((EventHandler<ActionEvent>) new CLickHandler_Jugar(0));
        
        easy=Boton(100,100,400,410,"Easy.jpg");normal=Boton(100,100,530,410,"Normal.jpg");           
        very_hard=Boton(110,100,640,410,"Very_Hard.jpg");ludicrous=Boton(100,100,780,410,"Ludicrous.jpg");
        _selectPane.getChildren().setAll(easy,normal,very_hard,ludicrous);
        _selectPane.setStyle("-fx-background-image: url('Dificultad.jpg'); "+ "-fx-background-position: center center; "+ "-fx-background-repeat: stretch;"+"-fx-background-color: blue;");
        easy.setOnAction((EventHandler<ActionEvent>) new ClickHandler());
        
        mainPane = new BorderPane();
        secondPane = new BorderPane();
        helpPane = new Pane();
        aboutPane = new Pane();
        
        btmainPane = new HBox();      
        btmainPane.getChildren().addAll(btHelp, btAbout, btBack1, btQuit);
        btmainPane.setSpacing(50);
        btmainPane.setAlignment(Pos.CENTER);
        btmainPane.setStyle("-fx-background-color: blue;");
        btmainPane.setPadding(new Insets(10));
        
        btsecondPane = new HBox();      
        btsecondPane.getChildren().addAll(btBack2);
        btsecondPane.setSpacing(50);
        btsecondPane.setAlignment(Pos.CENTER);
        btsecondPane.setStyle("-fx-background-color: blue;");
        btsecondPane.setPadding(new Insets(10));
        
        mainPane.setCenter(_introPane);
        mainPane.setBottom(btmainPane);
        secondPane.setCenter(_selectPane);        
        secondPane.setBottom(btsecondPane);
        helpPane.getChildren().addAll(lblHelp);
        aboutPane.getChildren().addAll(lblAbout);
        
        mainScene = new Scene(mainPane, 1250, 700);
        secondScene = new Scene(secondPane, 1250, 700);        
        
        btHelp.setOnAction((EventHandler<ActionEvent>) new CLickHandler_Jugar(1));
        btAbout.setOnAction((EventHandler<ActionEvent>) new CLickHandler_Jugar(2));
        btBack1.setOnAction((EventHandler<ActionEvent>) new CLickHandler_Jugar(3));  
        btBack2.setOnAction((EventHandler<ActionEvent>) new CLickHandler_Jugar(4));  
        btQuit.setOnAction((EventHandler<ActionEvent>) new CLickHandler_Jugar(5)); 
        
        onairScene = mainScene; 
    }
    /**
    public AnchorPane getAnchorPane() 
    {
        return _AnchorPane;
    }
    */ 
    public Scene getScene() 
    {
        return onairScene;
    }
    
    private class CLickHandler_Jugar implements EventHandler<ActionEvent>
    {
        private int clickHandler;
        
        public CLickHandler_Jugar(int _clickHandler)
        {
            clickHandler = _clickHandler;
        }
        
        public void handle(ActionEvent event) 
        {        
            switch (clickHandler)
            {
                case 0:
                        {   
                            TyperShark.mainStage.setScene(secondScene);                            
                            break;
                        }
                case 1:
                        {
                            mainPane.setCenter(helpPane);                            
                            break;
                        }   
                case 2:
                        {
                            mainPane.setCenter(aboutPane);                            
                            break;
                        }
                case 3:
                        {
                            mainPane.setCenter(_introPane);
                            break;
                        }   
                case 4:
                        {
                            TyperShark.mainStage.setScene(mainScene);                         
                            break;
                        }
                case 5:
                        {                            
                            Platform.exit();
                            break;
                        }                
                default :
                        {           
                            break;
                        }
            }
        }
    }
    private class ClickHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event){
            try {
                cantidad_de_tiburones ();
            } catch (FileNotFoundException ex) {}
            try {
                cantidad_de_pirañas();
            } catch (FileNotFoundException ex) {}
            try {
                cantidad_de_tiburones_negros();
            } catch (FileNotFoundException ex) {}
    
            try { 
                buceador_con_hilo= new Buceador_con_hilo(tiburon,piraña,tiburon_negro);
            } catch (FileNotFoundException ex) {}
            Thread thread_bucedor_con_hilo= new Thread(buceador_con_hilo);
            thread_bucedor_con_hilo.start();

            textField.setMaxSize(1200, 700);
            imagenView.setFitHeight(700);
            imagenView.setFitWidth(1250);
            
            _gamePane.setStyle("-fx-background-image: url('Dificultad.jpg'); "+ "-fx-background-position: center center; "+ "-fx-background-repeat: stretch;"+"-fx-background-color: blue;");
            _gamePane.getChildren().setAll(textField,imagenView,tiburon_con_hilo.getCrear_animales_tiburon(),tiburon_con_hilo1.getCrear_animales_tiburon(),buceador_con_hilo.getEtiquetaTextoImagen(),piraña_con_hilo.getCrear_animales_piraña(),piraña_con_hilo1.getCrear_animales_piraña(),tiburon_negro_con_hilo.getCrear_animales_tiburon_negro(),tiburon_negro_con_hilo1.getCrear_animales_tiburon_negro()); 
            _gamePane.getChildren().get(0).setOnKeyPressed(new KeyPressed());            
        }
    } 
    
    public Button Boton(int presizeX, int presizeY, int transX, int transY, String imagen){
        Button btn = new Button();
        btn.setPrefSize(presizeX, presizeY);
        btn.setTranslateX(transX);
        btn.setTranslateY(transY);
        btn.setStyle("-fx-background-image: url("+imagen+"); ");
        return btn;
    }
    
    private class KeyPressed implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            
            tiburon_con_hilo.palabra_completada(event,0); 
            tiburon_con_hilo1.palabra_completada(event,0);
            
            piraña_con_hilo.palabra_completada(event,1);
            piraña_con_hilo1.palabra_completada(event,1);
                        
            tiburon_negro_con_hilo.palabra_completada(event,2);
            tiburon_negro_con_hilo1.palabra_completada(event,2);  
        }
    }
    public void cantidad_de_tiburones () throws FileNotFoundException{
        
        tiburon_con_hilo = new Animales(0);
        tiburon_con_hilo1 = new Animales(0);
        
        tiburon.add(tiburon_con_hilo);
        tiburon.add(tiburon_con_hilo1);
        
        Thread thread_tiburo_con_hilo= new Thread(tiburon_con_hilo);
        thread_tiburo_con_hilo.start();
        Thread thread_tiburo_con_hilo1= new Thread(tiburon_con_hilo1);
        thread_tiburo_con_hilo1.start();
    }
    public void cantidad_de_pirañas () throws FileNotFoundException{
        piraña_con_hilo=new Animales(1);
        piraña_con_hilo1=new Animales(1);

        piraña.add(piraña_con_hilo);
        piraña.add(piraña_con_hilo1);
        
        Thread thread_piraña_con_hilo= new Thread(piraña_con_hilo);
        thread_piraña_con_hilo.start();
        Thread thread_piraña_con_hilo1= new Thread(piraña_con_hilo1);
        thread_piraña_con_hilo1.start();
    }
    public void cantidad_de_tiburones_negros () throws FileNotFoundException{
        tiburon_negro_con_hilo=new Animales(2);
        tiburon_negro_con_hilo1=new Animales(2);
        
        tiburon_negro.add(tiburon_negro_con_hilo);
        tiburon_negro.add(tiburon_negro_con_hilo1);
       
        Thread thread_tiburon_negro_con_hilo= new Thread(tiburon_negro_con_hilo);
        thread_tiburon_negro_con_hilo.start();
        Thread thread_tiburon_negro_con_hilo1= new Thread(tiburon_negro_con_hilo1);
        thread_tiburon_negro_con_hilo1.start();
    }
}
