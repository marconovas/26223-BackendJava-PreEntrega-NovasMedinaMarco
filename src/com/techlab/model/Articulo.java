package com.techlab.model;

public abstract class Articulo {

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
            return;
        }

        this.precio = precio;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
