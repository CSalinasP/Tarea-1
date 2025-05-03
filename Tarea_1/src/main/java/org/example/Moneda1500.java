package org.example;

/**
 * Clase que representa una moneda particular: Moneda de 1500 pesos.
 * Hereda de la clase abstracta moneda y establece como se consume.
 * @author Carlos Salinas
 */
class Moneda1500 extends Moneda
{

    /**Constructor por defecto de la clase Moneda1500*/
    public Moneda1500()
    {}

    /**
     *@return 1500 el valor de la moneda.
     */
    public int getValor()
    {
        return 1500;
    }

    @Override
    public int compareTo() {
        return 0;
    }


    @Override
    public int compareTo(Object o) {
        Moneda aux = (Moneda)o;
        return Integer.compare(1500,aux.getValor());
    }

}
