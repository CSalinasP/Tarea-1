package org.example;

/**
 * Clase que representa una moneda particular: Moneda de 500 pesos.
 * Hereda de la clase abstracta moneda y establece como se consume.
 * @author Carlos Salinas
 */
class Moneda500 extends Moneda
{
    /**Constructor por defecto de la clase Moneda500*/
    public Moneda500()
    {

    }

    /**
     * Retorna el numero de serie de la Moneda.
     * @return la instancia del objeto actual.
     */
    public Moneda getSerie() {
        return this;
    }

    /**
     *@return 500 el valor de la moneda.
     */
    public int getValor()
    {
        return 500;
    }

    @Override
    public int compareTo() {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        Moneda aux = (Moneda)o;
        return Integer.compare(500,aux.getValor());
    }

}
