/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import Modelo.InterfazJuego;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author Edward Fabian <egoyeneche at unal.edu.co

 */

 
public abstract class Juego implements InterfazJuego{
    int xpos ;
    int ypos;
    Color colores;
    boolean  impactos;

    public Juego() {
    }
    /**
     * Es el metodo construtor para cualquier elemento u obteto
     * que vata a estar en el juego
     * @param x  posicion del elemnto   en el eje horizontal.
     * @param y  posicion del elemento en el eje Vertical.
     * @param colores  color natutal que el objeto  tendrá , sin  inportar que
     * sea una imagen u otra cosa. 
     */
    public Juego(int x, int y, Color colores) {
        this.xpos = x;
        this.ypos = y;
        this.colores = colores;
        
    }
    
    
    public  abstract  Rectangle getExito();
    

    public int getX(){
    return xpos;
    }
    
    
    public int getY() {
        return ypos;
    }

    public void setX(int x) {
        this.xpos = x;
    }


    public void setY(int y) {
        this.ypos = y;
    }

    public Color getColores() {
        return colores;
    }

    public void setColores(Color colores) {
        this.colores = colores;
    }
    
    /**
     * Verifica que no exista un toque entre dos exitos.
     * @param externo sirve para nombrar  o saber que algo externo esta
     * @return  en numero  o  el impacto que existio entre estos.
     */
    public boolean impactos(Juego externo ){
        impactos = externo.getExito().intersects(this.getExito());
        return impactos;
        
    }
    
}
