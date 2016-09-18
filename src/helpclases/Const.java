/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpclases;

/**
 *
 * @author User
 */
public final class Const 
{
    //Formato de pantalla
    public static final int WIDTHSCREEN = 1200;
    public static final int HEIGHTSCREEN = 650;
    
    //Velocidades iniciales de animales marinos y buceador
    public static final int VINICIALPIRAÑA = 2;
    public static final int VINICIALTIBURON = 1;
    public static final int VINICIALTNEGRO = 1;
    public static final int VINICIALBALLENA = 0;
    public static final int VBUCEADOR = 1;
    
    //Puntos por cada palabra acertada
    public static final int PUNTOS = 20;
    
    //Dimension de las tablas TopTen y Juegos Guardados
    public static final int MAXSCORES = 10;
    public static final int MAXGAMES = 20;
    
    //Puntos para ganar bomba
    public static final int PUNTOSNECESARIOS = 100;
        
    //Parametro de aumento de velocidad por cada nivel    
    public static final int UPVELOCITY = 1;
    
    //Rutas de recursos
    public static final String RUTAPALABRAS = "palabras.txt";
    public static final String RUTAPALABRASBALLENA = "ballena.txt";
    public static final String RUTATOPTEN = "topten.txt";
    public static final String RUTAGAMES = "games.txt";
    public static final String RUTATOPTENTEST = "test.txt";
    public static final String RIMGPIRAÑA = "piraña.png";
    public static final String RIMGTIBURON = "tiburon.png";
    public static final String RIMGTNEGRO = "tiburonnegro.png";
    public static final String RIMGBALLENA = "ballena.png";
    public static final String RIMGBUCEADOR = "buceador.gif";
    public static final String RIMGFONDO = "fondo.png";
    public static final String RIMGINICIO = "inicio.png";
    
    //Mensajes o textos predeterminados
    public static final String RIMGDEFAULTNAME = "Anónimo";
    public static final String RIMGRECOVER = "Dé click en esta pantalla para seleccionar\n" +
                                            "el juego deseado";
    
    public static final String RIMGABOUT = "       ESCUELA SUPERIOR POLITECNICA DEL LITORAL\n" + 
                                            "---------------------------------------------------------------\n" +
                                            "Este juego ha sido desarrollado exclusivamente para fines\n" +
                                            "académicos.\n\n" + 
                                            "                              Estudiantes:\n" + 
                                            "                Bryan Leonel Basantes Esparza\n" + 
                                            "               Jorge Anibal Pinargote Figueroa\n" + 
                                            "                 José Antonio Martín Barreiro\n\n" + 
                                            "     Profesor: Ing. Orlando Enrique Zambrano Romero\n" + 
                                            "         Materia: Programación orientada a Objetos\n" + 
                                            "       Facultad de Ingeniería Eléctrica y Computación";
                                            
    
    public static final String RIMGHELP = "---------------------------------------------------------------------------------\n" +
                                            "                        INSTRUCCIONES DEL JUEGO\n" + 
                                            "---------------------------------------------------------------------------------\n" +
                                            "- Debe escribir las palabras de cada animal marino que aparezca. Si\n" + 
                                            "  lo hace bien, el animal desaparecerá y no le hará daño.\n" + 
                                            "- Usted ganará " + Const.PUNTOS + " puntos por cada palabra acertada\n" + 
                                            "- Por cada " + Const.PUNTOSNECESARIOS + " puntos que acumule, usted adquirirá\n" + 
                                            "  una bomba. Para usar las bombas presione la tecla ENTER y todos los\n" +
                                            "  animales en pantalla desaparecerán.\n" + 
                                            "- Si logra llegar al fondo del mar, pasará al siguiente nivel\n" + 
                                            "- Las ballenas cuando desaparecen, se llevan también a los tiburones\n" + 
                                            "  negros.\n" + 
                                            " Trata de tipear lo más rápido que pueda para que se registre en la\n" + 
                                            " lista de los mejores!\n";
    
    //Parámetros de animales según dificultad {Pirañas,Tiburones,Tiburones Negros,Ballenas}
    public static final int[][] DIFICULTAD = {{1,2,1,1},
                                              {2,3,2,1},
                                              {2,3,3,1},
                                              {3,5,4,1}};
    
}