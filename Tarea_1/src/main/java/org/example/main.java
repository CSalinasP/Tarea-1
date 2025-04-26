package org.example;

import java.util.ArrayList;

public class main {
    public static void main(String[] args)
    {
        Expendedor exp = new Expendedor(3,300);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda500();
        c = new Comprador(m,1,exp);
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,2,exp);
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,3,exp);
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        m = new Moneda1500();
        c = new Comprador(m,4,exp);
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,5,exp);
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());













    }
}