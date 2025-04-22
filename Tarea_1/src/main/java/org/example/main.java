package org.example;

import java.util.ArrayList;

public class main {
    public static void main(String[] args)
    {

        Expendedor exp = new Expendedor(3,300);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda500();
        c = new Comprador(m,661,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        c = new Comprador(m,661,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,661,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());













    }
}