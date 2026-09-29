package com.techlab.articulo;

import java.util.ArrayList;
import java.util.Scanner;

import com.techlab.model.Articulo;
import com.techlab.model.Categoria;
import com.techlab.service.ArticuloService;

public class App {
    public static void main(String[] args) {

        ArticuloService articuloService = new ArticuloService();

        Scanner sc = new Scanner(System.in);

        int opcion;

        ArrayList<Articulo> articulos = new ArrayList<>();
        ArrayList<Categoria> categorias = new ArrayList<>();

        //TEMP
        categorias.add(new Categoria(1, "Alimentos", "Productos alimenticios"));
        categorias.add(new Categoria(2, "Electrónica", "Productos electrónicos"));

        do{
            mostrarMenu();

            opcion = formatearEntero(sc, "Seleccione una opción: ");

            switch(opcion) {
                case 1:

                    articuloService.crearArticulo(articulos, categorias, sc);
                    break;

                case 2:

                    articuloService.listarArticulos(articulos);
                    break;

                case 3:

                    String articuloBuscado = leerTextoNovacio(sc, "Ingrese artículo a buscar: ");
                    
                    Articulo articuloEncontrado = articuloService.buscarArticuloPorNombre(articulos, articuloBuscado);

                    if(articuloEncontrado == null) {
                        System.out.println("El articulo ingresado no existe.");
                        break;
                    }

                    System.out.println(articuloEncontrado);

                    break;

                case 4:

                    int codigoArticuloBuscado = formatearEntero(sc, "Ingrese el código del articulo a modificar: ");

                    Articulo nuevoArticulo = articuloService.actualizarArticuloPorCodigo(sc, articulos, codigoArticuloBuscado);

                    if(nuevoArticulo != null) {
                        System.out.println("Articulo modificado exitosamente.");
                    }

                    break;

                case 5:

                    int codigoArticulo = formatearEntero(sc, "Ingrese el código del artículo a eliminar: ");

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

    //FORMATO
    public static int formatearEntero(Scanner scanner, String mensaje) {
        while(true) {
            try{
                System.out.println(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Debe ingresar un número entero.");
            }
        }
    }

    public static Double formatearDouble(Scanner scanner, String mensaje) {
        while(true) {
            try{
                System.out.println(mensaje);
                double valor =  Double.parseDouble(scanner.nextLine());

                if(valor < 0) {
                    System.out.println("El valor ingresado No debe ser negativo");
                    continue;
                }

                return valor;

            } catch(NumberFormatException e) {
                System.out.println("Debe ingresar un número decimal.");
            }
        }
    }

    public static String leerTextoNovacio(Scanner scanner, String mensaje) {
        while(true) {
            System.out.println(mensaje);
            String texto = scanner.nextLine();

            if(!texto.trim().isEmpty()) {
                return texto.trim();
            }

            System.out.println("El texto ingresado no puede estar en blanco.");
        }
    }
}
