package com.techlab;
import com.techlab.productos.Bebidas;
import com.techlab.productos.Comidas;
import com.techlab.productos.Decoracion;
import com.techlab.productos.Productos;
import com.techlab.productos.ServicioDeProductos;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in).useLocale(Locale.US); // Esto último es para los puntos decimales en el precio, si no se coloca, el programa tira error al ingresar el punto.
    static ServicioDeProductos servicio = new ServicioDeProductos();

    static void mostrarMenu() {
        System.out.println("Bienvenido a: \n");
        System.out.println("=======SISTEMA DE GESTIÓN - TECHLAB=======");
        System.out.println("|                                        |");  
        System.out.println("|   1)      Agregar producto             |");
        System.out.println("|   2)      Listar productos             |");
        System.out.println("|   3)      Buscar/actualizar productos  |");
        System.out.println("|   4)      Eliminar producto            |");
        System.out.println("|   5)      Crear un pedido              |");
        System.out.println("|   6)      Listar pedidos               |");
        System.out.println("|   7)      Salir                        |");
        System.out.println("|________________________________________|");
    }

    static void agregarProductos() {
        System.out.println("¿Qué tipo de producto desea agregar?");
        System.out.println("1) Comida");
        System.out.println("2) Decoración");
        System.out.println("3) Bebidas");
        System.out.println("4) Otra variedad de producto");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el nombre del producto:");
        String productoNombre = sc.nextLine();
        System.out.println("Ingrese el precio de dicho producto:");
        double productoPrecio = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese el stock del producto:");
        int productoStock = sc.nextInt();
        sc.nextLine();

        switch (tipo) {
            case 1: 
                System.out.println("Fecha de vencimiento (AAAA/MM/DD): ");
                LocalDate fecha = LocalDate.parse(sc.nextLine());
                servicio.agregarProducto(new Comidas(productoNombre, productoPrecio, productoStock, fecha));
                break;
            case 2:
                System.out.println("Ingrese los centimetros del producto: ");
                System.out.println("Base: ");
                double base = sc.nextDouble();
                sc.nextLine();
                System.out.println("Altura: ");
                double altura = sc.nextDouble();
                sc.nextLine();
                System.out.println("Profundidad: ");
                double profundidad = sc.nextDouble();
                sc.nextLine();
                servicio.agregarProducto(new Decoracion(productoNombre, productoPrecio, productoStock, base, altura, profundidad));
                break;
            case 3:
                System.out.println("Ingrese el volumen del producto en mL: ");
                int mL = sc.nextInt();
                sc.nextLine();
                servicio.agregarProducto(new Bebidas(productoNombre, productoPrecio, productoStock, mL));
                break;
            case 4:
                servicio.agregarProducto(new Productos(productoNombre, productoPrecio, productoStock));
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    static void buscarActualizar() {
        System.out.println("Ingrese el ID del producto que desea actualizar o buscar: ");
        int id = sc.nextInt();
        Productos p = servicio.buscarPorID(id);

        if( p == null) {
            System.out.println("No se encontró el producto con el ID: " + id);
        
        System.out.println("ID: " + p.getID() + ". ¿Qué desea actualizar?");
        System.out.println(" 1) Precio");
        System.out.println(" 2) Stock");
        int actualizacion = sc.nextInt();
        sc.nextLine();
        }
    }
    
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            System.out.println("Escoja una opción: ");
            opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    agregarProductos();
                    break;
                case 3:
                    buscarActualizar();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }while(opcion != 7);
    }
}
