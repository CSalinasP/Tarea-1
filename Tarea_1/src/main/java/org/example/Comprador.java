package org.example;

class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualProducto, Expendedor exp) {
        if (m==null){
            sonido = null;
            vuelto = 0;
        }

        else if (cualProducto<exp.cc || cualProducto>exp.sup8) {
            sonido = null;
            vuelto = m.getValor();
        }

        else {
            Producto b = null;
            try {
                b = exp.comprarProducto(m,cualProducto);
            }
            catch (Exepcion e) {
                throw new RuntimeException(e);
            }

            if (b != null) {
                sonido = b.consumir();
                vuelto = 0;

                while (true) {
                    Moneda aux_vuelto = exp.getVuelto();//

                    if (aux_vuelto != null) {
                        vuelto = vuelto + aux_vuelto.getValor();
                    }

                    else {
                        break;
                    }
                }
            }

            else {
                sonido = null;
                vuelto = 0;

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
        }
    }

    //suma de la cantidad de todas las monedas de vuelto
    public int cuantoVuelto() {
        return vuelto;
    }

    //String con el sonido de la Bebida: cocacola, sprite
    public String queConsumiste() {
        return sonido;
    }
}