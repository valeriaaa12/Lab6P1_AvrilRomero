/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_avrilromero;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rodge
 */
public class Lab6P1_AvrilRomero {

    /**
     * @param args the command line arguments
     */
    static Scanner Leer = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {
        boolean seguir = true;
        while (seguir) {
            System.out.println("1.Cuantos primos tienes");
            System.out.println("2.Frecuencia de letras");
            System.out.println("3.Salir");
            System.out.println("Ingrese una opcion: ");
            int opcion = Leer.nextInt();
            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese el tamano del arreglo a generar: ");
                    int size = Leer.nextInt();
                    while (size < 1) {
                        System.out.println("El tamano debe ser mayor a 1.");
                        System.out.println("Ingrese el tamano del arreglo a generar: ");
                        size = Leer.nextInt();
                    }//fin primera validacion
                    System.out.println("Ingrese el limite inferior: ");
                    int inferior = Leer.nextInt();
                    System.out.println("Ingrese el limite superior: ");
                    int superior = Leer.nextInt();
                    while (superior < inferior) {
                        System.out.println("El limite superior debe ser mayor que el limite inferior.");
                        System.out.println("Ingrese el limite inferior: ");
                        inferior = Leer.nextInt();
                        System.out.println("Ingrese el limite superior: ");
                        superior = Leer.nextInt();
                    }//fin segunda validacion
                    int[] arreglo = genRandArray(size, inferior, superior);
                    System.out.print("Arreglo generado: ");
                    Imprimir(arreglo);
                    System.out.print("No.divisores primos: ");
                    int[] resultado = getTotalPrimeCount(arreglo);
                    Imprimir(resultado);
                }//fin case 1
                break;
                case 2: {
                    System.out.println("Ingrese una palabra: ");
                    String word = sc.next();
                    String minuscula = word.toLowerCase();
                    boolean valid = true;
                    if (word.equals(minuscula)) {
                        valid = true;
                        System.out.println("Frecuencias para la palabra: " + word);
                        Imprimir(extraerFrecuencias(word));
                        System.out.println(abecedario());
                    } else {
                        System.out.println("La palabra debe estar en minusculas.");
                    }//fin else 
                }//fin case 2
                break;
                case 3: {
                    seguir = false;
                }
                break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;
            }//fin switch
        }//fin while

    }//fin main

    public static int[] genRandArray(int a, int b, int c) {
        int[] arreglo1 = new int[a];
        for (int i = 0; i < a; i++) {
            //System.out.println("Ingrese el numero "+i+" = ");
            arreglo1[i] = b + ran.nextInt(c);
        }
        return arreglo1;
    }//fin metodo genRandArray

    public static void Imprimir(int[] y) {
        for (int i = 0; i < y.length; i++) {
            System.out.print("[" + y[i] + "]");
        }
        System.out.println(" ");
    }

    public static boolean isPrime(int x) {
        int cont = 1;
        int acum = 0;
        int resultado;
        boolean primo = true;
        while (cont <= x) {
            resultado = x % cont;
            if (resultado == 0) {
                acum = acum + 1;
            }
            cont = cont + 1;
        }
        if (acum == 2) {
            primo = true;
        } else {
            primo = false;
        }
        return primo;
    }

    public static int countPrimeFactors(int x) {
        int cont = 0;
        for (int i = x; i >= 1; i--) {
            if (isPrime(i) && x % i == 0) {
                cont++;
            }
        }
        return cont;
    }

    public static int[] getTotalPrimeCount(int[] x) {
        int[] temporal = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            temporal[i] += countPrimeFactors(x[i]);
        }
        return temporal;
    }

    public static int[] extraerFrecuencias(String y) {
        int[] arreglo = new int[27];
        int cont = 0;
        int cont2 = 0;
        for (int i = 0; i < y.length(); i++) {
            int charac = y.charAt(i);
            int posicion = charac - 97;
            if (charac >= 97 && charac <= 122) {
                arreglo[posicion]++;
            } else {
                cont2++;
                arreglo[26]++;
            }
        }
        return arreglo;
    }

    public static String abecedario() {
        String abc = "";
        for (int i = 97; i <= 122; i++) {
            char c = (char) i;
            abc += '[';
            abc += c;
            abc += ']';
        }
        return abc;
    }
}//fin clase
