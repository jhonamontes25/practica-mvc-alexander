package com.uniajc.vista;

import com.uniajc.controlador.ControladorMateria;
import com.uniajc.modelo.Materia;

import java.util.List;
import java.util.Scanner;

public class VistaMateria {

    private ControladorMateria controladorMateria;
    private Scanner scanner;

    public VistaMateria() {
        this.controladorMateria = new ControladorMateria();
        this.scanner = new Scanner(System.in);
    }

    public void menuMateria() {
        int opcion;

        do {
            System.out.println("\n--- MENU MATERIA ---");
            System.out.println("1. Registrar materia");
            System.out.println("2. Listar materias");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarMateria();
                    break;
                case 2:
                    listarMaterias();
                    break;
                case 0:
                    System.out.println("Saliendo del menu materia...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);
    }

    private void registrarMateria() {
        System.out.print("Ingrese ID de la materia: ");
        int idMateria = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese nombre de la materia: ");
        String nombreMateria = scanner.nextLine();

        System.out.print("Ingrese creditos: ");
        int creditos = scanner.nextInt();
        scanner.nextLine();

        controladorMateria.registrarMateria(idMateria, nombreMateria, creditos);
    }

    private void listarMaterias() {
        List<Materia> materias = controladorMateria.listarMaterias();

        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas.");
        } else {
            for (Materia materia : materias) {
                System.out.println(materia);
            }
        }
    }
}