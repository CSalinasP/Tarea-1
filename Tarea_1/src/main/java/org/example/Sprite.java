package org.example;

/**
 * Clase que representa una bebida particular: Sprite.
 * Hereda de la clase abstracta bebida y establece como se consume.
 * @author Carlos Salinas
 */
class Sprite extends Bebida {

    /**
     * Constructor que crea una Sprite con un numero de serie dado.
     *@param numSerie numero de serie unico de la Sprite..
     */
    public Sprite(int numSerie) {
        super(numSerie);
    }

    /**
     * Describe cómo se consume la Sprite.
     * @return un String que  representa la accion de consumir la Sprite".
     */
    public String consumir() {
        return "sprite";
    }
}