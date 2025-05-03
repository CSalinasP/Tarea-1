package org.example;
import java.util.ArrayList;

/**La clase main permite probar las distintas clases con sus metodos
 * @author Carlos Salinas
 * */
public class main {
    public static void main(String[] args) {
        /**INSTANCIACION DE LAS DIFERENTES CLASES*/
        /**Bebidas y dulces como instancia de la clase Producto*/
        Producto P1 = new CocaCola(1);
        Producto P2 = new Sprite(1);
        Producto P3 = new Fanta(1);
        Producto P4 = new Super8(1);
        Producto P5 = new Snickers(1);

        /**Bebidas y dulces como instancia de las subclases Bebida y Dulce */
        Bebida B1 = new CocaCola(2);
        Bebida B2 = new Sprite(2);
        Bebida B3 = new Fanta(2);
        Dulce D1 = new Super8(2);
        Dulce D2 = new Snickers(2);

        /**Prueba de los metodos caracteristicos de cada tipo de producto */
        System.out.println(P1.getSerie()+" "+P1.consumir());
        System.out.println(P2.getSerie()+" "+P2.consumir());
        System.out.println(P3.getSerie()+" "+P3.consumir());
        System.out.println(P4.getSerie()+" "+P4.consumir());
        System.out.println(P5.getSerie()+" "+P5.consumir());
        System.out.println("\n");

        /**Diferentes tipos de moneda como instancias de la clase Moneda*/
        Moneda m100 = new Moneda100();
        Moneda m200 = new Moneda100();
        Moneda m300 = new Moneda100();
        Moneda m500 = new Moneda100();
        Moneda m1000 = new Moneda100();
        Moneda m1500 = new Moneda100();

        /**Prueba de los metodos caracteristicos de los distintos metodos de cada tipo de moneda */
        System.out.println(m100.getSerie()+" "+ m100.getValor());
        System.out.println(m200.getSerie()+" "+ m200.getValor());
        System.out.println(m300.getSerie()+" "+ m300.getValor());
        System.out.println(m500.getSerie()+" "+ m500.getValor());
        System.out.println(m1000.getSerie()+" "+ m1000.getValor());
        System.out.println(m1500.getSerie()+" "+ m1500.getValor());
        System.out.println("\n");

        /**Instanciacion de la Clase generica GDeposito
         *como deposito de objetos de clase Producto con llenado y vaciado*/
        GDeposito<Producto> D = new GDeposito<>();
        GDeposito<Moneda> M = new GDeposito<>();
        for (int i=0;i<1;i++) {
            Producto c = new CocaCola(i);
            D.add(c);
            System.out.println(D.get());
        }
        System.out.println(D.get());
        System.out.println("\n");

        /**como deposito de objetos de clase Moneda con llenado y vaciado*/
        for (int i=0;i<1;i++) {
            Moneda m = new Moneda100();
            M.add(m);
            System.out.println(M.get());
        }
        System.out.println(M.get());
        System.out.println("\n");

        /**Instanciacion de la clase Expendedor*/
        /**Pruebas del metodo comprar producto para una compra exitosa*/
        Expendedor Exp = new Expendedor(3, Precio.DOSCIENTOS, Precio.TRESCIENTOS, Precio.QUINIENTOS, Precio.MIL, Precio.MIL_QUINIENTOS);
        try{
            Producto p1 = Exp.comprarProducto(m1000,Tipo.COCA.getTipo());
            System.out.println(p1.getSerie()+" "+p1.consumir());
        }
        catch (Exepciones e){
            if (e instanceof PagoIncorrectoException) {
                System.out.println("Error: El pago ingresado es incorrecto");
            }
            if (e instanceof NoHayProductoException) {
                System.out.println("Error: No hay stock disponible del producto solicitado");
                if (m1000 != null) {
                    System.out.println("Vuelto: " + m1000.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
            if (e instanceof PagoInsuficienteException) {
                System.out.println("Error: El pago es insuficiente");
                if (m1000 != null) {
                    System.out.println("Vuelto: " + m1000.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
        }
        System.out.println("\n");

        /**Pruebas del metodo comprar producto con una moneda no valida*/
        try{
            Moneda im=null;
            Producto p1 = Exp.comprarProducto(im, Tipo.COCA.getTipo());
            System.out.println(p1.getSerie()+" "+p1.consumir());
        }
        catch (Exepciones e){
            if (e instanceof PagoIncorrectoException) {
                System.out.println("Error: El pago ingresado es incorrecto");
            }
        }
        System.out.println("\n");

        /**Pruebas del metodo comprar producto con una moneda de menor valor que el precio del producto*/
        try{
            Producto p1 = Exp.comprarProducto(m100, Tipo.COCA.getTipo());
            System.out.println(p1.getSerie()+" "+p1.consumir());
        }
        catch (Exepciones e) {
            if (e instanceof PagoInsuficienteException) {
                System.out.println("Error: El pago es insuficiente");
                if (m100 != null) {
                    System.out.println("Vuelto: " + m100.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
        }
        System.out.println("\n");

        /**Pruebas del metodo comprar producto cuando no hay Stock*/
        try{
            Producto p1 = Exp.comprarProducto(m200, Tipo.COCA.getTipo());
            System.out.println(p1.getSerie()+" "+p1.consumir());
        }
        catch (Exepciones e) {
            if (e instanceof NoHayProductoException) {
                System.out.println("Error: No hay stock disponible del producto solicitado");
                if (m200 != null) {
                    System.out.println("Vuelto: " + m200.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
        }
        System.out.println("\n");

        /**Retorno del vuelto resultante de los 4 intentos de compra*/
        System.out.println(Exp.getVuelto());
        System.out.println("\n");


        /**POSIBILIDADES DE COMPRA*/
        Expendedor exp = new Expendedor(4, Precio.DOSCIENTOS, Precio.TRESCIENTOS, Precio.QUINIENTOS, Precio.MIL, Precio.MIL_QUINIENTOS);
        Moneda m = null;
        Comprador c = null;

        /**Intento de compra con una moneda invalida*/
        try {
            c = new Comprador(m, Tipo.COCA, exp);
            System.out.println("Producto: "+c.queConsumiste() + ", Vuelto: " + c.cuantoVuelto());
        } catch (Exepciones e) {
            if (e instanceof PagoIncorrectoException) {
                System.out.println("Error: El pago ingresado es incorrecto");
            }
            if (e instanceof NoHayProductoException) {
                System.out.println("Error: No hay stock disponible del producto solicitado");
                if (m != null) {
                    System.out.println("Vuelto: " + m.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
            if (e instanceof PagoInsuficienteException) {
                System.out.println("Error: El pago es insuficiente");
                if (m != null) {
                    System.out.println("Vuelto: " + m.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
        }
        System.out.println("\n");

        /**Intento de compra con una moneda del mismo valor que el producto*/
        try {
            m = new Moneda200();
            c = new Comprador(m, Tipo.COCA, exp);
            System.out.println("Producto: "+c.queConsumiste() + ", Vuelto: " + c.cuantoVuelto());
        } catch (Exepciones e) {
            if (e instanceof PagoIncorrectoException) {
                System.out.println("Error: El pago ingresado es incorrecto");
            }
            if (e instanceof NoHayProductoException) {
                System.out.println("Error: No hay stock disponible del producto solicitado");
                if (m != null) {
                    System.out.println("Vuelto: " + m.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
            if (e instanceof PagoInsuficienteException) {
                System.out.println("Error: El pago es insuficiente");
                if (m != null) {
                    System.out.println("Vuelto: " + m.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
        }
        System.out.println("\n");

        /**Intento de compra con una moneda de menor valor al del producto*/
        try {
            m = new Moneda100();
            c = new Comprador(m, Tipo.SNICKERS, exp);
            System.out.println("Producto: "+c.queConsumiste() + ", Vuelto: " + c.cuantoVuelto());
        } catch (Exepciones e) {
            if (e instanceof PagoIncorrectoException) {
                System.out.println("Error: El pago ingresado es incorrecto");
            }
            if (e instanceof NoHayProductoException) {
                System.out.println("Error: No hay stock disponible del producto solicitado");
                if (m != null) {
                    System.out.println("Vuelto: " + m.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
            if (e instanceof PagoInsuficienteException) {
                System.out.println("Error: El pago es insuficiente");
                if (m != null) {
                    System.out.println("Vuelto: " + m.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
        }
        System.out.println("\n");

        /**Intento de compra con una moneda de mayor valor que el producto*/
        try {
            m = new Moneda1500();
            c = new Comprador(m, Tipo.COCA, exp);
            System.out.println("Producto: "+c.queConsumiste() + ", Vuelto: " + c.cuantoVuelto());
        } catch (Exepciones e) {
            if (e instanceof PagoIncorrectoException) {
                System.out.println("Error: El pago ingresado es incorrecto");
            }
            if (e instanceof NoHayProductoException) {
                System.out.println("Error: No hay stock disponible del producto solicitado");
                if (m != null) {
                    System.out.println("Vuelto: " + m.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
            if (e instanceof PagoInsuficienteException) {
                System.out.println("Error: El pago es insuficiente");
                if (m != null) {
                    System.out.println("Vuelto: " + m.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
        }
        System.out.println("\n");

        /**Intento de compra cuando no queda Stock del producto solicitado*/
        try {
            m = new Moneda200();
            c = new Comprador(m, Tipo.COCA, exp);
            System.out.println("Producto: "+c.queConsumiste() + ", Vuelto: " + c.cuantoVuelto());
        } catch (Exepciones e) {
            if (e instanceof PagoIncorrectoException) {
                System.out.println("Error: El pago ingresado es incorrecto");
            }
            if (e instanceof NoHayProductoException) {
                System.out.println("Error: No hay stock disponible del producto solicitado");
                if (m != null) {
                    System.out.println("Vuelto: " + m.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
            if (e instanceof PagoInsuficienteException) {
                System.out.println("Error: El pago es insuficiente");
                if (m != null) {
                    System.out.println("Vuelto: " + m.getValor());
                } else {
                    System.out.println("Vuelto: " + null);
                }
            }
        }
    }
}
