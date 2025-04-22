package org.example;

import java.util.ArrayList;

class Deposito
{
    private ArrayList<Bebida> lista;

    public Deposito()
    {
        lista = new ArrayList<>();
    }

    public Bebida getBebida()
    {
        if (lista.size() > 0)
        {
            return lista.remove(0);
        }

        else
        {
            return null;
        }

    }

    public void addBebida(Bebida b)
    {
        lista.add(b);
    }
}
