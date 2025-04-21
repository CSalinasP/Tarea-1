package org.example;

import java.util.ArrayList;

class Comprador {

    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp){

        if (m==null)
        {
            sonido = null;
            vuelto = 0;
        }

        else if (cualBebida<1 || cualBebida>2)
        {
            sonido = null;
            vuelto = m.getValor();
        }

        else
        {
            Bebida b = exp.comprarBebida(m,cualBebida);

            if (b != null)
            {
                sonido = b.beber();

                vuelto = 0;

                while (true)
                {
                    Moneda aux_vuelto = exp.getVuelto();

                    if (aux_vuelto != null)
                    {
                        vuelto = vuelto + aux_vuelto.getValor();
                    }

                    else
                    {
                        break;
                    }
                }


            }

            else
            {
                sonido = null;

                vuelto = 0;

                while (true)
                {
                    Moneda aux_vuelto = exp.getVuelto();

                    if (aux_vuelto != null)
                    {
                        vuelto = vuelto + aux_vuelto.getValor();
                    }

                    else
                    {
                        break;
                    }
                }
            }


        }





    }

    public int cuantoVuelto() //suma de la cantidad de todas las monedas de vuelto
    {
        return vuelto;

    }

    public String queBebiste() //String con el sonido de la Bebida: cocacola, sprite
    {
        return sonido;

    }

}

class Expendedor
{
    public static final int  COCA=1;
    public static final int  SPRITE=2;

    private Deposito coca;
    private Deposito sprite;
    private DepositoM monedas;
    private int precio;

    public Expendedor(int numBebidas, int precioBebidas)
    {
        coca = new Deposito();
        sprite = new Deposito();
        monedas = new DepositoM();
        precio = precioBebidas;

        for (int i=0;i<numBebidas;i++)
        {
            CocaCola c = new CocaCola(100+i);
            coca.addBebida(c);
        }

        for (int i=0;i<numBebidas;i++)
        {
            Sprite s = new Sprite(200+i);
            sprite.addBebida(s);
        }
    }

    public Bebida comprarBebida(Moneda m, int cual)
    {
        if (m == null)
        {
            return null;
        }

        Bebida aux;

        if (precio <= m.getValor())
        {
            if (cual == 1)
            {
                aux = coca.getBebida();
            }

            else if (cual == 2)
            {
                aux = sprite.getBebida();
            }

            else
            {
                int aux_valor = m.getValor();

                while (true)
                {
                    if (aux_valor > 0)
                    {
                        Moneda100 m100 = new Moneda100();
                        monedas.addMoneda(m100);

                        aux_valor = aux_valor - 100;
                    }

                    else
                    {
                        return null;
                    }
                }
            }

            if (aux != null)
            {
                int aux_valor = m.getValor();

                while (true)
                {
                    if (aux_valor > precio)
                    {
                        Moneda100 m100 = new Moneda100();
                        monedas.addMoneda(m100);

                        aux_valor = aux_valor - 100;
                    }

                    else
                    {
                        return aux;
                    }
                }
            }

            else
            {
                monedas.addMoneda(m);
                return null;
            }

        }

        else
        {
            monedas.addMoneda(m);
            return null;
        }

    }
    public Moneda getVuelto() //retorna una moneda desde el deposito de vuelto, hay que llamarla hasta que quede vacio
    {
        return monedas.getMoneda();
    }
}

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

class DepositoM
{
    private ArrayList<Moneda> depM;

    public DepositoM()
    {
        depM = new ArrayList<>();
    }

    public Moneda getMoneda()
    {
        if (depM.size() > 0)
        {
            return depM.remove(0);
        }

        else
        {
            return null;
        }

    }

    public void addMoneda(Moneda x)
    {
        if (x != null)
        {
            depM.add(x);
        }

    }
}

abstract class Bebida
{
    private int serie;

    public Bebida(int numSerie)
    {
        serie = numSerie;
    }

    public int getSerie()
    {
        return serie;
    }
    public abstract String beber();
}

class CocaCola extends Bebida
{
    public CocaCola(int numSerie)
    {
        super(numSerie);
    }

    public String beber()
    {
        return "cocacola";
    }
}

class Sprite extends Bebida
{
    public Sprite(int numSerie)
    {
        super(numSerie);
    }

    public String beber()
    {
        return "sprite";
    }
}

abstract class Moneda
{
    public Moneda()
    {

    }

    public Moneda getSerie()
    {
        return this;
    }

    public abstract int getValor();


}

class Moneda100 extends Moneda
{

    public Moneda100()
    {

    }

    public int getValor()
    {
        return 100;
    }


}

class Moneda500 extends Moneda
{

    public Moneda500()
    {

    }

    public int getValor()
    {
        return 500;
    }

}

class Moneda1000 extends Moneda
{

    public Moneda1000()
    {

    }

    public int getValor()
    {
        return 1000;
    }

}

class Moneda1500 extends Moneda
{

    public Moneda1500()
    {

    }

    public int getValor()
    {
        return 1500;
    }

}

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