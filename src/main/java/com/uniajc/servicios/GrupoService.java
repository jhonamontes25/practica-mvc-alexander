package com.uniajc.servicios;

import com.uniajc.dao.GrupoDao;
import com.uniajc.modelo.Grupo;

import java.util.List;

public class GrupoService {

    private GrupoDao grupoDao;

    public GrupoService() {
        this.grupoDao = new GrupoDao();
    }

    public void registrarGrupo(Grupo grupo) {
        grupoDao.insertar(grupo);
    }

    public List<Grupo> listarGrupos() {
        return grupoDao.listar();
    }
}