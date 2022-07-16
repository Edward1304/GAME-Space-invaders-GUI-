/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import Controlador.controlTeclado;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import Modelo.InterfazJuego;


/**
 *
 * @author Edward Fabian <egoyeneche at unal.edu.co 
 * @author Alejandra Jaramillo <aljaramillo at unal.edu.co
 */
public class Jugador extends controlJuego {

    ImageIcon nave = new ImageIcon("Imagenes/nave-espacial.png");
    ImageIcon vida = new ImageIcon("Imagenes/corazon.png");
    /**
     * 
     * @param controlador llama a los movimientos por teclado par el movimiento del
     * jugador (Nave
     * @param x  posicion del objeto en el eje Horizontal.
     * @param y  posicion del objeto en el eje Vertical.
     * @param colores  asigna un color al objeto para que se pueda llamar con el graphics
     */
    public Jugador(controlTeclado controlador, int x, int y, Color colores) {
        super(controlador, x, y, colores);
    }
    /**
     * Dibuja o muestra la  que tuene  el jugador el cual esta representada por la imagen
     * Imagenes/corazon.png y esta en una posicion dada la cual es estatica y no interfiere
     * con el movimiento de los  demas juego
     * @param g 
     */
    public void verVida(Graphics g) {
        vida.paintIcon(null, g, this.getX(), this.getY());

    }
     /**
      * Dibuja y muestra la nave  que va ser  el jugador, la cual se va mover y 
      * accionar  y esta representada por la imagen Imagenes/nave-espacial.png 
      * @param g 
      */
    @Override
    public void pintarJuego(Graphics g) {
        nave.paintIcon(null, g, this.getX(), this.getY());
    }
    /**
     *  Muestra o verifica que  con exito existio un impacto
     * y se genera la puntuacion.
     * @return  retorna  el disparo  del jugador que se acertó.
     */
    @Override
    public Rectangle getExito() {
        Rectangle disparoJugador = new Rectangle(this.getX(), this.getY(), 50, 50);
        
       
        return disparoJugador;
        
       
    
    }
    /**
     * Le da el  movimiento el cual será de derecha  izquierda en eje hoirzontal,
     * tiene parametros de movimiento y activacion que le de tanto movimeinto para
     * cada lado  como restriccion.
     */
    @Override
    public void movimiento() {
        
        if (controlador.getEstado(37)) {
            xpos -= 5;
        }
        if (controlador.getEstado(39)) {
            xpos += 5;
        }

        if (xpos > 800) {
            xpos = -40;
        }
        if (xpos < -40) {
            xpos = 800;
        }

    }

}
