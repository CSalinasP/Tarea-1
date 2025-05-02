package org.example;

class Comprador {
    private String sonido;
    private int vuelto;

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

    //suma de la cantidad de todas las monedas de vuelto
    public int cuantoVuelto()
    {
        return vuelto;
    }

    //String con el sonido de la Bebida: cocacola, sprite
    public String queConsumiste() {
        return sonido;
    }
}