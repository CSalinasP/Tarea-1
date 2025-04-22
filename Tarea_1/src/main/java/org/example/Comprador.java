package org.example;

class Comprador {

    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp){

        if (m==null)
        {
            sonido = null;
            vuelto = 0;
        }

        else if (cualBebida<1 || cualBebida>2)
        {
            sonido = null;
            vuelto = m.getValor();
        }

        else
        {
            Bebida b = exp.comprarBebida(m,cualBebida);

            if (b != null)
            {
                sonido = b.beber();

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

    public String queBebiste() //String con el sonido de la Bebida: cocacola, sprite
    {
        return sonido;

    }

}