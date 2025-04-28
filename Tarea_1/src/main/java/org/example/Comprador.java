package org.example;

class Comprador {

    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, Tipo cualProducto, Expendedor exp){

        if (m==null)
        {
            sonido = null;
            vuelto = 0;
        }

        else if (cualProducto.getTipo()<1 || cualProducto.getTipo()>5)
        {
            sonido = null;
            vuelto = m.getValor();
        }

        else
        {
            Producto b = exp.comprarProducto(m,cualProducto.getTipo());

            if (b != null)
            {
                sonido = b.consumir();

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

    public String queConsumiste() //String con el sonido de la Bebida: cocacola, sprite
    {
        return sonido;

    }

}