package com.uniajc.vista;

import com.uniajc.controlador.ControladorDocente;
import com.uniajc.modelo.Docente;

import java.util.List;
import java.util.Scanner;

public class VistaDocente {

    private ControladorDocente controladorDocente;
    private Scanner scanner;

    public VistaDocente() {
        this.controladorDocente = new ControladorDocente();
        this.scanner = new Scanner(System.in);
    }

    public void menuDocente() {
        int opcion;

        do {
            System.out.println("\n--- MENU DOCENTE ---");
            System.out.println("1. Registrar docente");
            System.out.println("2. Listar docentes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarDocente();
                    break;
                case 2:
                    listarDocentes();
                    break;
                case 0:
                    System.out.println("Saliendo del menu docente...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);
    }

    private void registrarDocente() {
        System.out.print("Ingrese ID del docente: ");
        int idDocente = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese nombre del docente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese especialidad: ");
        String especialidad = scanner.nextLine();

        controladorDocente.registrarDocente(idDocente, nombre, especialidad);
    }

    private void listarDocentes() {
        List<Docente> docentes = controladorDocente.listarDocentes();

        if (docentes.isEmpty()) {
            System.out.println("No hay docentes registrados.");
        } else {
            for (Docente docente : docentes) {
                System.out.println(docente);
            }
        }
    }
}