package ejercicios;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
  public static final Logger LOG =
      Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    /*
     * RESOLVER
     * Ejercicio 1: Crear un programa que permita ingresar las notas de estudiantes y calcule:
     * El promedio de notas.
     * La nota más alta.
     * La nota más baja.
     * Cantidad de aprobados (nota ≥ 6).
     * Usar un array para almacenar las notas.
     * Funciones para cada cálculo (calcularPromedio(), encontrarMaxima(), etc.).
     * Validar que las notas estén entre 0 y 10
     */
    int cantidadNotas = ingresarNro("la cantidad de notas: ");
    int[] notas = new int[cantidadNotas];
    cargarNotasEnArray(notas);
    mostrarNotas(notas);
    LOG.info(String.format("La nota mas alta %d", encontrarElMayor(notas)));
    LOG.info(String.format("La nota mas baja %d", encontrarElMenor(notas)));
    LOG.info(String.format("El promedio %d", calcularPromedioNotas(notas)));
    LOG.info(String.format("Cantidad de aprobados %d", contarAprobados(notas)));
  }

  public static int ingresarNro(String mensaje) {
    LOG.info("Ingrese " + mensaje);
    Scanner sc = new Scanner(System.in);
    return sc.nextInt();
  }

  public static void cargarNotasEnArray(int[] notas) {
    for (int i = 0; i < notas.length; i++) {
      int nota;
      do {
        nota = ingresarNro("La nota del estudiante " + (i + 1));
      } while (nota < 0 || nota > 10);
      notas[i] = nota;
    }
  }

  public static void mostrarNotas(int[] notas) {
    for (int i = 0; i < notas.length; i++) {
      LOG.info(String.format("La nota del estudiante %d es %d", (i + 1), notas[i]));
    }
  }

  public static int encontrarElMenor(int[] notas) {
    int menor = 10;
    for (int i = 0; i < notas.length; i++) {
      menor = (notas[i] < menor) ? notas[i] : menor;
    }
    return menor;
  }

  public static int encontrarElMayor(int[] notas) {
    int mayor = 0;
    for (int i = 0; i < notas.length; i++) {
      mayor = (notas[i] > mayor) ? notas[i] : mayor;
    }
    return mayor;
  }

  public static int calcularPromedioNotas(int[] notas) {
    int promedio = 0;
    for (int i = 0; i < notas.length; i++) {
      promedio += notas[i];
    }
    promedio = promedio / notas.length;
    return promedio;
  }

  public static int contarAprobados(int[] notas) {
    int contAprobado = 0;
    for (int i = 0; i < notas.length; i++) {
      if (notas[i] >= 6) {
        contAprobado++;
      }
    }
    return contAprobado;
  }
}