package com.uniajc.controlador;

import com.uniajc.modelo.InscripcionCurso;
import com.uniajc.servicios.InscripcionCursoService;

import java.util.List;

public class ControladorInscripcionCurso {

    private InscripcionCursoService inscripcionCursoService;

    public ControladorInscripcionCurso() {
        this.inscripcionCursoService = new InscripcionCursoService();
    }

    public void registrarInscripcion(int idInscripcion, int idEstudiante, int idGrupo, double notaFinal, String estado) {
        InscripcionCurso inscripcion = new InscripcionCurso(
                idInscripcion,
                idEstudiante,
                idGrupo,
                notaFinal,
                estado
        );

        inscripcionCursoService.registrarInscripcion(inscripcion);
    }

    public List<InscripcionCurso> listarInscripciones() {
        return inscripcionCursoService.listarInscripciones();
    }
}