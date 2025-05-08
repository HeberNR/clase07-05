package ejercicios;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Ejercicio2 {
  public static final Logger LOG =
      Logger.getLogger(Ejercicio2.class.getName());

  public static void main(String[] args) {
    /*
     * Ejercicio 2: Generar un array con números aleatorios (entre 1 y 100) y
     * permitir al usuario buscar un número en él.
     * Función para generar el array con números aleatorios (generarArray()).
     * Función para buscar un número y devolver su posición (buscarNumero()).
     * Función para ordenar el array (ordenarArray()).
     * Función para mostrar el array (mostrarArray()).
     */

    int cantidadNros = generarCantidad("la cantidad de elementos: ");
    int[] array = new int[cantidadNros];
    generarArray(array);
    buscarNro(array);
    ordenarArray(array);
    mostrarArray(array);
  }

  public static void generarArray(int[] array) {
    Random num = new Random();
    for (int i = 0; i < array.length; i++) {
      array[i] = num.nextInt(100) + 1;
    }
  }

  public static int generarCantidad(String mensaje) {
    LOG.info("Ingrese " + mensaje);
    Scanner sc = new Scanner(System.in);
    return sc.nextInt();
  }

  public static void buscarNro(int[] array) {
    Scanner sc = new Scanner(System.in);
    boolean seguirBuscando;
    do {
      LOG.info("Ingrese el numero a buscar: ");
      int nro = sc.nextInt();
      sc.nextLine();

      int posicion = -1;
      for (int i = 0; i < array.length; i++) {
        if (array[i] == nro) {
          posicion = i;
          break;
        }
      }
      if (posicion != -1) {
        LOG.info("El numero se encuentra en la posicion: " + posicion);
      } else {
        LOG.info("El número no se encuentra en el array.");
      }
      LOG.info("Desea seguir buscando? (si/no)");
      String respuesta = sc.nextLine();
      seguirBuscando = respuesta.equals("si");
    } while (seguirBuscando);
  }

  public static void ordenarArray(int[] array) {
    Arrays.sort(array);
  }

  public static void mostrarArray(int[] array) {
    LOG.info(Arrays.toString(array));
  }
}


