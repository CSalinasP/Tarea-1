package org.example;

/**
 * Clase que representa un tipo de dulce particular: Snicker.
 * Hereda de la clase abstracta Dulce y establece como se consume.
 * @author Carlos Salinas
 */
class Snickers extends Dulce {

    /**
     * Constructor que crea una Snicker con un numero de serie dado.
     *@param numSerie numero de serie unico del Snicker.
     */
    public Snickers(int numSerie) {
        super(numSerie);
    }

    /**
     * Describe cómo se consume el Snicker.
     * @return un String que  representa la accion de consumir el Snicker".
     */
    public String consumir() {
        return "snickers";
    }
}
