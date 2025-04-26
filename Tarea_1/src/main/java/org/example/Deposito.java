package org.example;
import java.util.ArrayList;

public class Deposito<T> {
    private ArrayList<T> Generico;

    public Deposito() {
        Generico = new ArrayList<>();
    }

    public void add(T generico) {
        if (generico != null) {
            Generico.add(generico);
        }
    }

    public T get() {
        if (Generico.isEmpty()) {
            return null;
        } else {
            T aux = Generico.get(Generico.size() - 1);
            Generico.remove(Generico.size() - 1);
            return aux;
        }
    }
}