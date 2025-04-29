package org.example;
import java.util.Scanner;

/**La clase {@code} MainInteractivo proporciona una interfaz para la simulacion de una serie de compras
 * @author Francisco Arentsen San Martín
 * */
public class MainInteractivo {
    public static void main(String[] args) {
        /*Creacion de los objetos de clase Scanner, Expendedor y declaracion de las variables
        para los objetos de clase Moneda y Comprador y para las constantes de la enumeracion Tipo*/
        Scanner sc = new Scanner(System.in);
        Expendedor exp = new Expendedor(100, Precio.CIEN,Precio.DOSCIENTOS,Precio.TRESCIENTOS,Precio.QUINIENTOS,Precio.MIL);
        Moneda m = null;
        Tipo tipoProducto = null;

        //Ciclo while que simula una serie de compras
        Comprador c;
        while(true){
            /*Se ingresa una variable int para seleccionar el tipo de moneda a utilizar*/
            System.out.println("Ingresar Valor de la Moneda: ");
            int inputM = sc.nextInt();
            System.out.println("\n");
            switch (inputM) {
                case 100 -> m = new Moneda100();
                case 500 -> m = new Moneda500();
                case 1000 -> m = new Moneda1000();
                case 1500 -> m = new Moneda1500();
            }

            /*Se ingresa una variable String para seleccionar el tipo de Producto a Comprar*/
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

            /*Se crea el objeto de clase Comprador y se despliega el nombre del producto consumido
            y el valor asociado al vuelto*/
            c= new Comprador(m, tipoProducto, exp);
            System.out.println(c.queConsumiste());
            System.out.println(c.cuantoVuelto());
            System.out.println("\n");

            /*Se le da la opcion al usuario de terminar la compra mediante la palabra clave 'Fin'*/
            System.out.println("Ingresar 'Fin' para Finalizar");
            String inputF = sc.next();
            System.out.println("\n\n");
            if (inputF.equals("Fin")){
                break;
            }
        }
    }
}
