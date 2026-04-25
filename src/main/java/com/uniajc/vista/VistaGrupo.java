package com.uniajc.vista;

import com.uniajc.controlador.ControladorGrupo;
import com.uniajc.modelo.Grupo;

import java.util.List;
import java.util.Scanner;

public class VistaGrupo {

    private ControladorGrupo controladorGrupo;
    private Scanner scanner;

    public VistaGrupo() {
        this.controladorGrupo = new ControladorGrupo();
        this.scanner = new Scanner(System.in);
    }

    public void menuGrupo() {
        int opcion;

        do {
            System.out.println("\n--- MENU GRUPO ---");
            System.out.println("1. Registrar grupo");
            System.out.println("2. Listar grupos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarGrupo();
                    break;
                case 2:
                    listarGrupos();
                    break;
                case 0:
                    System.out.println("Saliendo del menu grupo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);
    }

    private void registrarGrupo() {
        System.out.print("Ingrese ID del grupo: ");
        int idGrupo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese ID de la materia: ");
        int idMateria = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese ID del docente: ");
        int idDocente = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese aula: ");
        String aula = scanner.nextLine();

        System.out.print("Ingrese horario: ");
        String horario = scanner.nextLine();

        controladorGrupo.registrarGrupo(idGrupo, idMateria, idDocente, aula, horario);
    }

    private void listarGrupos() {
        List<Grupo> grupos = controladorGrupo.listarGrupos();

        if (grupos.isEmpty()) {
            System.out.println("No hay grupos registrados.");
        } else {
            for (Grupo grupo : grupos) {
                System.out.println(grupo);
            }
        }
    }
}