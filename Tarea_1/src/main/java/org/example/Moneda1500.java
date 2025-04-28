package org.example;

class Moneda1500 extends Moneda
{

    public Moneda1500()
    {

    }

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
