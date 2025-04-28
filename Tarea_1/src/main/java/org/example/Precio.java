package org.example;

public enum Precio
{
    CIEN(100),DOSCIENTOS(200), TRESCIENTOS(300), QUINIENTOS(500), MIL(1000),MIL_QUINIENTOS(1500);

    private final int valor;

    Precio(int valor)
    {
        this.valor = valor;
    }

    public int getValor()
    {
        return this.valor;
    }
}
