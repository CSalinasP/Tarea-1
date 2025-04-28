package org.example;

public enum Tipo
{
    COCA(1),SPRITE(2),FANTA(3),SUPER8(4),SNICKERS(5);

    private final int numero_tipo;

    Tipo(int x)
    {
        numero_tipo = x;
    }

    public int getTipo()
    {
        return numero_tipo;
    }


}
