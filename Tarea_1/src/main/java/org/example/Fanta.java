package org.example;

/**
 * Clase que representa una bebida particular: Fanta.
 * Hereda de la clase abstracta bebida y establece como se consume.
 * @author Carlos Salinas
 */
class Fanta extends Bebida {

    /**
     * Constructor que crea una Fanta con un numero de serie dado.
     *@param numSerie numero de serie unico de la Fanta.
     */
    public Fanta(int numSerie) {
        super(numSerie);
    }

    /**
     * Describe cómo se consume la Fanta.
     * @return un String que  representa la accion de consumir la Fanta".
     */
    public String consumir() {
        return "fanta";
    }
}
