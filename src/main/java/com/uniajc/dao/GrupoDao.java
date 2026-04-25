package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Grupo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GrupoDao {

    public void insertar(Grupo grupo) {
        String sql = "INSERT INTO grupo (id_grupo, id_materia, id_docente, aula, horario) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, grupo.getIdGrupo());
            stmt.setInt(2, grupo.getIdMateria());
            stmt.setInt(3, grupo.getIdDocente());
            stmt.setString(4, grupo.getAula());
            stmt.setString(5, grupo.getHorario());

            stmt.executeUpdate();
            System.out.println("Grupo registrado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al insertar grupo: " + e.getMessage());
        }
    }

    public List<Grupo> listar() {
        List<Grupo> grupos = new ArrayList<>();
        String sql = "SELECT * FROM grupo";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Grupo grupo = new Grupo(
                        rs.getInt("id_grupo"),
                        rs.getInt("id_materia"),
                        rs.getInt("id_docente"),
                        rs.getString("aula"),
                        rs.getString("horario")
                );

                grupos.add(grupo);
            }

        } catch (Exception e) {
            System.out.println("Error al listar grupos: " + e.getMessage());
        }

        return grupos;
    }
}