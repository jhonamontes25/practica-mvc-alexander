package com.uniajc.servicios;

import com.uniajc.dao.InscripcionCursoDao;
import com.uniajc.modelo.InscripcionCurso;

import java.util.List;

public class InscripcionCursoService {

    private InscripcionCursoDao inscripcionCursoDao;

    public InscripcionCursoService() {
        this.inscripcionCursoDao = new InscripcionCursoDao();
    }

    public void registrarInscripcion(InscripcionCurso inscripcion) {
        inscripcionCursoDao.insertar(inscripcion);
    }

    public List<InscripcionCurso> listarInscripciones() {
        return inscripcionCursoDao.listar();
    }
}