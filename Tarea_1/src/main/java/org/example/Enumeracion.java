package org.example;

public enum Enumeracion {
    COCACOLA(1),
    SPRITE(2),
    FANTA(3),
    SNICKER(4),
    SUPER8(5);

    private final int Tipo;

    Enumeracion(int Tipo){
        this.Tipo = Tipo;
    }

    public int getTipo() {
        return Tipo;
    }
}
