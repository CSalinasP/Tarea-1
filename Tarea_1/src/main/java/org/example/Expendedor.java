package org.example;

class Expendedor
{
    private GDeposito<Producto> coca;
    private GDeposito<Producto> sprite;
    private GDeposito<Producto> fanta;
    private GDeposito<Producto> super8;
    private GDeposito<Producto> snickers;
    private GDeposito<Moneda> monedas;
    private int precioUno;
    private int precioDos;
    private int precioTres;
    private int precioCuatro;
    private int precioCinco;

    public Expendedor(int numProductos, Precio precioProductoUno, Precio precioProductoDos, Precio precioProductoTres, Precio precioProductoCuatro, Precio precioProductoCinco)
    {
        coca = new GDeposito();
        sprite = new GDeposito();
        fanta = new GDeposito();
        super8 = new GDeposito();
        snickers = new GDeposito();
        monedas = new GDeposito();
        precioUno = precioProductoUno.getValor();
        precioDos = precioProductoDos.getValor();
        precioTres = precioProductoTres.getValor();
        precioCuatro = precioProductoCuatro.getValor();
        precioCinco = precioProductoCinco.getValor();

        for (int i=0;i<numProductos;i++) {
            Producto c = new CocaCola(100+i);
            coca.add(c);
        }

        for (int i=0;i<numProductos;i++) {
            Producto s = new Sprite(200+i);
            sprite.add(s);
        }

        for (int i=0;i<numProductos;i++) {
            Producto s = new Fanta(300+i);
            fanta.add(s);
        }

        for (int i=0;i<numProductos;i++) {
            Producto s = new Super8(400+i);
            super8.add(s);
        }

        for (int i=0;i<numProductos;i++) {
            Producto s = new Snickers(500+i);
            snickers.add(s);
        }
    }

    public Producto comprarProducto (Moneda m, int cual) throws Exepciones {
        if (m == null) {
            throw new PagoIncorrectoException();
        }

        Producto aux=null;
        int precio;

        if (cual == 1) {
            precio = precioUno;
        }

        else if (cual == 2) {
            precio = precioDos;
        }

        else if (cual == 3) {
            precio = precioTres;
        }

        else if (cual == 4) {
            precio = precioCuatro;
        }

        else if (cual == 5) {
            precio = precioCinco;
        }

        else {precio = 0;}


        if (precio <= m.getValor()) {
            if (cual == 1) {
                aux = coca.get();
            }

            else if (cual == 2) {
                aux = sprite.get();
            }

            else if (cual == 3) {
                aux = fanta.get();
            }

            else if (cual == 4) {
                aux = super8.get();
            }

            else if (cual == 5) {
                aux = snickers.get();
            }

            else {
                int aux_valor = m.getValor();

                while (true) {
                    if (aux_valor > 0) {
                        Moneda100 m100 = new Moneda100();
                        monedas.add(m100);

                        aux_valor = aux_valor - 100;
                    }

                    else {
                        break;
                    }
                }
                throw new NoHayProductoException();
            }

            if (aux != null) {
                int aux_valor = m.getValor();

                while (true) {
                    if (aux_valor > precio) {
                        Moneda100 m100 = new Moneda100();
                        monedas.add(m100);
                        aux_valor = aux_valor - 100;
                    }

                    else {
                        return aux;
                    }
                }
            }

            else {
                monedas.add(m);
                return null;
            }
        }

        else {
            monedas.add(m);
            throw new PagoInsuficienteException();
        }
    }

    //retorna una moneda desde el deposito de vuelto, hay que llamarla hasta que quede vacio
    public Moneda getVuelto() {
        return monedas.get();
    }
}