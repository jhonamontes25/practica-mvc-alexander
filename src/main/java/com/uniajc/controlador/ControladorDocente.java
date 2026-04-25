package com.uniajc.controlador;

import com.uniajc.modelo.Docente;
import com.uniajc.servicios.DocenteService;

import java.util.List;

public class ControladorDocente {

    private DocenteService docenteService;

    public ControladorDocente() {
        this.docenteService = new DocenteService();
    }

    public void registrarDocente(int idDocente, String nombre, String especialidad) {
        Docente docente = new Docente(idDocente, nombre, especialidad);
        docenteService.registrarDocente(docente);
    }

    public List<Docente> listarDocentes() {
        return docenteService.listarDocentes();
    }
}