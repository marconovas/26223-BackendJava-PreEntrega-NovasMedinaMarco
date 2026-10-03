package com.techlab.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.techlab.model.Articulo;
import com.techlab.model.ArticuloAlimenticio;
import com.techlab.model.ArticuloElectronico;
import com.techlab.model.Categoria;

public class ArticuloService {
    
    //LISTAR ARTICULOS
    public void listarArticulos(ArrayList<Articulo> articulos) {
        if(articulos.isEmpty()) {
            System.out.println("La lista de artículos está vacía.");
            return;
        }

        for(Articulo articulo : articulos) {
            System.out.println(articulo);
        }
    }

    //BUSCAR ARTICULO POR NOMBRE
    public Articulo buscarArticuloPorNombre(ArrayList<Articulo> articulos, String articuloBuscado) {
        
        if(articulos.isEmpty()) {
            System.out.println("La lista de artículos está vacía.");
            return null;
        }
        
        for(Articulo articulo : articulos) {
            if(articulo.getNombre().equalsIgnoreCase(articuloBuscado)) {
                return articulo;
            }
        }

        return null;
    }

    //ACTUALIZAR ARTICULO
    public Articulo actualizarArticuloPorCodigo(Scanner scanner, ArrayList<Articulo> articulos, int codigoArticulo) {

        if(articulos.isEmpty()) {
            System.out.println("La lista de artículos está vacía.");
            return null;
        }

        Articulo articulo = buscarArticuloPorCodigo(articulos, codigoArticulo);

        if(articulo == null) {
            System.out.println("El articulo especificado no existe.");
            return null;
        }

        System.out.println("Ingrese nuevo nombre para el artículo: ");
        String nuevoNombreArticulo = scanner.nextLine();

        if(nuevoNombreArticulo.trim().isBlank()){
            System.out.println("El nombre del artículo no puede estar vacío.");
            return null;
        }

        articulo.setNombre(nuevoNombreArticulo);

        return articulo;
    }

    //ELIMINAR ARTICULO
    public boolean eliminarArticulo(ArrayList<Articulo> articulos, int codigo) {
       
        if(articulos.isEmpty()) {
            System.out.println("La lista de artículos está vacía.");
            return false;
        }
       
        Articulo articuloAEliminar = buscarArticuloPorCodigo(articulos, codigo);

        if(articuloAEliminar == null) {
            System.out.println("El articulo especificado no existe.");
            return false;
        }

        articulos.remove(articuloAEliminar);
        return true;
    }

    //CREAR ARTICULO
    public void crearArticulo(ArrayList<Articulo> articulos, ArrayList<Categoria> categorias, Scanner sc) {
        System.out.println("Ingrese código del artículo: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        //verificar si el codigo existe
        if(buscarArticuloPorCodigo(articulos, codigo) != null) {
            System.out.println("El articulo ya existe.");
            return;
        }

        System.out.println("Ingrese nombre del artículo: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese precio del artículo: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        System.out.println("Ingrese Categoría del artículo: ");
        String categoriaBuscada = sc.nextLine();

        Categoria categoria = buscarCategoria(categorias, categoriaBuscada);

        //verificar categoría existente
        if(categoria == null) {
            System.out.println("La categoria no existe.");
            return;
        }

        System.out.println("Ingrese tipo del artículo a ingresar (1: electrónico | 2.Alimenticio): ");
        int tipo = sc.nextInt();

        if(tipo == 1) {
            System.out.println("Ingrese garantía: ");
            int garantia = sc.nextInt();

            Articulo nuevoArticulo = new ArticuloElectronico(codigo, nombre, precio, categoria, garantia);
            
            articulos.add(nuevoArticulo);

            System.out.println("Artículo creado exitosamente.");
        }

        else if(tipo == 2) {
            System.out.println("Ingrese dias de vencimiento: ");
            int vencimiento = sc.nextInt();

            Articulo nuevoArticulo = new ArticuloAlimenticio(codigo, nombre, precio, categoria, vencimiento);
            
            articulos.add(nuevoArticulo);

            System.out.println("Artículo creado exitosamente.");
        }

        else{
            System.out.println("Debe ingresar el tipo especificado.");
            return;
        }

    }

    //BUSCAR ARTICULO POR CODIGO
    public Articulo buscarArticuloPorCodigo(ArrayList<Articulo> articulos, int codigo) {
        for(Articulo articulo : articulos) {
            if(articulo.getCodigo() == codigo) {
                return articulo;
            }
        }

        return null;
    }

    //BUSCAR CATEGORIA POR NOMBRE
    public Categoria buscarCategoria(ArrayList<Categoria> categorias, String categoriaBuscada) {

        for(Categoria categoria : categorias) {
            if(categoria.getNombre().equalsIgnoreCase(categoriaBuscada)) {
                return categoria;
            }
        }

        return null;
    }
}
