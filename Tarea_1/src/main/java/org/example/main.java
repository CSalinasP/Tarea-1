package org.example;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(3,Precio.CIEN,Precio.DOSCIENTOS,Precio.TRESCIENTOS,Precio.QUINIENTOS,Precio.MIL);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda500();
        try {
            c = new Comprador(m,Tipo.COCA, exp);
        } catch (Exepciones e) {
            throw new RuntimeException(e);
        }
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        try {
            c = new Comprador(m,Tipo.SPRITE,exp);
        } catch (Exepciones e) {
            throw new RuntimeException(e);
        }
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        m = new Moneda500();
        try {
            c = new Comprador(m,Tipo.FANTA,exp);
        } catch (Exepciones e) {
            throw new RuntimeException(e);
        }
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        m = new Moneda1500();
        try {
            c = new Comprador(m,Tipo.SUPER8,exp);
        } catch (Exepciones e) {
            throw new RuntimeException(e);
        }
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
        m = new Moneda1500();
        try {
            c = new Comprador(m,Tipo.SNICKERS,exp);
        } catch (Exepciones e) {
            throw new RuntimeException(e);
        }
        System.out.println(c.queConsumiste()+", "+c.cuantoVuelto());
    }
}