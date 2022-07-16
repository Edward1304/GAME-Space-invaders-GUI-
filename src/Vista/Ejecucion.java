  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Vista.JuegoPanel;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Edward Fabian <egoyeneche at unal.edu.co
 * @author Alejandra Jaramillo <aljaramillo at unal.edu.co
 */

/**
 * 
 * Programa vista donde se va mostrar la ventana del juego
 */
public class Ejecucion extends JFrame{
    /**
     * Llama a la clase Juego Panel .
     */
    private JuegoPanel juego;
    
    
     /**
      * Ejecuta  y llamada a los otras clases que tiene una  relacion directa
      * para su ejecucion y muestra la ventana del juego 
      */
    public Ejecucion() {
        super ("SPICE INVADERS EA 2022");
        
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        juego = new JuegoPanel();
        juego.setDoubleBuffered(true);
        
        this.getContentPane().add(juego);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        juego.start();
       
        
    }
    
    
    /**
     * Runeable que  ejecuta los parametros  de la ventay le da validacion 
     * de culminar y cerrar la ventana
     * @param args 
     */

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ejecucion().setVisible(true);
            }
        });

       
    }
    
    
    
}   
