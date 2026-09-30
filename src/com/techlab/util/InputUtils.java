package com.techlab.util;

import java.util.Scanner;

public class InputUtils {
    //FORMATO
    public int formatearEntero(Scanner scanner, String mensaje) {
        while(true) {
            try{
                System.out.println(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Debe ingresar un número entero.");
            }
        }
    }

    public Double formatearDouble(Scanner scanner, String mensaje) {
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

    public String leerTextoNovacio(Scanner scanner, String mensaje) {
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
