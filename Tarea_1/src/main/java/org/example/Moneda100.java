package org.example;

class Moneda100 extends Moneda
{

    public Moneda100()
    {

    }

    public int getValor()
    {
        return 100;
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