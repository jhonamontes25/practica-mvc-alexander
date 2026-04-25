package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.InscripcionCurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InscripcionCursoDao {

    public void insertar(InscripcionCurso inscripcion) {
        String sql = "INSERT INTO inscripcion_curso (id_inscripcion, id_estudiante, id_grupo, nota_final, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, inscripcion.getIdInscripcion());
            stmt.setInt(2, inscripcion.getIdEstudiante());
            stmt.setInt(3, inscripcion.getIdGrupo());
            stmt.setDouble(4, inscripcion.getNotaFinal());
            stmt.setString(5, inscripcion.getEstado());

            stmt.executeUpdate();
            System.out.println("Inscripción registrada correctamente.");

        } catch (Exception e) {
            System.out.println("Error al insertar inscripción: " + e.getMessage());
        }
    }

    public List<InscripcionCurso> listar() {
        List<InscripcionCurso> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion_curso";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                InscripcionCurso inscripcion = new InscripcionCurso(
                        rs.getInt("id_inscripcion"),
                        rs.getInt("id_estudiante"),
                        rs.getInt("id_grupo"),
                        rs.getDouble("nota_final"),
                        rs.getString("estado")
                );

                inscripciones.add(inscripcion);
            }

        } catch (Exception e) {
            System.out.println("Error al listar inscripciones: " + e.getMessage());
        }

        return inscripciones;
    }
}