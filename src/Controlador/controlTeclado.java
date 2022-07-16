/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Edward Fabian <egoyeneche at unal.edu.co
 * @author Alejandra Jaramillo <aljaramillo at unal.edu.co
 */

/** 
 * Es esta clase Se definen  los metodos y acciones del teclado
 * para el control del jueego como movimiento izquierda /derecha
 * y disparos.
 */
public class controlTeclado implements KeyListener{ 
    public boolean[] Estado;
    
    /**
     * Genera un estado de las teclas que se pueden presionar en este caso se toma todo 
     * el teclado que son 256
     */
    public controlTeclado(){
        Estado = new boolean[256];
    }
    /**
     * Muestra el valor de la porpuesta estado en este caso un valor booleano
     * entre 0 y el valor final.
     * @param inicial es el estado inicial que tendra inical, toma un valor  cualquier
     * dentro del cumplimiento de la restriccion del ciclo.
     * @return  salida del estado que actuó para su ejecucion?
     */
    public boolean getEstado(int  inicial){
        if(inicial < 0 || inicial >255 ){
            return false;
        }else{
            return Estado[inicial];
        }
    }
    /**
     *  Actualiza el estado de las acciones por teclado a usar en el transcurso
     * de la ejecucion del programa.
     */
    public void  reinciar(){
        Estado= new  boolean[256];
                
    }
            
    /**
     * Todos estos parametros corresponde a los atribtuos del teclado, presionado
     * tecla, esta de espera , accion de tecla
     * @param e 
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
     /**
     * Todos estos parametros corresponde a los atribtuos del teclado, presionado
     * tecla, esta de espera , accion de tecla
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        Estado [e.getKeyCode()]= true;
    }
    
     /**
     * Todos estos parametros corresponde a los atribtuos del teclado, presionado
     * tecla, esta de espera , accion de tecla
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
        Estado[e.getKeyCode()]= false;
    }

}
