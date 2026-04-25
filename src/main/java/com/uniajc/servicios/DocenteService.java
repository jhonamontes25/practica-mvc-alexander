package com.uniajc.servicios;

import com.uniajc.dao.DocenteDao;
import com.uniajc.modelo.Docente;

import java.util.List;

public class DocenteService {

    private DocenteDao docenteDao;

    public DocenteService() {
        this.docenteDao = new DocenteDao();
    }

    public void registrarDocente(Docente docente) {
        docenteDao.insertar(docente);
    }

    public List<Docente> listarDocentes() {
        return docenteDao.listar();
    }
}