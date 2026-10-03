package com.techlab.articulo;

import java.util.ArrayList;
import java.util.Scanner;

import com.techlab.model.Articulo;
import com.techlab.model.Categoria;
import com.techlab.service.ArticuloService;
import com.techlab.service.CategoriaService;
import com.techlab.util.InputUtils;


public class App {
    public static void main(String[] args) {

        CategoriaService categoriaService = new CategoriaService();
        ArticuloService articuloService = new ArticuloService();
        InputUtils inputUtils = new InputUtils();

        Scanner sc = new Scanner(System.in);

        int opcion;

        ArrayList<Articulo> articulos = new ArrayList<>();
        ArrayList<Categoria> categorias = new ArrayList<>();

        do{
            mostrarMenuPrincipal();
            
            opcion = inputUtils.formatearEntero(sc, "Ingrese opción: ");

            switch (opcion) {
                case 1:
                    menuArticulos(sc, inputUtils, articuloService, categoriaService, articulos, categorias);
                    break;
                
                case 2:
                    menuCategorias(sc, inputUtils, categoriaService, categorias);
                    break;
                default:
                    System.out.println("Opción incorrecta, inténtelo nuevamente...");
                    break;
            }

        } while(opcion != 0);
        
        System.out.println("Terminando Programa...");

        sc.close();
    }
   
    //MOSTRAR MENU
    public static void mostrarMenuPrincipal() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Gestionar articulos");
        System.out.println("2. Gestionar categorías");
        System.out.println("0. Salir");
    }

    public static void mostrarMenuArticulos() {
        System.out.println("\n===== MENÚ ARTÍCULOS =====");
        System.out.println("1. Crear artículo");
        System.out.println("2. Listar artículos");
        System.out.println("3. Buscar artículo");
        System.out.println("4. Actualizar artículo");
        System.out.println("5. Eliminar artículo");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    public static void mostrarMenuCategorias() {
        System.out.println("\n===== MENÚ CATEGORÍAS =====");
        System.out.println("1. Crear categoría");
        System.out.println("2. Listar categorías");
        System.out.println("3. Buscar categorías");
        System.out.println("4. Actualizar categorías");
        System.out.println("5. Eliminar categoría");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void menuArticulos(Scanner sc, InputUtils inputUtils, ArticuloService articuloService, CategoriaService categoriaService, ArrayList<Articulo> articulos, ArrayList<Categoria> categorias) {
        int opcion;

        do{
            mostrarMenuArticulos();

            opcion = inputUtils.formatearEntero(sc, "Seleccione una opción: ");

            switch(opcion) {
                case 1:

                    articuloService.crearArticulo(articulos, categorias, sc, categoriaService);
                    break;

                case 2:

                    articuloService.listarArticulos(articulos);
                    break;

                case 3:

                    String articuloBuscado = inputUtils.leerTextoNovacio(sc, "Ingrese artículo a buscar: ");
                    
                    Articulo articuloEncontrado = articuloService.buscarArticuloPorNombre(articulos, articuloBuscado);

                    if(articuloEncontrado == null) {
                        System.out.println("El articulo ingresado no existe.");
                        break;
                    }

                    System.out.println(articuloEncontrado);

                    break;

                case 4:

                    int codigoArticuloBuscado = inputUtils.formatearEntero(sc, "Ingrese el código del articulo a modificar: ");

                    Articulo nuevoArticulo = articuloService.actualizarArticuloPorCodigo(sc, articulos, codigoArticuloBuscado);

                    if(nuevoArticulo != null) {
                        System.out.println("Articulo modificado exitosamente.");
                    }

                    break;

                case 5:

                    int codigoArticulo = inputUtils.formatearEntero(sc, "Ingrese el código del artículo a eliminar: ");

                    boolean eliminado = articuloService.eliminarArticulo(articulos, codigoArticulo);

                    if(eliminado) {
                        System.out.println("Articulo eliminado exitosamente.");
                    }

                    break;
                
                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida, intentelo nuevamente...");
            }

        } while (opcion != 0);

    }
    
    public static void menuCategorias(Scanner sc, InputUtils inputUtils, CategoriaService categoriaService, ArrayList<Categoria> categorias) {
        int opcion;

        do{
            mostrarMenuCategorias();

            opcion = inputUtils.formatearEntero(sc, "Seleccione una opción: ");

            switch(opcion) {
                case 1:

                    categoriaService.crearCategoria(sc, categorias);
                    break;

                case 2:

                    categoriaService.listarCategorias(categorias);
                    break;

                case 3:

                    String categoriaBuscada = inputUtils.leerTextoNovacio(sc, "Ingrese artículo a buscar: ");
                    
                    Categoria CategoriaEncontrada = categoriaService.buscarCategoriaPorNombre(categorias, categoriaBuscada); 

                    if(CategoriaEncontrada == null) {
                        System.out.println("La categoria ingresada no existe.");
                        break;
                    }

                    System.out.println(CategoriaEncontrada);

                    break;

                case 4:

                    int codigoCategoriaBuscada = inputUtils.formatearEntero(sc, "Ingrese el código del articulo a modificar: ");

                    Categoria categoriaAModificar = categoriaService.buscarCategoriaPorCodigo(categorias, codigoCategoriaBuscada);

                    if(categoriaAModificar != null) {
                        System.out.println("Articulo modificado exitosamente.");
                    }

                    break;

                case 5:

                    int codigoCategoria = inputUtils.formatearEntero(sc, "Ingrese el código del artículo a eliminar: ");

                    boolean eliminado = categoriaService.eliminarCategoria(categorias, codigoCategoria);

                    if(eliminado) {
                        System.out.println("Categoría eliminada exitosamente.");
                    }

                    break;
                
                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida, intentelo nuevamente...");
            }

        } while (opcion != 0);

    }
}
    
