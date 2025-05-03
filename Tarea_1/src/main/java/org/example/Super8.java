package org.example;

/**
 * Clase que representa un tipo de dulce particular: Super8.
 * Hereda de la clase abstracta Dulce y establece como se consume.
 * @author Carlos Salinas
 */
class Super8 extends Dulce {

    /**
     * Constructor que crea una Super8 con un numero de serie dado.
     *@param numSerie numero de serie unico del Super8.
     */
    public Super8(int numSerie) {
        super(numSerie);
    }

    /**
     * Retorna el numero de serie del Super8.
     * @return el número de serie.
     */
    public int getSerie() {
        return super.getSerie();
    }

    /**
     * Describe cómo se consume el Super8.
     * @return un String que  representa la accion de consumir el Super8".
     */
    public String consumir() {
        return "super8";
    }
}
