package org.example;

/**Enumeracion que contiene los tipos de productos codificados como numero entero(int).
 */
public enum Tipo {
    COCA(1),
    SPRITE(2),
    FANTA(3),
    SUPER8(4),
    SNICKERS(5);

    /**int para almacenar el numero entero para el tipo seleccionado.
     */
    private final int numero_tipo;

    /**Metodo para almacenar el int para el tipo seleccinado.
     * @param x int para el tipo seleccionado.
     */
    Tipo(int x) {
        numero_tipo = x;
    }

    /**Metodo que retorna el int para el tipo seleccionado.
     * @return el valor de {@code this.numero_tipo}.
     */
    public int getTipo() {
        return this.numero_tipo;
    }
}
