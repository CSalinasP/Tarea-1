package org.example;

/**
 * Clase abstracta que representa una moneda y que implementa la interfaz Comparable
 * @author Carlos Salinas
 */
abstract class Moneda implements Comparable {
    /**Constructor por defecto de la superclase Moneda*/
    public Moneda() {}

    /**
     * Retorna el numero de serie de la bebida.
     * @return la instancia del objeto actual.
     */
    public Moneda getSerie() {
        return this;
    }

    /**
     * Metodo abstracto que retorna el valor de la moneda.
     * @return un numero entero que corresponde al valor de la moneda.
     */
    abstract public int getValor();

    /**
     * Metodo abstracto cuyo proposito aun no se define
     */
    public abstract int compareTo();
}