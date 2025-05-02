package org.example;

/**Enumeracion que contiene los precios de los productos.
 */
public enum Precio {
    CIEN(100),
    DOSCIENTOS(200),
    TRESCIENTOS(300),
    QUINIENTOS(500),
    MIL(1000),
    MIL_QUINIENTOS(1500);

    /**int para almacenar el valor del precio seleccionado.
     */
    private final int valor;

    /**Metodo para almacenar el valor del precio.
     * @param valor valor del precio.
     */
    Precio(int valor){
        this.valor = valor;
    }

    /**Metodo que retorna un int con el valor del precio.
     * @return el valor de {@code this.valor}.
     */
    public int getValor() {
        return this.valor;
    }
}
