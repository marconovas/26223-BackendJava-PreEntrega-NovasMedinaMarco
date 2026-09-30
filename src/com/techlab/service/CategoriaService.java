package com.techlab.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.techlab.model.Categoria;
import com.techlab.util.InputUtils;

public class CategoriaService {
    InputUtils inputUtils = new InputUtils();

   public Categoria crearCategoria(Scanner scanner, ArrayList<Categoria> categorias) {
        int codigo = inputUtils.formatearEntero(scanner, "Ingrese código:"); 

        Categoria existente = buscarCategoriaPorCodigo(categorias, codigo);

        if(existente != null) {
            System.out.println("La categoria ya existe.");
            return null;
        }

        String nombre = inputUtils.leerTextoNovacio(scanner, "Ingrese nombre de la categoría");

        String descripcion = inputUtils.leerTextoNovacio(scanner, "Ingrese descripcion de categoría: ");

        Categoria nuevaCategoria = new Categoria(codigo, nombre, descripcion);

        categorias.add(nuevaCategoria);

        System.out.println("La categoria se ha creado exitosamente.");

        return nuevaCategoria;

   }

   public Categoria actualizarCategoria(Scanner scanner, ArrayList<Categoria> categorias, int codigo) {
        Categoria encontrada = buscarCategoriaPorCodigo(categorias, codigo);
        
        if(encontrada == null) {
            System.out.println("La categoria buscada no existe.");
            return null;
        }

        String nuevoNombre = inputUtils.leerTextoNovacio(scanner, "Ingrese nombre de categoría: ");
        
        String nuevaDescripcion = inputUtils.leerTextoNovacio(scanner, "Ingrese descripción: ");

        encontrada.setNombre(nuevoNombre);
        encontrada.setDescripcion(nuevaDescripcion);

        System.out.println("La categoria se ha modificado exitosamente.");
        return encontrada;

   }



   public void listarCategorias(ArrayList<Categoria> categorias) {
        if(categorias.isEmpty()) {
            System.out.println("No hay categorias ingresadas.");
            return;
        }

        for(Categoria categoria : categorias) {
            System.out.println(categoria);
        }
   }

    
   public Categoria buscarCategoriaPorCodigo(ArrayList<Categoria> categorias, int codigo) {
        if(categorias.isEmpty()) {
            System.out.println("No hay categorias ingresadas.");
            return null;
        }

        for(Categoria categoria : categorias) {
            if(categoria.getCodigo() == codigo) {
                return categoria;
            }
        }

        return null;
   }

   public boolean eliminarCategoria(ArrayList<Categoria> categorias, int codigo) {
        Categoria encontrada = buscarCategoriaPorCodigo(categorias, codigo);

        if(encontrada == null) {
            System.out.println("La categoria buscada no existe.");
            return false;
        }

        categorias.remove(encontrada);

        System.out.println("La categoria se ha eliminado exitosamente.");
        return true;
   }
}
