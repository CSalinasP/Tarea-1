package org.example;

import java.util.ArrayList;

class Deposito
{
    private ArrayList<Producto> lista;

    public Deposito()
    {
        lista = new ArrayList<>();
    }

    public Producto getProducto()
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

    public void addProducto(Producto b)
    {
        lista.add(b);
    }
}
