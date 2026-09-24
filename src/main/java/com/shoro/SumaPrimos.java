package com.shoro;

import java.util.Scanner;

public class SumaPrimos {

    public static void main(String[] args) {

        // Título del programa
        System.out.println("=== Suma de Números Primos ===");

        Scanner scanner = new Scanner(System.in);
        int n = 0;

        // Validación de entrada: repetir hasta obtener un entero positivo válido
        while (true) {
            System.out.print("Ingrese un número entero positivo: ");

            if (scanner.hasNextInt()) {
                int entrada = scanner.nextInt();
                if (entrada > 100000) {
                    System.out.println("El número es muy grande. Debe ingresar un número hasta cien mil.");
                } else if (entrada > 0) {
                    n = entrada;
                    break; // Entrada válida, salir del ciclo de validación
                } else {
                    System.out.println("Entrada no válida. Debe ingresar un número entero positivo.");
                }
            } else {
                // La entrada no es un entero (letras, decimales, símbolos, etc.)
                System.out.println("Entrada no válida. Debe ingresar un número entero positivo.");
                scanner.next(); // Descartar la entrada inválida
            }
        }

        scanner.close();

        // Variable acumuladora para la suma de primos
        int suma = 0;

        // Ciclo externo: recorrer todos los números del 2 hasta n
        for (int i = 2; i <= n; i++) {

            // Suponer que el número actual es primo
            boolean esPrimo = true;

            // Ciclo interno: buscar divisores entre 2 y (i - 1)
            for (int divisor = 2; divisor < i; divisor++) {
                if (i % divisor == 0) {
                    // Se encontró un divisor exacto: no es primo
                    esPrimo = false;
                    break; // No hace falta seguir buscando
                }
            }

            // Si ningún divisor fue encontrado, acumular el número
            if (esPrimo) {
                suma += i;
            }
        }

        // Mostrar el resultado final
        System.out.println("La suma de los números primos menores o iguales que " + n + " es: " + suma);
    }
}
