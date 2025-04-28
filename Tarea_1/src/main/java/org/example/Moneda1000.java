package org.example;

class Moneda1000 extends Moneda
{

    public Moneda1000()
    {

    }

    public int getValor()
    {
        return 1000;
    }

    @Override
    public int compareTo() {
        return 0;
    }


    @Override
    public int compareTo(Object o) {
        Moneda aux = (Moneda)o;
        return Integer.compare(1000,aux.getValor());
    }

}
