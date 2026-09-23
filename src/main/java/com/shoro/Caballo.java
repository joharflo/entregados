package com.shoro;
/**
 * Entrega 2 Semana 5
 *
 * Ejercicio 2 - Ataque de Caballo al Rey
 *
 * Programa que solicita al usuario las posiciones de un caballo y un rey
 * dentro de un tablero de ajedrez de 8 x 8.
 *
 * El programa utiliza un método que determina si el caballo puede atacar
 * al rey según las reglas de movimiento del caballo en ajedrez.
 *
 * También muestra en consola un tablero con casillas claras y oscuras,
 * representa la posición del caballo con la letra C y la del rey con la
 * letra R, y valida que las coordenadas ingresadas estén dentro del rango
 * permitido y que ambas piezas no ocupen la misma casilla.
 *
 * Finalmente, muestra si el rey es atacado o no por el caballo.
 *
 * Integrantes:
 * - Mariano Estrada Jaramillo
 * - Johnny Florez Mogollon
 * - Deici Hernandez Gutierrez
 * - Miguel Mesa Barrientos
 * - Mario Niño Cortés
 */

import java.util.Scanner;

public class Caballo {

    // Inicio del programa: flujo principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Título inicial
        System.out.println("======================================");
        System.out.println("           CABALLO VS REY");
        System.out.println("======================================");

        // Mostrar tablero vacío (se pasa 0 para indicar que no hay piezas)
        imprimirTablero(0, 0, 0, 0);

        // Solicitud y validación de coordenadas del rey
        System.out.println("Ingrese la fila del rey (1-8):");
        int fila_rey = leerCoordenada(scanner);
        System.out.println("Ingrese la columna del rey (1-8):");
        int col_rey = leerCoordenada(scanner);

        // Solicitud y validación de coordenadas del caballo
        System.out.println("Ingrese la fila del caballo (1-8):");
        int fila_cab = leerCoordenada(scanner);
        System.out.println("Ingrese la columna del caballo (1-8):");
        int col_cab = leerCoordenada(scanner);

        // Validación: el caballo y el rey no pueden estar en la misma casilla
        while (fila_cab == fila_rey && col_cab == col_rey) {
            System.out.println("Posición no válida: el caballo y el rey no pueden estar en la misma casilla.");
            System.out.println("Ingrese la fila del rey (1-8):");
            fila_rey = leerCoordenada(scanner);
            System.out.println("Ingrese la columna del rey (1-8):");
            col_rey = leerCoordenada(scanner);
        }

        // Llamada al método del literal A para determinar si hay ataque
        boolean ataca = caballoAtacaRey(fila_cab, col_cab, fila_rey, col_rey);

        // Mostrar tablero final con las piezas
        System.out.println("\n======================================");
        System.out.println("           CABALLO VS REY");
        System.out.println("======================================");
        imprimirTablero(fila_cab, col_cab, fila_rey, col_rey);

        // Presentación del resultado
        System.out.println("Caballo: (" + fila_cab + ", " + col_cab + ")");
        System.out.println("Rey:     (" + fila_rey + ", " + col_rey + ")");

        if (ataca) {
            System.out.println("El caballo ataca al rey.");
        } else {
            System.out.println("El caballo no ataca al rey.");
        }

        scanner.close();
    }

    // Lee una coordenada válida entre 1 y 8; repite si el valor no es válido
    public static int leerCoordenada(Scanner scanner) {
        int valor = scanner.nextInt();
        while (valor < 1 || valor > 8) {
            System.out.println("Coordenada no válida. Ingrese un número entre 1 y 8:");
            valor = scanner.nextInt();
        }
        return valor;
    }

    // Determina si el caballo ataca al rey según las reglas del ajedrez (literal A)
    public static boolean caballoAtacaRey(int fila_cab, int col_cab, int fila_rey, int col_rey) {
        // Calcula la diferencia absoluta entre filas y columnas
        int diferenciaFila = Math.abs(fila_rey - fila_cab);
        int diferenciaColumna = Math.abs(col_rey - col_cab);

        // El caballo ataca si el movimiento es (2,1) o (1,2)
        return (diferenciaFila == 2 && diferenciaColumna == 1)
            || (diferenciaFila == 1 && diferenciaColumna == 2);
    }

    // Construcción del tablero: reutilizable para tablero vacío y con piezas
    // Pasar fila_cab=0 y fila_rey=0 para mostrar el tablero sin piezas
    public static void imprimirTablero(int fila_cab, int col_cab, int fila_rey, int col_rey) {
        // Encabezado con números de columna
        System.out.println("    1   2   3   4   5   6   7   8");
        System.out.println("  +---------------------------------+");

        // Recorre las 8 filas del tablero
        for (int fila = 1; fila <= 8; fila++) {
            System.out.print(fila + " | ");

            // Recorre las 8 columnas de cada fila
            for (int col = 1; col <= 8; col++) {
                // Representación del caballo en su posición
                if (fila == fila_cab && col == col_cab) {
                    System.out.print(" C  ");
                // Representación del rey en su posición
                } else if (fila == fila_rey && col == col_rey) {
                    System.out.print(" R  ");
                } else {
                    // Alternancia de casillas claras y oscuras según paridad de fila+columna
                    if ((fila + col) % 2 == 0) {
                        System.out.print("███ ");
                    } else {
                        System.out.print("░░░ ");
                    }
                }
            }
            System.out.println("|");
        }
        System.out.println("  +---------------------------------+");
    }
}
