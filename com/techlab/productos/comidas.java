package com.techlab.productos;
import java.time.LocalDate;

public class Comidas extends Productos {
    private LocalDate fechaVencimiento;

    public Comidas(String nombre, double precio, int stock, LocalDate fechaVencimiento) {
        super(nombre, precio, stock);
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean caducado() {
        return LocalDate.now().isAfter(fechaVencimiento);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [Vence el: %s%s]", fechaVencimiento, caducado() ? "¡Vencido!" : "");
    }
}
    