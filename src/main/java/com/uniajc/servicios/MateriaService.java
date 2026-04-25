package com.uniajc.servicios;

import com.uniajc.dao.MateriaDao;
import com.uniajc.modelo.Materia;

import java.util.List;

public class MateriaService {

    private MateriaDao materiaDao;

    public MateriaService() {
        this.materiaDao = new MateriaDao();
    }

    public void registrarMateria(Materia materia) {
        materiaDao.insertar(materia);
    }

    public List<Materia> listarMaterias() {
        return materiaDao.listar();
    }
}