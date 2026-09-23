package com.shoro;

/**
 * Entrega 2 Semana 5
 *
 * Ejercicio 1 - Adivinanza de Personajes
 *
 * Programa que intenta identificar el personaje elegido por el usuario
 * mediante una serie de preguntas con respuestas Sí/No.
 *
 * El programa utiliza un árbol de decisiones con estructuras condicionales
 * para ir descartando personajes según las respuestas ingresadas, hasta
 * determinar el personaje seleccionado.
 *
 * También valida que las respuestas sean S, N o E, permitiendo repetir
 * la pregunta en caso de una entrada inválida o salir del programa.
 *
 * Integrantes:
 * - Mariano Estrada Jaramillo
 * - Johnny Florez Mogollon
 * - Deici Hernandez Gutierrez
 * - Miguel Mesa Barrientos
 * - Mario Niño Cortés
 */

import java.util.Scanner;

public class AdivinaPersonaje {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Mostrar lista y esperar confirmación ---
        String respuesta;
        boolean listoParaComenzar = false;

        while (!listoParaComenzar) {
            System.out.println("=== Adivina el Personaje ===");
            System.out.println();
            System.out.println("Por favor, observa, escoge y memoriza un personaje antes de continuar:");
            System.out.println();
            System.out.println("  1. Radamel Falcao García");
            System.out.println("  2. Goku");
            System.out.println("  3. Michael Jordan");
            System.out.println("  4. Eminem");
            System.out.println("  5. Darth Vader");
            System.out.println("  6. Adam Sandler");
            System.out.println("  7. Bruce Wayne");
            System.out.println("  8. Tin Tin");
            System.out.println("  9. Ayudante de Santa");
            System.out.println(" 10. Joe Biden");
            System.out.println(" 11. José Saramago");
            System.out.println(" 12. Günter Grass");
            System.out.println(" 13. Kim Jong Un");
            System.out.println();

            respuesta = preguntarPreparado(scanner, "¿Estás listo para comenzar? (responde 'S' (sí), N (no) o E (salir)).");

            if (respuesta.equals("e")) {
                salir();
                scanner.close();
                return;
            } else if (respuesta.equals("s")) {
                listoParaComenzar = true;
            }
            // Si responde 'n', el while vuelve a mostrar la lista y pregunta de nuevo
        }

        System.out.println();
        System.out.println("¡Perfecto! Responde con S (sí), N (no) o E (salir).");
        System.out.println();

        // --- Preguntas (arbol de decision) ---

        // Pregunta 1: ¿Es una persona real?
        respuesta = preguntarValida(scanner, "¿Tu personaje existe o existió en la vida real?");
        if (respuesta.equals("e")) {
            salir();
            return;
        }

        if (respuesta.equals("s")) {
            // Rama: persona real
            // Pregunta 2: ¿Su actividad principal está relacionada con el deporte o el entretenimiento?
            respuesta = preguntarValida(scanner, "¿Su actividad principal está relacionada con el deporte o el entretenimiento?");
            if (respuesta.equals("e")) {
                salir();
                return;
            }

            if (respuesta.equals("s")) {
                // Rama: deporte o entretenimiento
                // Pregunta 3: ¿Es deportista?
                respuesta = preguntarValida(scanner, "¿Es deportista?");
                if (respuesta.equals("e")) {
                    salir();
                    return;
                }

                if (respuesta.equals("s")) {
                    // Rama: deportista
                    // Pregunta 4: ¿Es futbolista?
                    respuesta = preguntarValida(scanner, "¿Es futbolista?");
                    if (respuesta.equals("e")) {
                        salir();
                        return;
                    }

                    if (respuesta.equals("s")) {
                        System.out.println("Tu personaje es: Radamel Falcao García");
                    } else {
                        System.out.println("Tu personaje es: Michael Jordan");
                    }

                } else {
                    // Rama: entretenimiento (no deportista)
                    // Pregunta 4: ¿Es cantante?
                    respuesta = preguntarValida(scanner, "¿Es cantante?");
                    if (respuesta.equals("e")) {
                        salir();
                        return;
                    }

                    if (respuesta.equals("s")) {
                        System.out.println("Tu personaje es: Eminem");
                    } else {
                        System.out.println("Tu personaje es: Adam Sandler");
                    }
                }

            } else {
                // Rama: no deporte ni entretenimiento (política o literatura)
                // Pregunta 3: ¿Es político?
                respuesta = preguntarValida(scanner, "¿Es político?");
                if (respuesta.equals("e")) {
                    salir();
                    return;
                }

                if (respuesta.equals("s")) {
                    // Rama: político
                    // Pregunta 4: ¿Es estadounidense?
                    respuesta = preguntarValida(scanner, "¿Es estadounidense?");
                    if (respuesta.equals("e")) {
                        salir();
                        return;
                    }

                    if (respuesta.equals("s")) {
                        System.out.println("Tu personaje es: Joe Biden");
                    } else {
                        System.out.println("Tu personaje es: Kim Jong Un");
                    }

                } else {
                    // Rama: escritor
                    // Pregunta 4: ¿Es portugués?
                    respuesta = preguntarValida(scanner, "¿Es portugués?");
                    if (respuesta.equals("e")) {
                        salir();
                        return;
                    }

                    if (respuesta.equals("s")) {
                        System.out.println("Tu personaje es: José Saramago");
                    } else {
                        System.out.println("Tu personaje es: Günter Grass");
                    }
                }
            }

        } else {
            // Rama: no es persona real (ficticio)
            // Pregunta 2: ¿Tu personaje nació como un ser humano?
            respuesta = preguntarValida(scanner, "¿Tu personaje nació como un ser humano?");
            if (respuesta.equals("e")) {
                salir();
                return;
            }

            if (respuesta.equals("s")) {
                // Rama: ficticio humano
                // Pregunta 3: ¿Es un superhéroe?
                respuesta = preguntarValida(scanner, "¿Es un superhéroe?");
                if (respuesta.equals("e")) {
                    salir();
                    return;
                }

                if (respuesta.equals("s")) {
                    System.out.println("Tu personaje es: Bruce Wayne");
                } else {
                    // Pregunta 4: ¿Pertenece al universo de Star Wars?
                    respuesta = preguntarValida(scanner, "¿Pertenece al universo de Star Wars?");
                    if (respuesta.equals("e")) {
                        salir();
                        return;
                    }

                    if (respuesta.equals("s")) {
                        System.out.println("Tu personaje es: Darth Vader");
                    } else {
                        System.out.println("Tu personaje es: Tin Tin");
                    }
                }

            } else {
                // Rama: ficticio no humano
                // Pregunta 3: ¿Es un animal doméstico?
                respuesta = preguntarValida(scanner, "¿Es un animal doméstico?");
                if (respuesta.equals("e")) {
                    salir();
                    return;
                }

                if (respuesta.equals("s")) {
                    System.out.println("Tu personaje es: Ayudante de Santa");
                } else {
                    System.out.println("Tu personaje es: Goku");
                }
            }
        }

        scanner.close();
    }

    // Pregunta de preparación: acepta S, N o E (N mantiene la lista visible)
    static String preguntarPreparado(Scanner scanner, String pregunta) {
        String entrada;
        while (true) {
            System.out.print(pregunta + " (S/N/E): ");
            entrada = scanner.nextLine().trim().toLowerCase();

            if (entrada.equals("s") || entrada.equals("n") || entrada.equals("e")) {
                return entrada;
            }

            System.out.println("Opción no válida. Ingresa S para sí, N para no o E para salir");
        }
    }

    // Muestra la pregunta y repite hasta recibir S, N o E
    static String preguntarValida(Scanner scanner, String pregunta) {
        String entrada;
        while (true) {
            System.out.print(pregunta + " (S/N/E): ");
            entrada = scanner.nextLine().trim().toLowerCase();

            if (entrada.equals("s") || entrada.equals("n") || entrada.equals("e")) {
                return entrada;
            }

            System.out.println("Opción no válida. Por favor, ingresa S para sí, N para no o E para salir");
        }
    }

    static void salir() {
        System.out.println("Has salido del juego. ¡Hasta pronto!");
    }
}
