package com.techlab.productos;

public class productos {
    private static int acumuladorId = 1;
    private final int id;
    private final String nombre;
    private double precio;
    private int stock;

    public productos(String nombre, double precio, int stock) {
        this.id = acumuladorId++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getID() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setPrecioStock(double precio, int stock) {
        if(stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        if(precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("[ID %d] %-20s | Precio $%-10.1f | Stock: %d", id, nombre, precio, stock);
    }
}
