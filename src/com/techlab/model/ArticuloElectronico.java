package com.techlab.model;

public class ArticuloElectronico extends Articulo {
    private int garantiaMeses;

    //CONSTRUCTOR
    public ArticuloElectronico(int codigo, String nombre, double precio, Categoria categoria, int garantiaMeses) {
        super(codigo, nombre, precio, categoria);
        this.garantiaMeses = garantiaMeses;
    }

    //GETTERS
    public int getGarantiaMeses() {
        return this.garantiaMeses;
    }

    @Override 
    public String getTipoArticulo() {
        return "Electrónico";
    }

    @Override 
    public String getDetalleEspecifico() {
        return "Garantía= " + this.garantiaMeses + " meses.";
    }

    //SETTERS
    public void setGarantiaMeses(int garantiaMeses) {
        if(garantiaMeses < 0) {
            System.out.println("La cantidad de meses no puede ser menor a 0!.");
            return;
        }

        this.garantiaMeses = garantiaMeses;
    }

}
