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
public class DisparoMarcianos1 extends Movimientos {
    /**
     * 
     * @param x    posicion eje horizonal.
     * @param y    posicion eje vertical.
     * @param tamaño  da  las dimensiones  que tendra el objeto en este caso, 
     * el tamaño del disparo del marciano que tendrá al accionarse.
     * @param colores  l atributo de color que tendra la bala que sera de color amarillo.
     */
    public DisparoMarcianos1(int x, int y, int tamaño, Color colores) {
        super(20, 2, x, y, colores);

    }
    
    
    /**
     * Dibuja o pinta el objeto (Disparo) en  el lugar que este vaya
     * a mostrarse cuanto se ejecuta.
     * @param g  es el valor por definicion para poder dibujar o colorear el
     * obejeto.
     */

    @Override
    public void pintarJuego(Graphics g) {
        g.setColor(colores);
        g.fillRect(this.getX(), getY(), 7, 15);

    }
    /**
     *  Muestra o verifica que  con exito existio un impacto
     * y se quita una vida al jugadot.
     * @return  retorna  el disparo  que los marcianos acertaron.
     */
    @Override
    public Rectangle getExito() {
        Rectangle disparosM = new Rectangle(xpos, ypos, 7, 15);
        return disparosM;
    }

}
