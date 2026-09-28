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

        do{
            mostrarMenu();

            opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    crearArticulo(articulos, categorias, sc);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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
        String cat = sc.nextLine();

        //verificar categoría existente
        if(buscarCategoria(categorias, cat) == null) {
            System.out.println("La categoria no existe.");
            return;
        }

        System.out.println("Ingrese tipo del artículo a ingresar (1: electrónico | 2.Alimenticio): ");
        int tipo = sc.nextInt();

        if(tipo == 1) {
            System.out.println("Ingrese garantía: ");
            int garantia = sc.nextInt();

            Articulo nuevoArticulo = new ArticuloElectronico(codigo, nombre, precio, null, garantia);
            
            articulos.add(nuevoArticulo);
        }

        else if(tipo == 2) {
            System.out.println("Ingrese dias de vencimiento: ");
            int vencimiento = sc.nextInt();

            Articulo nuevoArticulo = new ArticuloAlimenticio(codigo, nombre, precio, null, vencimiento);
            
            articulos.add(nuevoArticulo);
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
