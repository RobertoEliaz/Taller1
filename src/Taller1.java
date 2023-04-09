import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

public class Taller1 {
    static double posicionX = 0;
    static double posicionY = 0;
    static double posicionX_1 = 0;
    static double posicionY_1 = 0;
    static double velocidadX = 0;
    static double velocidadY = 0;
    static double velocidadX_1 = 0;
    static double velocidadY_1 = 0;

    public static void main(String[] args) {

        configurarAmbiente();
        establecerPosicionAleatoria();
        establecerVelocidades();

        establecerLineas();

        StdDraw.show();

        while (true) {
            if (Math.abs(posicionX + velocidadX) > 1.2) {
                velocidadX = -velocidadX;
            }

            if (Math.abs(posicionY + velocidadY) > 1.2) {
                velocidadY = -velocidadY;
            }

            if (Math.abs(posicionX_1 + velocidadX_1) > 1.2) {
                velocidadX_1 = -velocidadX_1;
            }

            if (Math.abs(posicionY_1 + velocidadY_1) > 1.2) {
                velocidadY_1 = -velocidadY_1;
            }

            StdDraw.clear();

            actualizarPosicion();
            establecerLineas();
            StdDraw.show();

        }

    }

    /**
     * Esta función actualiza las posicion
     */

    public static void actualizarPosicion() {

        posicionX = posicionX + velocidadX;
        posicionY = posicionY + velocidadY;
        posicionX_1 = posicionX_1 + velocidadX_1;
        posicionY_1 = posicionY_1 + velocidadY_1;

    }

    /**
     * Esta función establece las lineas a base de la linea principal
     */

    public static void establecerLineas() {

        StdDraw.setPenColor(Color.YELLOW);
        StdDraw.line(posicionX, posicionY, posicionX_1, posicionY_1);

        double descuento = 0;
        int limite = 0;

        while (limite < 6) {

            descuento = descuento - 0.01;

            double y = posicionY - descuento;
            double y_2 = posicionY_1 - descuento;

            setearColor(limite);
            StdDraw.line(posicionX, y, posicionX_1, y_2);


            limite = limite + 1;
        }

    }

    /**
     * Esta función establece los colores relacionandolos con cada linea
     */

    public static void setearColor(int i) {
        if (i == 0) {
            StdDraw.setPenColor(Color.RED);
        } else if (i == 1) {
            StdDraw.setPenColor(Color.BLACK);
        } else if (i == 2) {
            StdDraw.setPenColor(Color.CYAN);
        } else if (i == 3) {
            StdDraw.setPenColor(Color.MAGENTA);
        } else if (i == 4) {
            StdDraw.setPenColor(Color.GREEN);
        } else {
            StdDraw.setPenColor(Color.PINK);
        }

    }

    /**
     * Está función configura el ambiente donde se moverán las lineas
     */

    public static void configurarAmbiente() {

        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(-1.2, 1.2);
        StdDraw.setYscale(-1.2, 1.2);

    }

    /**
     * Está función establece las posicion aleatoria de la linea principal
     */

    public static void establecerPosicionAleatoria() {

        double min = -1.0;
        double max = 1.0;

        posicionX = Math.random() * (max - min) + min;
        posicionY = Math.random() * (max - min) + min;
        posicionX_1 = Math.random() * (max - min) + min;
        posicionY_1 = Math.random() * (max - min) + min;

        establecerLineas();

    }

    /**
     * Esta función establece velocidades aleatorias
     */

    public static void establecerVelocidades() {

        double min = 0.002;
        double max = 0.006;

        double velocidad = Math.random() * (max - min) + min;

        velocidadX = velocidad;
        velocidadY = velocidad;
        velocidadX_1 = velocidad;
        velocidadY_1 = velocidad;

    }
}
