package org.example;

class Moneda500 extends Moneda
{

    public Moneda500()
    {

    }

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
