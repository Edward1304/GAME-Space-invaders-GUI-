/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;


import Controlador.controlTeclado;
import java.awt.Color;




/**
 * 
 * @author Edward Fabian <egoyeneche at unal.edu.co >
 * 
 * Clase abstracta que hereda de otra cierto meteodos para crear en el modelo  el control
 * para poder usarse en la ejecucuin del juego
 */
public abstract class controlJuego extends Juego implements interfazMovimientoJuego{
    controlTeclado  controlador;
    
   /**
    * Cosntructor donde llama  al  control del teclado y lo pone a manejo
    * para poder implementarlo al juego y panel de juego y principal
    * @param controlador
    * @param x  posicion eje horizontal.
    * @param y  posicion eje vertival.
    * @param colores  color de movimiento.
    */
    public controlJuego(controlTeclado controlador, int x, int y, Color colores) {
        super(x, y, colores);
        this.controlador = controlador;
    }
    
    
    


}
