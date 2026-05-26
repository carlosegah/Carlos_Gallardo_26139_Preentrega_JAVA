package com.techlab.productos;

public abstract class bebidas extends productos {
    private int mL;
    
    public bebidas(String nombre, double precio, int stock, int mL) {
        super(nombre, precio, stock);
        this.mL = mL;
    }

    public int getmL() {
        return mL;
    }

    public void setmL(int mL) {
        if(mL <= 0) {
            throw new IllegalArgumentException("El volumen en mL debe ser mayor a 0mL");
        }
        this.mL = mL;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (Vol: %dmL)", mL);
    }
}
