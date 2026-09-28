package com.techlab.articulo;

import java.util.ArrayList;
import java.util.Scanner;

import com.techlab.model.Articulo;
import com.techlab.model.ArticuloAlimenticio;
import com.techlab.model.ArticuloElectronico;
import com.techlab.model.Categoria;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;

        ArrayList<Articulo> articulos = new ArrayList<>();
        ArrayList<Categoria> categorias = new ArrayList<>();

        //TEMP
        categorias.add(new Categoria(1, "Alimentos", "Productos alimenticios"));
        categorias.add(new Categoria(2, "Electrónica", "Productos electrónicos"));

        do{
            mostrarMenu();

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:

                    crearArticulo(articulos, categorias, sc);
                    break;

                case 2:

                    listarArticulos(articulos);
                    break;

                case 3:

                    System.out.println("Ingrese artícul a buscar: ");
                    String articuloBuscado = sc.nextLine();
                    
                    Articulo articuloEncontrado = buscarArticuloPorNombre(articulos, articuloBuscado);

                    if(articuloEncontrado == null) {
                        System.out.println("El articulo ingresado no existe.");
                        break;
                    }

                    System.out.println(articuloEncontrado);

                    break;

                case 4:

                    System.out.println("ingrese articulo a modificar: ");
                    String articuloABuscar = sc.nextLine();

                    if(articuloABuscar.trim().isBlank()) {
                        System.out.println("El nombre del articulo a buscar no debe estar vacío.");
                        break;
                    }

                    Articulo nuevoArticulo = actualizarArticuloPorNombre(sc, articulos, articuloABuscar);

                    if(nuevoArticulo != null) {
                        System.out.println("Articulo modificado exitosamente.");
                    }

                    break;

                case 5:

                    System.out.println("Ingrese artículo a eliminar: ");
                    String nombreArticulo = sc.nextLine();

                    boolean eliminado = eliminarArticulo(articulos, nombreArticulo);

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

        sc.close();
    }

    //MOSTRAR MENU
    public static void mostrarMenu() {
        System.out.println("\n===== MENÚ =====");
        System.out.println("1. Crear artículo");
        System.out.println("2. Listar artículos");
        System.out.println("3. Buscar artículo");
        System.out.println("4. Actualizar artículo");
        System.out.println("5. Eliminar artículo");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    //LISTAR ARTICULOS
    public static void listarArticulos(ArrayList<Articulo> articulos) {
        for(Articulo articulo : articulos) {
            System.out.println(articulo);
        }
    }

    //BUSCAR ARTICULO POR NOMBRE
    public static Articulo buscarArticuloPorNombre(ArrayList<Articulo> articulos, String articuloBuscado) {
        for(Articulo articulo : articulos) {
            if(articulo.getNombre().equalsIgnoreCase(articuloBuscado)) {
                return articulo;
            }
        }

        return null;
    }

    //ACTUALIZAR ARTICULO
    public static Articulo actualizarArticuloPorNombre(Scanner scanner, ArrayList<Articulo> articulos, String articuloBuscado) {

        Articulo articulo = buscarArticuloPorNombre(articulos, articuloBuscado);

        if(articulo == null) {
            System.out.println("El articulo especificado no existe.");
            return null;
        }

        System.out.println("Ingrese nuevo nombre para el artículo: ");
        String nuevoNombreArticulo = scanner.nextLine();

        articulo.setNombre(nuevoNombreArticulo);

        return articulo;
    }

    //ELIMINAR ARTICULO
    public static boolean eliminarArticulo(ArrayList<Articulo> articulos, String nombreArticulo) {
        Articulo articuloAEliminar = buscarArticuloPorNombre(articulos, nombreArticulo);

        if(articuloAEliminar == null) {
            System.out.println("El articulo especificado no existe.");
            return false;
        }

        articulos.remove(articuloAEliminar);
        return true;
    }

    //CREAR ARTICULO
    public static void crearArticulo(ArrayList<Articulo> articulos, ArrayList<Categoria> categorias, Scanner sc) {
        System.out.println("Ingrese código del artículo: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        //verificar si el codigo existe
        if(buscarCodigoArticulo(articulos, codigo) != null) {
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

            System.out.println("Artículo creado exitsamente.");
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
    public static Articulo buscarCodigoArticulo(ArrayList<Articulo> articulos, int codigo) {
        for(Articulo articulo : articulos) {
            if(articulo.getCodigo() == codigo) {
                return articulo;
            }
        }

        return null;
    }

    //BUSCAR CATEGORIA POR NOMBRE
    public static Categoria buscarCategoria(ArrayList<Categoria> categorias, String categoriaBuscada) {

        for(Categoria categoria : categorias) {
            if(categoria.getNombre().equalsIgnoreCase(categoriaBuscada)) {
                return categoria;
            }
        }

        return null;
    }
}
