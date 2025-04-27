package org.example;

class Expendedor {
    int cc = Enumeracion.COCACOLA.getTipo();
    int sp = Enumeracion.SPRITE.getTipo();
    int fan= Enumeracion.FANTA.getTipo();
    int sup8 = Enumeracion.SUPER8.getTipo();
    int snk = Enumeracion.SNICKER.getTipo();

    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> super8;
    private Deposito<Producto> snickers;
    private Deposito<Moneda> monedas;
    private int precio;

    public Expendedor(int numProductos, int precioProductos) {
        coca = new Deposito();
        sprite = new Deposito();
        fanta = new Deposito();
        super8 = new Deposito();
        snickers = new Deposito();
        monedas = new Deposito();
        precio = precioProductos;

        for (int i=0;i<numProductos;i++) {
            CocaCola c = new CocaCola(100+i);
            coca.add(c);
        }

        for (int i=0;i<numProductos;i++) {
            Sprite s = new Sprite(200+i);
            sprite.add(s);
        }

        for (int i=0;i<numProductos;i++) {
            Fanta s = new Fanta(300+i);
            fanta.add(s);
        }

        for (int i=0;i<numProductos;i++) {
            Super8 s = new Super8(400+i);
            super8.add(s);
        }

        for (int i=0;i<numProductos;i++) {
            Snickers s = new Snickers(500+i);
            snickers.add(s);
        }
    }

    public Producto comprarProducto(Moneda m, int cual) throws Exepcion {
        if (m == null) {
            throw new Exepcion("PagoIncorrectoException");
        }

        Producto aux = null;

        if (precio <= m.getValor()) {
            if (cual == cc) {
                aux = coca.get();
            }
            else if (cual == sp) {
                aux = sprite.get();
            }
            else if (cual == fan) {
                aux = fanta.get();
            }
            else if (cual == snk) {
                aux = snickers.get();
            }
            else if (cual == sup8) {
                aux = super8.get();
            }
            else {
                int aux_valor = m.getValor();

                while (true) {
                    if (aux_valor > 0) {
                        Moneda100 m100 = new Moneda100();
                        monedas.add(m100);

                        aux_valor = aux_valor - 100;
                    } else {
                        return null;
                    }
                    throw new Exepcion("NoHayProductoException");
                }
            }
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
            throw new Exepcion("PagoInsuficienteException");
        }
    }

    //retorna una moneda desde el deposito de vuelto, hay que llamarla hasta que quede vacio
    public Moneda getVuelto() {
        return monedas.get();
    }
}