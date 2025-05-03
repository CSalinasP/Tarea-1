package org.example;
import java.util.Scanner;

/**La clase {@code} MainInteractivo proporciona una interfaz para la simulacion de una serie de compras
 * @author Francisco Arentsen
 */
public class MainInteractivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Expendedor exp = new Expendedor(10, Precio.DOSCIENTOS, Precio.TRESCIENTOS, Precio.QUINIENTOS, Precio.MIL, Precio.MIL_QUINIENTOS);
        Moneda m = null;
        Tipo tipoProducto = null;

        Comprador c = null;
        while (true) {
            System.out.println("Ingresar Valor de la Moneda: ");
            int inputM = sc.nextInt();
            System.out.println("\n");
            switch (inputM) {
                case 100 -> m = new Moneda100();
                case 500 -> m = new Moneda500();
                case 1000 -> m = new Moneda1000();
                case 1500 -> m = new Moneda1500();
            }

            System.out.println("Ingresar Tipo de Producto: ");
            String inputT = sc.next();
            System.out.println("\n");
            switch (inputT) {
                case "Cocacola" -> tipoProducto = Tipo.COCA;
                case "Sprite" -> tipoProducto = Tipo.SPRITE;
                case "Fanta" -> tipoProducto = Tipo.FANTA;
                case "Super8" -> tipoProducto = Tipo.SUPER8;
                case "Snickers" -> tipoProducto = Tipo.SNICKERS;
            }

            try {c = new Comprador(m, tipoProducto, exp);}
            catch (Exepciones e) {
                if (e instanceof PagoIncorrectoException) {
                    System.out.println("Error: El pago ingresado es incorrecto");
                } if (e instanceof NoHayProductoException) {
                    System.out.println("Error: No hay stock disponible del producto solicitado");
                    if(m!=null){System.out.println("Vuelto: "+m.getValor());}
                    else{System.out.println("Vuelto: "+ null);}
                }
                if (e instanceof PagoInsuficienteException) {
                    System.out.println("Error: El pago es insuficiente");
                    if(m!=null){System.out.println("Vuelto: "+m.getValor());}
                    else{System.out.println("Vuelto: "+ null);}
                }
            }

            System.out.println("Ingresar 'Fin' para Finalizar");
            String inputF = sc.next();
            System.out.println("\n\n");
            if (inputF.equals("Fin")) {
                break;
            }
        }
    }
}