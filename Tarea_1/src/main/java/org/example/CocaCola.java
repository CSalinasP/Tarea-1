package org.example;

/**
 * Clase que representa una bebida particular: CocaCola.
 * Hereda de la clase abstracta bebida y establece como se consume.
 * @author Carlos Salinas
 */
class CocaCola extends Bebida {

    /**
     * Constructor que crea una CocaCola con un numero de serie dado.
     *@param numSerie numero de serie unico de la CocaCola.
     */
    public CocaCola(int numSerie) {
        super(numSerie);
    }

    /**
     * Retorna el numero de serie de la bebida.
     * @return el número de serie.
     */
    public int getSerie() {
        return super.getSerie();
    }
    /**
     * Describe cómo se consume la CocaCola.
     * @return un String que  representa la accion de consumir la CocaCola".
     */
    @Override
    public String consumir() {
        return "cocacola";
    }
}
