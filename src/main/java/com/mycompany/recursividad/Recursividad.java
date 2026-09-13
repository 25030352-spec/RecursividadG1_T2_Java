package com.mycompany.recursividad;

import java.util.Scanner;

public class Recursividad {

    // ==========================================
    // EJERCICIO 1: Contar vocales de una cadena
    // ==========================================
    public static int contarVocales(String cadena, int posicion) {
        if (posicion >= cadena.length()) {
            return 0; // Caso base
        }

        char caracter = Character.toLowerCase(cadena.charAt(posicion));
        int vocal = 0;

        if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
            vocal = 1;
        }

        return vocal + contarVocales(cadena, posicion + 1); // Llamada recursiva
    }

    // ==========================================
    // EJERCICIO 2: Suma de los dígitos de un número
    // ==========================================
    public static int sumaDigitos(int numero) {
        numero = Math.abs(numero);

        if (numero < 10) {
            return numero; // Caso base
        }

        return (numero % 10) + sumaDigitos(numero / 10); // Llamada recursiva
    }

    // ==========================================
    // EJERCICIO 3: Suma de los primeros n números
    // ==========================================
    public static int sumaPrimerosN(int n) {
        if (n <= 0) {
            return 0; // Caso base
        }

        return sumaPrimerosN(n - 1) + n; // Llamada recursiva
    }

    // ==========================================
    // PROGRAMA PRINCIPAL
    // ==========================================
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("======================================");
            System.out.println("       EJERCICIOS DE RECURSIVIDAD");
            System.out.println("======================================");
            System.out.println("1. Contar vocales de una cadena");
            System.out.println("2. Suma de dígitos y mayor suma");
            System.out.println("3. Suma de los primeros n números");
            System.out.println("4. Salir");
            System.out.println("======================================");
            System.out.print("Seleccione una opción: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n=== EJERCICIO 1 ===");
                    System.out.print("Ingrese una cadena: ");
                    String cadena = entrada.nextLine();
                    int cantidadVocales = contarVocales(cadena, 0);
                    System.out.println("\nLa cadena contiene " + cantidadVocales + " vocal(es).");
                    break;

                case 2:
                    System.out.println("\n=== EJERCICIO 2 ===");
                    System.out.println("Ingrese números enteros positivos. Escriba 0 para terminar.\n");
                    int numero;
                    int mayorSuma = -1;
                    int numeroMayor = 0;

                    do {
                        System.out.print("Número: ");
                        numero = entrada.nextInt();

                        if (numero > 0) {
                            int suma = sumaDigitos(numero);
                            System.out.println("Suma de sus dígitos: " + suma);

                            if (suma > mayorSuma) {
                                mayorSuma = suma;
                                numeroMayor = numero;
                            }
                        }
                    } while (numero != 0);

                    if (mayorSuma >= 0) {
                        System.out.println("\nEl número cuya suma de dígitos es mayor es: " + numeroMayor);
                        System.out.println("Su suma de dígitos es: " + mayorSuma);
                    } else {
                        System.out.println("\nNo se ingresaron números positivos.");
                    }
                    break;

                case 3:
                    System.out.println("\n=== EJERCICIO 3 ===");
                    System.out.print("Ingrese el valor de n: ");
                    int n = entrada.nextInt();

                    if (n >= 0) {
                        int resultado = sumaPrimerosN(n);
                        System.out.println("\nS(" + n + ") = " + resultado);
                    } else {
                        System.out.println("n debe ser un número positivo.");
                    }
                    break;

                case 4:
                    System.out.println("\nPrograma finalizado.");
                    break;

                default:
                    System.out.println("\nOpción no válida.");
                    break;
            }
            System.out.println();
        } while (opcion != 4);

        entrada.close();
    }
}
