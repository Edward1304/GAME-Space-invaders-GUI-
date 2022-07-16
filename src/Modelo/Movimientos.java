    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import java.awt.Color;
import Modelo.InterfazJuego;
import Modelo.Juego;

/**
 *
 * @author Edward Fabian <egoyeneche at unal.edu.co
 * @author Alejandra Jaramillo <aljaramillo at unal.edu.co
 * 
 * 
 */

public abstract class Movimientos extends Juego implements interfazMovimientoJuego{
    int movimientoX;
    int movimientoY;
    /**
     * Constructor que le dará  el movimientos a los objeto en el juego
     * para su distinto funcionamiento
     * @param movimientoX  movimiento de los objetos en el  eje horizontal.
     * @param movimientoY  movimiento de los objetos en el eje Vertical.
     * @param x  posicion  en el eje  horizontal.
     * @param y  posicion en el eje vertical
     * @param colores  le da colora al movimiento de los objetos.
     */
    public Movimientos(int movimientoX, int movimientoY, int x, int y, Color colores) {
        super(x, y, colores);
        this.movimientoX = movimientoX;
        this.movimientoY = movimientoY;
    }

    public int getMovimientoX() {
        return movimientoX;
    }

    public void setMovimientoX(int movimientoX) {
        this.movimientoX = movimientoX;
    }

    public int getMovimientoY() {
        return movimientoY;
    }
    
    public void setMovimientoY(int movimientoY) {
        this.movimientoY = movimientoY;
    }
    /**
     *Lama los parametros  de posicion /xpos y ypos/ de la clase
     *juego y lo suma con los movimientos de este.
     */
    @Override
    public void movimiento() {
        this.xpos += movimientoX;
        this.ypos += movimientoY;

    }
    
    
    
    

}
