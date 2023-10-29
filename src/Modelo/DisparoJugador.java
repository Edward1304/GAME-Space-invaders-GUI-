/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Edward Fabian <egoyeneche at unal.edu.co
 */
public class DisparoJugador extends Movimientos{
    
    int tamaño;
    int rapidez;
    
    
    /**
     * Este metodo crear la el disparo que saldra de la nave
     * e impactara con los marcianos y dará una puntacion
     * @param x la  posicion del disparo  en el  x que sera el eje horizontal.
     * @param y la  posicion del disparo  en el  y que sera el eje horizontal.
     * @param tamaño da  las dimensiones  que tendra el objeto en este caso, 
     * el tamaño del disparo que tendrá al accionarse.
     * @param colores  el atributo de color que tendra la bala que sera de color rojo.
     */
    public DisparoJugador(int x, int y, int tamaño, Color colores) {
        super(20, 20, x, y, colores);
        this.tamaño = tamaño;
        
    }
    
    /**
     * Muestra el atributo que obtiene de Tamanaño, que llega a obtener(disparo).
     * @return   retorna el tamano que obtiene el disparo
     */

    public int getTamaño() {
        return tamaño;
    }
    /**
     * Dibuja o pinta el objeto (Disparo) en  el lugar que este vaya
     * a mostrarse cuanto se ejecuta.
     * @param g  es el valor por definicion para poder dibujar o colorear el
     * obejeto.
     */
    @Override
    public void  pintarJuego(Graphics g){
        g.setColor(colores);
        g.fillRect(this.getX(),this.getY(), 7, 15);
        
    }
    /**
     *  Muestra o verifica que  con exito existio un impacto
     * y se genera la puntuacion.
     * @return  retorna  el disparo  del jugador que se acertó.
     */

    @Override
    public Rectangle getExito() {
        Rectangle  disparosJ = new Rectangle(xpos,ypos,7,15);
        return disparosJ;
                
   }

}

