package org.example;

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
                aux = (Bebida)coca.getBebida();
            }

            else if (cual == 2)
            {
                aux = (Bebida)sprite.getBebida();
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