/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.JuegoPanel;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Edward Fabian <egoyeneche at unal.edu.co 
 */
public class Marcianos extends Movimientos {
    
   

    ImageIcon marciano1 = new ImageIcon("Imagenes/Nave alien.png");
  
    ImageIcon marciano2 = new ImageIcon("Imagenes/ufo.png");
    ImageIcon marciano3 = new ImageIcon("Imagenes/space-ship.png");
    ImageIcon marcianoGrande1 = new ImageIcon("Imagenes/sillyshrek.png");
    ImageIcon marcianoGrande2 = new ImageIcon("Imagenes/feo.png");
    ImageIcon marcianoGrande3 = new ImageIcon("Imagenes/alienfeo.png");


    private int numMarciano;
    private int ancho;
    private int largo;

    /**
     * El contructor para todos los marcianos que estaran en el juego
     *
     * @param numMarciano es el numero de sera en el juego o el tipo que este
     * será.
     * @param ancho dimesiones que el marciano tendra.
     * @param largo dimenciones que el marciano tendrá.
     * @param movimientoX movimeinto de los marcianos en el eje horizontal.
     * @param movimientoY movimiento de los marcianos en el eje vertical.
     * @param x la posicion que este tiene en el eje horizontal.
     * @param y la posicionq que este .
     * @param colores Color natutal que los marcianitos tendran la moverse.
     */
    public Marcianos(int numMarciano, int ancho, int largo, int movimientoX, int movimientoY, int x, int y, Color colores) {
        super(movimientoX, movimientoY, x, y, colores);
        this.numMarciano = numMarciano;
        this.ancho = ancho;
        this.largo = largo;
    }
    /**
     * Dibuja o pinta los marcianos en el juego para su ejecucion muestra las
     * distintos marcianos que hay, y de igual manera muestra los marcianos mar
     * grandes .
     *
     * @param g parametro para pintar el objeto
     */
    @Override
    
    

    
    
    

    public void pintarJuego(Graphics g) {
        // Ubica y crea la imagen o dibuja el Marciano  1  Imagenes/Nave alien.png
        if (this.numMarciano % 3 == 0) {
            marciano1.paintIcon(null, g, this.getX(), getY());
            //Ubica y crea la imagen o dibuja el  Marciano 1  Imagenes/misil.png

        } else if (this.numMarciano % 3 == 1 && this.numMarciano != 100) {
            marciano2.paintIcon(null, g, this.getX(), this.getY());

        } else if (this.numMarciano % 3 == 2) {
            marciano3.paintIcon(null, g, this.getX(), this.getY());
        }
        // ubica y crea los marcianos grandes los cuales iran cambiando con la 
        if (this.numMarciano == 100) {
            if (JuegoPanel.getvidaMarcianosGrandes() > 20) {
                marcianoGrande1.paintIcon(null, g, this.getX(), this.getY());
            } else if (JuegoPanel.getvidaMarcianosGrandes() > 10) {
                marcianoGrande2.paintIcon(null, g, this.getX(), this.getY());
            } else if (JuegoPanel.getvidaMarcianosGrandes() > 0) {
                marcianoGrande2.paintIcon(null, g, this.getX(), this.getY());
            }

        }
}
    
    
    /**
     *  Muestra y verifica que se realizo el impacto del disparo de lo marcianos a la nave objetivo.
     * @return  returna el disparo que  los  marcianos  impactaron con la nave
     */

    @Override
public Rectangle getExito() {
        Rectangle disparomarciano = new Rectangle(this.getX(), this.getY(), 50, 50);
        return disparomarciano;
    }
    
    /**
     * Redefine los movimientos de los marcianos en este caso en el eje horizal
     */
    @Override
public void movimiento() {
        xpos += movimientoX;
    }

}
