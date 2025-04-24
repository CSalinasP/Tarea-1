package org.example;

import java.util.ArrayList;

class DepositoM
{
    private ArrayList<Moneda> depM;

    public DepositoM()
    {
        depM = new ArrayList<>();
    }

    public Moneda getMoneda()
    {
        if (depM.size() > 0)
        {
            return depM.remove(0);
        }

        else
        {
            return null;
        }

    }

    public void addMoneda(Moneda x)
    {
        if (x != null)
        {
            depM.add(x);
        }

    }
}
