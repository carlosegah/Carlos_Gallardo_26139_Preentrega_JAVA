package com.techlab.productos;
import java.util.ArrayList;


public class ServicioDeProductos {
    private final ArrayList<Productos> articulos = new ArrayList<>();

    public void agregarProducto(Productos producto) {
        articulos.add(producto);
        System.out.println("El producto: " + producto.getNombre() + " ha sido ingresado.");
    }

    public void listarProductos() {
        if(!articulos.isEmpty()) {
            System.out.println("-------LISTA DE PRODUCTOS-------");
            for(Productos p : articulos) {
                System.out.println(p);
            }
        }else{
            System.out.println("No se encontraron productos registrados.");
        }
    }

    public Productos buscarPorID (int id) {
        for(Productos p : articulos) {
            if(p.getID() == id) {
                return p;
            }
        }
        return null;
    }

    public Productos buscarPorNombre(String nombre) {
        for(Productos p : articulos) {
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        return null;
    }

    public void actualizarPrecio(int id, double nuevoPrecio) {
        Productos p = buscarPorID(id);
        if( p == null ) {
            System.out.println("No se encontró el producto con dicho id.");
        }else{
            p.setPrecios(nuevoPrecio);
            System.out.println("El precio ha sido actualizado a: $" + nuevoPrecio);
        }
    }

    public void actualizarStock(int id, int nuevoStock) {
        Productos p = buscarPorID(id);
        if( p == null ) {
            System.out.println("No se encontró el producto con dicho id.");
        }else{
            p.setStock(nuevoStock);
            System.out.println("El stock ha sido actualizado a: " + nuevoStock);
        }
    }

    public void eliminarProducto(int id) {
        Productos p = buscarPorID(id);
        if(p == null) {
            System.out.println("El producto ya ha sido eliminado o no existía.");
        }else{
            articulos.remove(p);
            System.out.println("El producto: " + p.getNombre() + " [id: " + p.getID() + "] ha sido eliminado.");
        }
    }
}
