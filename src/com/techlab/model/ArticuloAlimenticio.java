package com.techlab.model;

public class ArticuloAlimenticio extends Articulo {
    private int diasVencimiento;

    //CONSTRUCTOR
    public ArticuloAlimenticio(int codigo, String nombre, double precio, Categoria categoria, int diasVencimiento) {
        super(codigo, nombre, precio, categoria);
        this.diasVencimiento = diasVencimiento;
    }

    //GETTERS
    public int getDiasVencimiento() {
        return this.diasVencimiento;
    }

    //SETTERS
    public void setDiasVencimiento(int diasVencimiento) {
        if(diasVencimiento < 0) {
            System.out.println("Los dias de vencimiento no pueden ser negativos!.");
            return;
        }

        this.diasVencimiento = diasVencimiento;
    }

    //MÉTODOS
    @Override 
    public String getTipoArticulo() {
        return "Alimenticio";
    }

    @Override
    protected String getDetalleEspecifico() {
        return "Días hasta vencimiento= " + this.diasVencimiento + " días.";
    }
    
    @Override 
    public double calcularPrecioFinal() {
        if(diasVencimiento <= 3) {

            return getPrecio() * 0.80;
        
        } else if (diasVencimiento <= 7) {
        
            return getPrecio() * 0.90;
        
        }

        return getPrecio();
    }
}
