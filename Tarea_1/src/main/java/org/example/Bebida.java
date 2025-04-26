package org.example;

abstract class Bebida extends Producto {
    private int serie;

    public Bebida(int numSerie)
    {
        serie = numSerie;
    }

    public int getSerie()
    {
        return serie;
    }
    public abstract String consumir();
}
