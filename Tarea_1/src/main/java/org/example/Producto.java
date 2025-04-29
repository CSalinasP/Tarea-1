package org.example;

/**
 * Clase abstracta que representa un producto generico.
 * Esta clase sirve como base para otros productos parciculares como bebidas o dulces.
 * Todo producto debe tener un número de serie y debe poder consumirse de alguna manera.
 */
public abstract class Producto {
    /**
     * Constructor por defecto de la clase Producto.
     */
    public Producto(){}

    /**
     * Método abstracto que retorna el numero de serie del producto.
     * @return un el numero de serie del producto
     */
    abstract public int getSerie();

    /**
     * Metodo abstracto que debe ser implementado por las subclases.
     * establece como se consume el producto.
     * @return un String que depende del tipo de producto.
     */
    abstract public String consumir();

}
