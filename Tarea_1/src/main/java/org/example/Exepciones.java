package org.example;
public class Exepciones extends Exception {}

class PagoIncorrectoException extends Exepciones {}

class PagoInsuficienteException extends Exepciones {}

class NoHayProductoException extends Exepciones {}