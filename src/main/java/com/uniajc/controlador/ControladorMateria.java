package com.uniajc.controlador;

import com.uniajc.modelo.Materia;
import com.uniajc.servicios.MateriaService;

import java.util.List;

public class ControladorMateria {

    private MateriaService materiaService;

    public ControladorMateria() {
        this.materiaService = new MateriaService();
    }

    public void registrarMateria(int idMateria, String nombreMateria, int creditos) {
        Materia materia = new Materia(idMateria, nombreMateria, creditos);
        materiaService.registrarMateria(materia);
    }

    public List<Materia> listarMaterias() {
        return materiaService.listarMaterias();
    }
}