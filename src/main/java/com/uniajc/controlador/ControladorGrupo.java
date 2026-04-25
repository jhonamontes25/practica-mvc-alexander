package com.uniajc.controlador;

import com.uniajc.modelo.Grupo;
import com.uniajc.servicios.GrupoService;

import java.util.List;

public class ControladorGrupo {

    private GrupoService grupoService;

    public ControladorGrupo() {
        this.grupoService = new GrupoService();
    }

    public void registrarGrupo(int idGrupo, int idMateria, int idDocente, String aula, String horario) {
        Grupo grupo = new Grupo(idGrupo, idMateria, idDocente, aula, horario);
        grupoService.registrarGrupo(grupo);
    }

    public List<Grupo> listarGrupos() {
        return grupoService.listarGrupos();
    }
}