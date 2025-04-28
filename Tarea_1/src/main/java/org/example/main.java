package org.example;

import java.util.ArrayList;

public class main {
    public static void main(String[] args)
    {

        Expendedor exp = new Expendedor(3,Precio.CIEN,Precio.DOSCIENTOS,Precio.TRESCIENTOS,Precio.QUINIENTOS,Precio.MIL);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda500();
        c = new Comprador(m,Tipo.COCA, exp);
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,Tipo.SPRITE,exp);
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        c = new Comprador(m,Tipo.FANTA,exp);
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        m = new Moneda1500();
        c = new Comprador(m,Tipo.SUPER8,exp);
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        m = new Moneda1500();
        c = new Comprador(m,Tipo.SNICKERS,exp);
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());













    }
}