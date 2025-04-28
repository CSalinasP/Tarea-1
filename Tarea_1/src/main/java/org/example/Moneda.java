package org.example;

abstract class Moneda implements Comparable
{
    public Moneda()
    {

    }

    public Moneda getSerie()
    {
        return this;
    }

    abstract public int getValor();

    public abstract int compareTo();
}