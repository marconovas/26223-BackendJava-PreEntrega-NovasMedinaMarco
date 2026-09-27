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

    @Override 
    public String getTipoArticulo() {
        return "Alimenticio";
    }

    @Override
    protected String getDetalleEspecifico() {
        return "Días hasta vencimiento= " + this.diasVencimiento + " días.";
    }

    //SETTERS
    public void setDiasVencimiento(int diasVencimiento) {
        if(diasVencimiento < 0) {
            System.out.println("Los dias de vencimiento no pueden ser negativos!.");
            return;
        }

        this.diasVencimiento = diasVencimiento;
    }
}
