package ejercicios;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
  public static final Logger LOG =
      Logger.getLogger(Main.class.getName());
  public static void main(String[] args) { //funcion main
    //int cantidadEstudiantes = ingresarNro("Cantidad de estudiantes");
    int cantidadNotas = ingresarNro("La cantidad de notas");
    int[] notas = new int[cantidadNotas];
    cargarNotasEnArray(notas);
    mostrarNotas(notas);
    LOG.info("La nota mas alta " + encontrarElMayor(notas));
    LOG.info("La nota mas baja " + encontrarElMenor(notas));
    LOG.info("El promedio " + calcularPromedioNotas(notas));
  }
  public static int ingresarNro(String mensaje) {
    LOG.info("Por favor ingrese la cantidad de " + mensaje);
    Scanner sc = new Scanner(System.in);
    return sc.nextInt();
  }
  public static void cargarNotasEnArray(int[] notas) {
    for (int i = 0; i < notas.length; i++){
      notas[i] = ingresarNro("La nota del estudiante " + (i + 1));
    }
  }
  public static void mostrarNotas(int[] notas) {
    for (int i = 0; i< notas.length; i++) {
      LOG.info("La nota del estudiante " + (i+1) + " es " + notas[i]);
    }
  }

  public static int encontrarElMenor(int[] notas) {
    int menor = 10;
    for (int i = 0; i< notas.length; i++) {
      menor = (notas[i] < menor)? notas[i]:menor;
    }
    return menor;
  }
  public static int encontrarElMayor(int[] notas) {
    int mayor = 0;
    for (int i = 0; i< notas.length; i++) {
      mayor = (notas[i] > mayor)? notas[i]:mayor;
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
}