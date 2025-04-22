package org.example;

abstract class Dulce
{
    private int serie;

    public Dulce(int numSerie)
    {
        serie = numSerie;
    }

    public int getSerie()
    {
        return serie;
    }

    public abstract String comer();
}
