package com.techlab.productos;

public class Decoracion extends Productos {
    private double base;
    private double altura;
    private double profundidad;

    public Decoracion(String nombre, double precio, int stock, double base, double altura, double profundidad ) {
        super(nombre, precio, stock);
        this.base = base;
        this.altura = altura;
        this.profundidad = profundidad;
    }

    public double getBase() {
        return base;
    }
    public double getAltura() {
        return altura;
    }
    public double getProfundidad() {
        return profundidad;
    }

    public void setMedidas(double base, double altura, double profundidad) {
        if(altura <= 0 || base <= 0  || profundidad <= 0) {
            throw new IllegalArgumentException("La medida en centímetros no debe ser negativa");
        }
        this.base = base;
        this.altura = altura;
        this.profundidad = profundidad;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (Medida: %.2fx%.2fx%.2f)", base, altura, profundidad);
    }
}
    