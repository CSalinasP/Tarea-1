package org.example;
import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Expendedor exp = new Expendedor(100, Precio.CIEN,Precio.DOSCIENTOS,Precio.TRESCIENTOS,Precio.QUINIENTOS,Precio.MIL);
        Moneda m = null;
        Tipo tipoProducto = null;
        Comprador c;
        while(true){
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

            c= new Comprador(m, tipoProducto, exp);
            System.out.println(c.queConsumiste());
            System.out.println(c.cuantoVuelto());
            System.out.println("\n");

            System.out.println("Ingresar 'Fin' para Finalizar");
            String inputF = sc.next();
            System.out.println("\n\n");
            if (inputF.equals("Fin")){
                break;
            }
        }
    }
}
