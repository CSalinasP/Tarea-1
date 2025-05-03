package org.example;

/**
 * Clase que representa un expendedor con 5 depositos para distintos
 * tipos de productos y un sexto para distintos tipos de moneda.
 * Permite realizar compras de productos y retornar el vuelto de estas si es que hubiera
 * @author Carlos Salinas
 */
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


    /**
     * Constructor de la clase Expendedor que rellena sus depositos de productos
     * @param numProductos entero que establece el numero de cada producto en su respectivo
     * deposito.
     * @param precioProductoUno ... constantes de la enumeracion Precio que establecen
     * los precios de cada producto.
     * */

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

    /**
     * Simula varias situaciones de compra.
     * En caso de que la moneda sea invalida tira la exepcion PagoIncorrectoException.
     * En caso de que no haya Stock del producto tira la exepcion NoHayProductoException y almacena la moneda de pago
     * en el deposito de monedas.
     * En caso de que el valor de la moneda sea menor al precio del producto tira la exepcion PagoInsuficienteException
     * y almacena la moneda de pago en el deposito de monedas.
     * Salvo esos casos el metodo retorna la referencia al producto deseado y almacena en el
     * deposito de monedas el vuelto correspondiente.
     * @param m moneda con la que se pretende comprar un producto.
     * @param cual entero que representa un tipo de producto.
     */
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
                throw new NoHayProductoException();
            }
        }
        else {
            monedas.add(m);
            throw new PagoInsuficienteException();
        }
    }

    /**
     * Retorna el valor vuelto resultante de las compras.
     * @return el valor del vuelto resultante de las compras.
     */
    public Moneda getVuelto() {
        return monedas.get();
    }
}