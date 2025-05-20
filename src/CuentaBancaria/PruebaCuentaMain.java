package CuentaBancaria;

import java.util.Scanner;

public class PruebaCuentaMain {

    public static void main(String[] args) {        
        Scanner input = new Scanner(System.in); // Creamos un scanner 
        System.out.println("Cuenta de ahorros");
        System.out.println("Ingrese saldo inicial:");
        float saldoInicialAhorros = input.nextFloat();
        System.out.println("Ingrese la tasa de interes anual: ");
        float tasaAnualAhorros = input.nextFloat();
        CuentaAhorros cuenta1 = new CuentaAhorros(saldoInicialAhorros, tasaAnualAhorros);
        System.out.println("Ingresa la cantidad a consignar:");
        float cantidadConsignar = input.nextFloat();
        cuenta1.consignar(cantidadConsignar);
        System.out.println("Ingresa la cantidad a retirar:");
        float cantidadRetirar = input.nextFloat();
        cuenta1.retirar(cantidadRetirar);
        System.out.println("Generando extracto mensual...");
        cuenta1.extractoMensual();
        System.out.println("Generando datos de la cuenta...");
        cuenta1.imprimir2();
    }
    
}
