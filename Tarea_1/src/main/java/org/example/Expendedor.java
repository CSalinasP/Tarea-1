package org.example;

class Expendedor
{
    public static final int  COCA=1;
    public static final int  SPRITE=2;
    public static final int  FANTA=3;
    public static final int  SUPER8=4;
    public static final int  SNICKERS=5;

    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private Deposito super8;
    private Deposito snickers;
    private DepositoM monedas;
    private int precio;

    public Expendedor(int numProductos, int precioProductos)
    {
        coca = new Deposito();
        sprite = new Deposito();
        fanta = new Deposito();
        super8 = new Deposito();
        snickers = new Deposito();
        monedas = new DepositoM();
        precio = precioProductos;

        for (int i=0;i<numProductos;i++)
        {
            CocaCola c = new CocaCola(100+i);
            coca.addProducto(c);
        }

        for (int i=0;i<numProductos;i++)
        {
            Sprite s = new Sprite(200+i);
            sprite.addProducto(s);
        }

        for (int i=0;i<numProductos;i++)
        {
            Fanta s = new Fanta(300+i);
            fanta.addProducto(s);
        }

        for (int i=0;i<numProductos;i++)
        {
            Super8 s = new Super8(400+i);
            super8.addProducto(s);
        }

        for (int i=0;i<numProductos;i++)
        {
            Snickers s = new Snickers(500+i);
            snickers.addProducto(s);
        }
    }

    public Producto comprarProducto(Moneda m, int cual)
    {
        if (m == null)
        {
            return null;
        }

        Producto aux;

        if (precio <= m.getValor())
        {
            if (cual == 1)
            {
                aux = coca.getProducto();
            }

            else if (cual == 2)
            {
                aux = sprite.getProducto();
            }

            else if (cual == 3)
            {
                aux = fanta.getProducto();
            }

            else if (cual == 4)
            {
                aux = super8.getProducto();
            }

            else if (cual == 5)
            {
                aux = snickers.getProducto();
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