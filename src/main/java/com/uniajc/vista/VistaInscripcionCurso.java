package com.uniajc.vista;

import com.uniajc.controlador.ControladorInscripcionCurso;
import com.uniajc.modelo.InscripcionCurso;

import java.util.List;
import java.util.Scanner;

public class VistaInscripcionCurso {

    private ControladorInscripcionCurso controladorInscripcionCurso;
    private Scanner scanner;

    public VistaInscripcionCurso() {
        this.controladorInscripcionCurso = new ControladorInscripcionCurso();
        this.scanner = new Scanner(System.in);
    }

    public void menuInscripcionCurso() {
        int opcion;

        do {
            System.out.println("\n--- MENU INSCRIPCION CURSO ---");
            System.out.println("1. Registrar inscripción");
            System.out.println("2. Listar inscripciones");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarInscripcion();
                    break;
                case 2:
                    listarInscripciones();
                    break;
                case 0:
                    System.out.println("Saliendo del menu inscripción...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);
    }

    private void registrarInscripcion() {
        System.out.print("Ingrese ID de inscripción: ");
        int idInscripcion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese ID del estudiante: ");
        int idEstudiante = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese ID del grupo: ");
        int idGrupo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese nota final: ");
        double notaFinal = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese estado: ");
        String estado = scanner.nextLine();

        controladorInscripcionCurso.registrarInscripcion(
                idInscripcion,
                idEstudiante,
                idGrupo,
                notaFinal,
                estado
        );
    }

    private void listarInscripciones() {
        List<InscripcionCurso> inscripciones = controladorInscripcionCurso.listarInscripciones();

        if (inscripciones.isEmpty()) {
            System.out.println("No hay inscripciones registradas.");
        } else {
            for (InscripcionCurso inscripcion : inscripciones) {
                System.out.println(inscripcion);
            }
        }
    }
}