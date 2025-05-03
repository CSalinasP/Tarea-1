package org.example;

/**
 * Clase abstracta que representa una bebida, que es un tipo de producto.
 * Cada bebida tiene un numero de serie unico y debe establecer como se consume.
 * @author Carlos Salinas
 */
abstract class Bebida extends Producto {
    private int serie;

    /**
     * Constructor que instancia la bebida con un número de serie.
     * @param numSerie numero de serie unico de la bebida.
     */
    public Bebida(int numSerie) {
        serie = numSerie;
    }

    /**
     * Retorna el numero de serie de la bebida.
     * @return el número de serie.
     */
    public int getSerie() {
        return serie;
    }

    /**
     * Metodo abstracto que debe ser implementado por las subclases.
     * establece como se consume la bebida.
     * @return un String que depende del tipo de bebida.
     */
    public abstract String consumir();
}
