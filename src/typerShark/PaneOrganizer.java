/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typerShark;

import helpclases.Const;
import helpclases.Estadisticas;
import helpclases.Mostrar;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javax.swing.JOptionPane;

/**
 *
 * @author basantes
 */
public class PaneOrganizer {
    Pane root;
    Buceador buceador;
    Mar mar;
    String nombre;
    Estadisticas estadisticas=new Estadisticas();
    Mostrar mostrar=new Mostrar();   
    BorderPane mainPane=new BorderPane();
    StackPane introPane = new StackPane(),recoverPane=new StackPane();
    HBox btmainPane= new HBox();
    Scene onairScene, mainScene, gameScene; 
    Button btnewPlay = new Button("Jugar"),btsavedPlay = new Button("Cargar Partida"),btHelp = new Button("Ayuda");  
    Button btAbout = new Button("Acerca de"),btBack = new Button("Retornar"),btQuit = new Button("Quit");
    Button btRanking = new Button("Ranking Top 10"),btNiveles = new Button("Top 10 por Niveles");   
    
    public PaneOrganizer() throws InterruptedException, IOException{     
        //Botones de la pantalla principal
        btmainPane.getChildren().addAll(btnewPlay, btsavedPlay, btRanking, btNiveles, btHelp, btAbout, btBack, btQuit);               
        introPane.setStyle("-fx-background-image: url('" + Const.RIMGINICIO + "'); "
           + "-fx-background-position: center center; "
           + "-fx-background-repeat: stretch;");        
        mainPane.setCenter(introPane);
        mainPane.setBottom(gethbox(btmainPane));
        mainScene = new Scene(mainPane,Const.WIDTHSCREEN,Const.HEIGHTSCREEN);
        this.botones();
        onairScene = mainScene;
    }
    private class CLickHandler_Main implements EventHandler<ActionEvent>
    {   int clickHandlerMain;
        public CLickHandler_Main(int _clickHandlerMain)
        { clickHandlerMain = _clickHandlerMain;}
        @Override
        public void handle(ActionEvent event) 
        {   switch (clickHandlerMain)
            {   case 1:{    //Iniciar Juego nuevo
                            TyperShark.gameOver = false;                                                    
                            root = new Pane();
                            root.setStyle("-fx-background-image: url('" + Const.RIMGFONDO + "'); "
                               + "-fx-background-position: center center; "
                               + "-fx-background-repeat: stretch;");
                            nombre=JOptionPane.showInputDialog("Introduce tu nombre: ");                    
                            mar = new Mar(0,nombre); 
                            mar.addInPanel(root);
                            buceador = mar.getBuceador();
                            gameScene = new Scene(root,Const.WIDTHSCREEN,Const.HEIGHTSCREEN);
                            onairScene = gameScene;
                            TyperShark.mainStage.setScene(onairScene);    
                            listenerKey(onairScene);
                            break;
                        }
                case 2:{    try {//Se presentan la lista de los juegos guardados
                                recoverPane.getChildren().setAll(mostrar.Save()); 
                            } catch (IOException ex) {}
                                mainPane.setCenter(recoverPane);
                                mainPane.setOnMouseClicked(new EventHandler <MouseEvent> (){
                                    @Override
                                    public void handle(MouseEvent event) 
                                    {   //Iniciar Juego Guardado
                                        TyperShark.gameOver = false;
                                        root = new Pane();
                                        root.setStyle("-fx-background-image: url('" + Const.RIMGFONDO + "'); "
                                           + "-fx-background-position: center center; "
                                           + "-fx-background-repeat: stretch;");
                                        nombre=JOptionPane.showInputDialog("Introduce tu nombre : ","Anònimo");
                                        mar = new Mar(0,nombre); 
                                        mar.addInPanel(root);
                                        buceador = mar.getBuceador();
                                         try{
                                            estadisticas.load(nombre, buceador, mar);
                                        }catch (IOException ex) { }
                                        gameScene = new Scene(root,Const.WIDTHSCREEN,Const.HEIGHTSCREEN);
                                        onairScene = gameScene;
                                        TyperShark.mainStage.setScene(onairScene);    
                                        listenerKey(onairScene);
                                    }
                                });                            
                                break;
                        }
                case 3:{   //Mostrar Ayuda
                            mainPane.setCenter(mostrar.Instrucciones());
                            break;
                        }   
                case 4:{   //Mostrar AcercaDe
                            mainPane.setCenter(mostrar.AcercaDe());
                            break;
                        }
                case 5:{   //Cerrar la aplicación
                            Platform.exit();
                            break;
                        }
                case 6:{    try {//Mostrar Rankings Top 10
                                mainPane.setCenter(mostrar.Rankings());
                            } catch (IOException ex) {}
                            break;
                        }
                case 7:{   try {//Mostrar Niveles Top 10
                                mainPane.setCenter(mostrar.Niveles());
                            } catch (IOException ex) {}
                            break;
                        }
                case 8:{    //Retornar al Intro
                            mainPane.setCenter(introPane);
                            break;
                        }
                default :{  break;
                         }
            }
        }
    }  
    public Scene getScene(){
        return onairScene;
    }
    public void listenerKey(Scene scene){
        scene.setOnKeyPressed(new ControlIn());
    }
    public void botones(){//Definición de botones y sus funciones
        btnewPlay.setOnAction(new CLickHandler_Main(1));
        btsavedPlay.setOnAction(new CLickHandler_Main(2));
        btHelp.setOnAction(new CLickHandler_Main(3));
        btAbout.setOnAction(new CLickHandler_Main(4));
        btQuit.setOnAction(new CLickHandler_Main(5));
        btRanking.setOnAction(new CLickHandler_Main(6));
        btNiveles.setOnAction(new CLickHandler_Main(7));
        btBack.setOnAction(new CLickHandler_Main(8));
    }  
    public HBox gethbox(HBox box){
            box.setSpacing(50);
            box.setAlignment(Pos.CENTER);
            box.setStyle("-fx-background-color: blue;");
            box.setPadding(new Insets(10));
            return box;
    } 
    /*cada vez que tipeo una palabra verifico si es enter si los es y hay puntos suficiente mato 
    a todos los animales, si no es enter entonces envio esa letra a matar animal para que se encargue de buscar cuales empiezan con la misma
    y proceda a eliminarla de la palabra de una animal, hasta que alguno quede sin mas letras, ver con mas detalle el metodo matarAnimal */
     private class ControlIn implements EventHandler<KeyEvent> {
         @Override
            public void handle(KeyEvent event) {  
                if(event.getCode().equals(KeyCode.ENTER)) {
                    if(buceador.getPuntaje()> Const.PUNTOSNECESARIOS){
                        mar.MatarTodos();
                        buceador.setPuntaje(buceador.getPuntaje()-Const.PUNTOSNECESARIOS);
                    }
                }else{mar.MatarAnimal(event.getText()); }
            }  
    }
}