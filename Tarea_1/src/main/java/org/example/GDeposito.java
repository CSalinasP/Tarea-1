package org.example;
import java.util.ArrayList;

public class GDeposito<E> {
    private ArrayList<E> Generico;

    public GDeposito() {
        Generico = new ArrayList<>();
    }

    public void add(E generico) {
        if (generico != null) {
            Generico.add(generico);
        }
    }

    public E get() {
        if (Generico.isEmpty()) {
            return null;
        } else {
            E aux = Generico.get(Generico.size() - 1);
            Generico.remove(Generico.size() - 1);
            return aux;
        }
    }
}