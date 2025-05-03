package org.example;
/**
 * Clase que representa una moneda particular: Moneda de 200 pesos.
 * Hereda de la clase abstracta moneda y establece como se consume.
 * @author Carlos Salinas
 */
class Moneda200 extends Moneda
{
    /**Constructor por defecto de la clase Moneda200*/
    public Moneda200() {}

    /**
     *@return 100 el valor de la moneda.
     */
    public int getValor() {
        return 200;
    }

    @Override
    public int compareTo() {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        Moneda aux = (Moneda)o;
        return Integer.compare(100,aux.getValor());
    }
}