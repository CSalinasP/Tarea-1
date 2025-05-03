package org.example;
/**
 * Superclase de la que se heredan los distintos tipos de Exepciones establecidas para la tarea.
 * @author Ignacio Contardo
 */
public class Exepciones extends Exception {}

/**
 *Subclase para la exepcion predefinida cuando se intenta comprar con una moneda invalida.
 */
class PagoIncorrectoException extends Exepciones {}

/**
 *Subclase para la exepcion predefinida cuando se intenta comprar un producto con una moneda de valor
 * inferior a su precio.
 */
class PagoInsuficienteException extends Exepciones {}

/**
 *Subclase para la exepcion predefinida cuando no hay Stock de un producto.
 */
class NoHayProductoException extends Exepciones {}