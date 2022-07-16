/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Marcianos;
import Modelo.Jugador;
import Modelo.DisparoMarcianos1;
import Modelo.DisparoJugador;
import Controlador.controlTeclado;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Edward Fabian <egoyeneche at unal.edu.co 
 * @author Alejandra Jaramillo<aljaramillo at unal.edu.co
 */
public class JuegoPanel extends JPanel {

    private Timer tiempoJuego;
    private controlTeclado controlador;
    private final int anchoJuego = 800;
    private final int alturaJuego = 600;
    private final int tiempo = 120;

    // contadores
    Random random = new Random();
    private int puntuacion = 0;
    private int nivel = 1;
    private int numeroVidas = 5;
    private int puntuacionMasAlta; // archivo de la puntuacion mas alta
    private int marcadorX, marcadorY;
    private static int vidaMarcianosGrandes = 20;
    File f = new File("puntuacionMasAlta..txt");

    // objetos
    private Jugador naveJugador;
    private Jugador vidaUnica;
    private Jugador puntosMarcianos;

    private Marcianos marciano;
    private DisparoJugador disparoJugador;
    private DisparoMarcianos1 disparo1, disparo2, disparo3;

    // valores booleanos que tendra  como proposito  verificar  accciones
    private boolean balaJugadorActivada = true;
    private boolean balaMarcianoActivada = true;
    private boolean ChocadorMarcador = false;

    // listas donde de almacenaran los atributos u cosas de los obejtos
    private ArrayList<Jugador> listaVidas = new ArrayList();
    private ArrayList<Jugador> listaPuntosMarcianos = new ArrayList();
    private ArrayList<Marcianos> listaMarcianos = new ArrayList();
    private ArrayList<DisparoMarcianos1> listaDisparosMarcianos = new ArrayList();
    private ImageIcon fondo = new ImageIcon("Imagenes/fondo.jpg");  // IMAGEN FONDO

    /**
     * obtiene la vida de los marcianos grandes los cuales iran cambiando cada
     * vez que existan un impacto contra ellos
     *
     * @return la vida disminuyen del marciano grande
     */
    public static int getvidaMarcianosGrandes() {
        return vidaMarcianosGrandes;
    }

    /**
     * crea la estructura del juego como el tamaño del arreglo de las filas y
     * columas de los marcianos y toma como nivel uno la vetana del juego done
     * aprecen las instruciones del juego
     */
    public final void estructuraJuego() {

        // Crea los marcianos para los niveles donde no apareceran los marcianos grandes
        //tendrán un arreglo de filas  y columas
        if (nivel != 3 && nivel != 6 && nivel != 9 && nivel != 12) {
            //Tiene 7 filas de marcianos
            for (int filas = 0; filas < 7; filas++) {
                // Tiene 7 colomnas de marcianos
                for (int columnas = 0; columnas < 7; columnas++) {
                    marciano = new Marcianos(columnas, 40, 40, nivel, 0, (20 + (filas * 100)), (20 + (columnas * 60)), null);
                    listaMarcianos.add(marciano);
                }
            }
        }

        //Crea los marcianos mas grandes  en los niveles que apreceran estos 
        if (nivel == 3 || nivel == 6 || nivel == 9 || nivel == 12) {
            marciano = new Marcianos(100, 150, 150, 3, 0, 20, 20, null);
            listaMarcianos.add(marciano);

        }
        // muestra una  ventana principal donde  se dara las instruciones de juego
        if (nivel == 1) {
            JOptionPane.showMessageDialog(null, "Bienvenidos a este maravilloso juego SpiceInvaders!"
                    + "\n                            CONTROLES DE JUEGO                                    "
                    + "\n- Tecla izquierda( ← ) Mover izquierda  || Tecla Derecha ( → ) Mover izquierda"
                    + "\n- Tecla Espacio ( ___ ) Disparar"
                    + "\n- Los Marcianitos son mas Rapidos mientras se pasa de nivel"
                    + "\n- Marcianos grandes en nivel 3-6-9 "
                    + "\n-  AJUAAA A DEFENDER EL PLANETA!"
                    + "\n- --------------------------------------------------------------------------------------------------------------------"
                    + "\n-  Desarrollado por :"
                    + "\n- Edward Fabian Goyeneche Velandia"
                    + "\n- Alejandra Jaramillo Mejia!"
                    + "\n-  Docente: "
                    + "\n-  PhD. Simon Orozco Arias"
                    + "\n- Asignatura: "
                    + "\n-  Programacion Orientada a Objetos (POO)");

        }

        // reestablecer el movimiento del controlador
        controlador.reinciar();

        naveJugador = new Jugador(controlador, 375, 550, null);

        // muestra las vida del jugador y la resta a la lista de vidas
        for (int posicion = 0; posicion < numeroVidas; posicion++) {
            vidaUnica = new Jugador(null, 48 + (posicion * 20), 10, Color.WHITE);
            listaVidas.add(vidaUnica);

        }

    }

    /**
     * Metodo de construccion grafico de los elementos que tiene dimencioes o
     * estan asociados a este.
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        fondo.paintIcon(null, g, 0, -150);

        // Crea el texto que se mostrará cuando los Marcianos sean imapctados por e 
        // disparo de la nave.
        if (disparoJugador != null) {
            if (ChocadorMarcador) {
                g.setColor(Color.GREEN);
                if (nivel != 3 && nivel != 6 && nivel != 9 && nivel != 12) {
                    g.drawString("+ 100", marcadorX + 20, marcadorY -= 1);
                } else {
                    g.drawString("- 1", marcadorX + 75, marcadorY += 1);

                }
            }
        }
        //dibujar Nave 
        naveJugador.pintarJuego(g);

        // dibuje los 2 tipos de aliens
        try {
            for (int i = 0; i < listaMarcianos.size(); i++) {
                listaMarcianos.get(i).pintarJuego(g);
            }

        } catch (IndexOutOfBoundsException e) {

        } catch (NullPointerException e) {

        }

        // dibujar un disparo de la nave cuando se oprime la tecla espacio
        if (controlador.getEstado(32)) {

            if (balaJugadorActivada) {
                disparoJugador = new DisparoJugador(naveJugador.getX() + 22, naveJugador.getY() - 20, 0, Color.GREEN);

                balaJugadorActivada = false;
            }
        }

        if (disparoJugador != null) {
            disparoJugador.pintarJuego(g);
        }

        // genera disparos  aleatorias de los marcianos
        if (nivel != 3 && nivel != 6 && nivel != 9 && nivel != 12) {
            if (balaMarcianoActivada) {
                try {
                    for (int j = 0; j < listaMarcianos.size(); j++) {
                        if (random.nextInt(30) == j) {
                            disparo1 = new DisparoMarcianos1(listaMarcianos.get(j).getX(), listaMarcianos.get(j).getY(), 0, Color.PINK);
                            listaDisparosMarcianos.add(disparo1);

                        }
                        balaMarcianoActivada = false;
                    }
                } catch (IndexOutOfBoundsException e) {

                } catch (NullPointerException e) {

                }
            }
        }
        // Genera disparos  mas rapidos de los marcianos.
        if (nivel == 3 || nivel == 6 || nivel == 9 || nivel == 12) {
            if (balaMarcianoActivada) {

                for (int k = 0; k < listaMarcianos.size(); k++) {
                    //listaDisparosMarcianos.get(k).pintarJuego(g);
                    if (random.nextInt(5) == k) {
                        disparo1 = new DisparoMarcianos1(listaMarcianos.get(k).getX() + 75, listaMarcianos.get(k).getY() + 140, 0, Color.YELLOW);
                        disparo2 = new DisparoMarcianos1(listaMarcianos.get(k).getX(), listaMarcianos.get(k).getY() + 110, 0, Color.BLUE);
                        disparo3 = new DisparoMarcianos1(listaMarcianos.get(k).getX() + 150, listaMarcianos.get(k).getY() + 110, 0, Color.RED);
                        listaDisparosMarcianos.add(disparo1);
                        listaDisparosMarcianos.add(disparo2);
                        listaDisparosMarcianos.add(disparo3);
                    }
                    balaMarcianoActivada = false;
                }
            }
        }

        try {

            for (int p = 0; p < listaDisparosMarcianos.size(); p++) {
                listaDisparosMarcianos.get(p).pintarJuego(g);
            }

        } catch (IndexOutOfBoundsException e) {
        } catch (NullPointerException e) {

        }

        g.setColor(Color.RED);
        g.drawString("Puntaje: " + puntuacion, 260 , 20);

        g.setColor(Color.YELLOW);
        g.drawString("VIDAS:", 11, 20);
        for (int i = 0; i < listaVidas.size(); i++) {
            listaVidas.get(i).verVida(g);
        }

        g.setColor(Color.GREEN);
        g.drawString("NIVEL " + nivel, 750, 20);

        g.setColor(Color.BLUE);
        g.drawString("puntuacion mas alta: " + puntuacionMasAlta, 440, 20);
        if (nivel == 3 || nivel == 6 || nivel == 9 || nivel == 12) {
            g.setColor(Color.red);
            g.drawString(" SALUD MARCIANO" + vidaMarcianosGrandes, 356, 600);
        }

    }

    /**
     * Carga y ejecuta el juego con todos los otro elementos que no corresponden
     * a las acciones graficas , si no las interacciones de los objetos y
     * tambien la ejecucion del juego accionando la puntacion y añadiendo a las
     * lista asumidas a esto elementos.
     *
     * @param numeroTiempo
     */
    public void ejecutarJuego(int numeroTiempo) {
        naveJugador.movimiento();

        // actualizar datos de puntacion  en el archivo que se creó.
        try {
            Scanner fileScan = new Scanner(f);
            while (fileScan.hasNextInt()) {
                String nextLine = fileScan.nextLine();
                Scanner lineScan = new Scanner(nextLine);
                puntuacionMasAlta = lineScan.nextInt();
            }
        } catch (FileNotFoundException e) {
        }


        try {
            if (puntuacion > puntuacionMasAlta) {
                String puntacionString = Integer.toString(puntuacion);
                PrintWriter punto = new PrintWriter(new FileOutputStream(f, false));
                punto.write(puntacionString);
                punto.close();
            }
        } catch (FileNotFoundException e) {
        }
        // mover los marcianos y que cuando choquen se devuelvan 

        if ((listaMarcianos.get(listaMarcianos.size() - 1).getX() + listaMarcianos.get(listaMarcianos.size() - 1).getMovimientoX()) > 760 || (listaMarcianos.get(0).getX() + listaMarcianos.get(0).getMovimientoX()) < 0) {
            try {
                for (int i = 0; i < listaMarcianos.size(); i++) {
                    listaMarcianos.get(i).setMovimientoX(listaMarcianos.get(i).getMovimientoX() * -1);
                    listaMarcianos.get(i).setY(listaMarcianos.get(i).getY() + 10);
                }
            } catch (IndexOutOfBoundsException e) {

            } catch (NullPointerException e) {

            }

        } else {
            try {
                for (int j = 0; j < listaMarcianos.size(); j++) {
                    listaMarcianos.get(j).movimiento();
                }

            } catch (IndexOutOfBoundsException e) {

            } catch (NullPointerException e) {

            }

        }

        //  movimiento disparos del  jugador (Nave)
        if (disparoJugador != null) {
            disparoJugador.setY(disparoJugador.getY() - 15);
            if (disparoJugador.getY() < 0) {
                balaJugadorActivada = true;
            }

            // impactos entre marcianos y  nave
            for (int k = 0; k < listaMarcianos.size(); k++) {
                if (disparoJugador.impactos(listaMarcianos.get(k))) {

                    disparoJugador = new DisparoJugador(0, 0, 0, null);

                    balaJugadorActivada = true;
                    // muestra y carga los puntos para niveles
                    if (nivel != 3 && nivel != 6 && nivel != 9 && nivel != 12) {
                        puntuacion += 100;
                        ChocadorMarcador = true;
                        marcadorX = listaMarcianos.get(k).getX();
                        marcadorY = listaMarcianos.get(k).getY();
                        listaMarcianos.remove(k);
                    }
                    if (nivel == 3 || nivel == 6 || nivel == 9 || nivel == 12) {
                        ChocadorMarcador = true;
                        marcadorX = listaMarcianos.get(k).getX();
                        marcadorY = listaMarcianos.get(k).getY() + 165;
                        vidaMarcianosGrandes -= 1;
                        if (vidaMarcianosGrandes == 0) {
                            listaMarcianos.remove(k);
                            puntuacion += 9000;

                        }

                    }

                }
            }
        }

        //disparos de los marcianos para nivel donde no  estan los grandes
        if (nivel != 3 && nivel != 6 && nivel != 9 && nivel != 12) {
            if (disparo1 != null) {
                try {
                    for (int i = 0; i < listaDisparosMarcianos.size(); i++) {
                        listaDisparosMarcianos.get(i).setY(listaDisparosMarcianos.get(i).getY() + (4));
                        if (listaDisparosMarcianos.get(i).getY() > 800) {
                            listaDisparosMarcianos.remove(i);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {

                } catch (NullPointerException e) {

                }

            }
        }
        //disparos de los marcianos para nivel donde estan los marcianos grandes
        if (nivel == 3 || nivel == 6 || nivel == 9 || nivel == 12) {
            if (disparo1 != null) {
                try {
                    for (int j = 0; j < listaDisparosMarcianos.size(); j++) {
                        listaDisparosMarcianos.get(j).setY(listaDisparosMarcianos.get(j).getY() + (2 * nivel));
                        if (listaDisparosMarcianos.get(j).getY() > 800) {
                            listaDisparosMarcianos.remove(j);
                        }

                    }
                } catch (IndexOutOfBoundsException e) {

                } catch (NullPointerException e) {

                }
            }
        }

        try {
            for (int k = 0; k < listaDisparosMarcianos.size(); k++) {
                if (listaDisparosMarcianos.get(k).impactos(naveJugador)) {
                    listaDisparosMarcianos.remove(k);

                    listaVidas.remove(listaVidas.size() - 1);
                }
            }
        } catch (IndexOutOfBoundsException e) {

        } catch (NullPointerException e) {

        }

        if (listaDisparosMarcianos.isEmpty()) {
            balaMarcianoActivada = true;
        }

        if (naveJugador.impactos(marciano)) {
            int i = listaVidas.size() - 1;
            listaVidas.remove(i);
        } else if (listaVidas.isEmpty()) {

            int opcion = JOptionPane.showConfirmDialog(null, "JUEGO PERDIDO, NOS HAN INVADIDO ¿DESEA VOLVER A JUGAR?", "Total puntos: " + puntuacion + " puntos", 0);

            if (opcion == 0) {
                listaVidas.clear();
                listaMarcianos.clear();

                listaDisparosMarcianos.clear();

                puntuacion = 0;
                nivel = 1;
                vidaMarcianosGrandes = 30;

                numeroVidas = 3;
                balaJugadorActivada = true;
                balaMarcianoActivada = true;

                estructuraJuego();
            }

            if (opcion == 1) {
                System.exit(0);
            }
        }

        if (listaMarcianos.isEmpty()) {
            listaDisparosMarcianos.clear();
            listaVidas.clear();
            nivel += 1;
            vidaMarcianosGrandes = 30;

            estructuraJuego();

        }

    }

    public JuegoPanel() {
        this.setSize(anchoJuego, alturaJuego);
        this.setPreferredSize(new Dimension(anchoJuego, alturaJuego));
        this.setBackground(Color.BLACK);

        controlador = new controlTeclado();
        this.addKeyListener(controlador);

        this.estructuraJuego();
        this.setFocusable(true);
        this.requestFocusInWindow();

    }

    /**
     * Marca la ejecucion del programa y las acciones del teclado y los ejecuta
     * para su funcionar.
     */
    public void start() {
        tiempoJuego = new Timer(1000 / tiempo, new ActionListener() {

            private int numeroTiempo = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarJuego(numeroTiempo++);
                repaint();

            }

        });
        Timer marcadorTiempoJuego = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChocadorMarcador = false;

            }
        });

        tiempoJuego.setRepeats(true);
        tiempoJuego.start();
        marcadorTiempoJuego.setRepeats(true);
        marcadorTiempoJuego.start();

    }

}
