package org.example;

public enum Enumeracion {
    //Constantes para los identificadores de los productos
    COCACOLA(1),
    SPRITE(2),
    FANTA(3),
    SNICKER(4),
    SUPER8(5),

    //Constantes para los precios de los productos
    P1(1500),
    P2(1000),
    P3(500),
    P4(100);

    private final int Tipo;

    Enumeracion(int Tipo){this.Tipo = Tipo;}

    public int getTipo() {
        return Tipo;
    }
}
