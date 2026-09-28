package com.techlab.model;

import com.techlab.articulo.interfaces.Calculable;

public abstract class Articulo implements  Calculable{

    private int codigo;
    private String nombre;
    private double precio;
    private Categoria categoria;

    public Articulo(int codigo, String nombre, double precio, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    @Override 
    public String toString() {
        return "Tipo: " + getTipoArticulo() + "codigo= " + this.codigo + ", nombre= " + this.nombre +
        ", precio = " + this.precio + ", categoria= " + this.categoria + ", " + getDetalleEspecifico();
    }

    //GETTERS
    public int getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public abstract String getTipoArticulo();

    protected abstract String getDetalleEspecifico();

    //SETTERS
    public void setCodigo(int codigo) {
        if(codigo < 0) {
            System.out.println("El codigo no puede ser negativo.");
            return;
        }

        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.isBlank()) {
            System.out.println("El nombre del articulo no debe estar vacío.");
            return; 
        }

        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if(precio < 0) {
            System.out.println("El precio no puede ser negativo.");
            return;
        }

        this.precio = precio;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
