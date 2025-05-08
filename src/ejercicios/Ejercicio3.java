package ejercicios;

import java.util.Scanner;
import java.util.logging.Logger;

public class Ejercicio3 {
  public static final Logger LOG =
      Logger.getLogger(Ejercicio3.class.getName());

  public static void main(String[] args) {
    /*
     * Ejercicio 3: Simular un inventario de productos (usar un array para nombres
     * y otro para cantidades).
     * Funciones para:
     * agregarProducto() (nombre y cantidad).
     * buscarProducto() (por nombre).
     * actualizarStock() (incrementar/disminuir).
     * mostrarInventario().
     * Validar que no se repitan productos (usar condicionales).
     */

    Scanner sc = new Scanner(System.in);
    LOG.info("Ingrese la cantidad de productos a cargar en el inventario: ");
    int cantProductos = sc.nextInt();
    sc.nextLine();

    String[] productos = new String[cantProductos];
    int[] cantidades = new int[cantProductos];

    boolean salir = false;

    while (!salir) {
      LOG.info("\n--- MENÚ DE INVENTARIO ---\n" +
          "1. Agregar productos\n" +
          "2. Buscar producto\n" +
          "3. Actualizar stock\n" +
          "4. Mostrar inventario\n" +
          "5. Salir");

      LOG.info("Seleccione una opción: ");
      int opcion = sc.nextInt();
      sc.nextLine();  // Limpiar el buffer

      switch (opcion) {
        case 1:
          agregarProducto(productos, cantidades);
          break;
        case 2:
          buscarProducto(productos);
          break;
        case 3:
          actualizarStock(productos, cantidades);
          break;
        case 4:
          mostrarInventario(productos, cantidades);
          break;
        case 5:
          salir = true;
          LOG.info("¡Gracias por usar el sistema de inventario!");
          break;
        default:
          LOG.info("Opción inválida. Intente nuevamente.");
      }
    }

  }

  public static void agregarProducto(String[] producto, int[] cantidad) {
    Scanner sc = new Scanner(System.in);
    String nombre;
    boolean duplicado;

    for (int i = 0; i < producto.length; i++) {
      do {
        duplicado = false;
        LOG.info("Ingrese el nombre del producto: ");
        nombre = sc.nextLine();

        for (int j = 0; j < i; j++) {
          if (producto[j].equalsIgnoreCase(nombre)) {
            LOG.info("El producto ya está registrado.");
            duplicado = true;
            break;
          }
        }

      } while (duplicado);

      producto[i] = nombre;

      LOG.info("Ingrese la cantidad del producto: ");
      cantidad[i] = sc.nextInt();
      sc.nextLine();
    }
  }

  public static void buscarProducto(String[] producto) {
    Scanner sc = new Scanner(System.in);
    LOG.info("Ingrese el nombre del producto a buscar: ");
    String nombre = sc.nextLine();
    boolean encontrado = false;

    for (String s : producto) {
      if (nombre.equalsIgnoreCase(s)) {
        LOG.info("El producto " + nombre + " se encuentra en stock.");
        encontrado = true;
        break;
      }
    }

    if (!encontrado) {
      LOG.info("El producto " + nombre + " no se encuentra en el inventario.");
    }
  }


  public static void actualizarStock(String[] productos, int[] cantidades) {
    Scanner sc = new Scanner(System.in);
    LOG.info("Ingrese el nombre del producto a actualizar:");
    String nombre = sc.nextLine();

    boolean encontrado = false;

    for (int i = 0; i < productos.length; i++) {
      if (productos[i].equalsIgnoreCase(nombre)) {
        encontrado = true;

        LOG.info("¿Desea aumentar o disminuir el stock? (a/d):");
        String opcion = sc.nextLine();

        LOG.info("Ingrese la cantidad:");
        int cantidad = sc.nextInt();
        sc.nextLine();
        if (opcion.equalsIgnoreCase("a")) {
          cantidades[i] += cantidad;
          LOG.info("Stock actualizado. Nuevo stock: " + cantidades[i]);
        } else if (opcion.equalsIgnoreCase("d")) {
          if (cantidades[i] >= cantidad) {
            cantidades[i] -= cantidad;
            LOG.info("Stock actualizado. Nuevo stock: " + cantidades[i]);
          } else {
            LOG.info("No se puede disminuir más de lo disponible.");
          }
        } else {
          LOG.info("Opción no válida.");
        }

        break;
      }
    }

    if (!encontrado) {
      LOG.info("Producto no encontrado en el inventario.");
    }
  }

  public static void mostrarInventario(String[] productos, int[] cantidades) {
    LOG.info("Inventario completo:");
    for (int i = 0; i < productos.length; i++) {
      LOG.info("Producto: " + productos[i] + " | Cantidad: " + cantidades[i]);
    }
  }

}
