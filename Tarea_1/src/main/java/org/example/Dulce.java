package org.example;

/**
 * Clase abstracta que representa un dulce, que es un tipo de producto.
 * Cada dulce tiene un numero de serie unico y debe establecer como se consume.
 * @author Carlos Salinas
 */
abstract class Dulce extends Producto {
    private int serie;

    /**
     * Constructor que inicializa el dulce con un número de serie.
     * @param numSerie numero de serie unico del dulce.
     */
    public Dulce(int numSerie) {
        serie = numSerie;
    }

    /**
     * Retorna el numero de serie del dulce.
     * @return el número de serie.
     */
    public int getSerie() {
        return serie;
    }

    /**
     * Metodo abstracto que debe ser implementado por las subclases.
     * establece como se consume el dulce.
     * @return un String que depende del tipo de dulce.
     */
    public abstract String consumir();
}
