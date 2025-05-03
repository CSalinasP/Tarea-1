package org.example;

/**
 * Clase que representa un comprador que compra un producto de un expendedor con una moneda.
 * @author Carlos Salinas
 */
class Comprador {
    private String sonido;
    private int vuelto;

    /**
     * Constructor que instancia el comprador, que simula la compra y que almacena el valor del vuelto en la variable
     * vuelto y un String caracteristico a la variable sonido, esto ultimo en caso de que la compra sea exitosa.
     * Toma y vuelve a tirar las exepciones preestablecidas en el metodo comprarProducto de la clase Expendedor segun
     * sea el caso.
     * @param m es la moneda con la que se pretende comprar
     * @param cualProducto es una constante de la enumeracion Tipo que representa el tipo de producto que se desea.
     * @param exp referencia a una instancia de la clase Expendedor que representa un expendedor
     */
    public Comprador(Moneda m, Tipo cualProducto, Expendedor exp) throws Exepciones {
        sonido = null;
        vuelto = 0;

        int tipo;
        if(cualProducto==null){
            tipo = 0;
        }
        else {tipo = cualProducto.getTipo();}

        try{
            Producto p = exp.comprarProducto(m,tipo);
        }
        catch (Exepciones e){
            if (e instanceof PagoIncorrectoException) {
                throw new PagoIncorrectoException();
            } else if (e instanceof NoHayProductoException) {
                throw new NoHayProductoException();
            } else if (e instanceof PagoInsuficienteException) {
                throw new PagoInsuficienteException();
            }
        }
        finally {
            Producto p = exp.comprarProducto(m,tipo);
            if(p!=null){
                sonido = p.consumir();
                while (true) {
                    Moneda aux_vuelto = exp.getVuelto();

                    if (aux_vuelto != null) {
                        vuelto = vuelto + aux_vuelto.getValor();
                    }

                    else {
                        break;
                    }
                }
            }

            else {
                while (true) {
                    Moneda aux_vuelto = exp.getVuelto();

                    if (aux_vuelto != null) {
                        vuelto = vuelto + aux_vuelto.getValor();
                    } else {
                        break;
                    }

                }
            }
        }
    }

    /**
     * Retorna el valor del vuelto asociado a la compra
     * @return vuelto es el valor del vuelto asociado a la compra.
     */
    public int cuantoVuelto()
    {
        return vuelto;
    }

    /**
     * Retorna un String caracteristico del producto comprado en caso de que la compra sea exitosa
     * @return sonido es el String asosiado al producto comprado cuando la compra es exitosa.
     */
    public String queConsumiste() {
        return sonido;
    }
}