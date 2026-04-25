package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Materia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MateriaDao {

    public void insertar(Materia materia) {
        String sql = "INSERT INTO materia (id_materia, nombre_materia, creditos) VALUES (?, ?, ?)";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, materia.getIdMateria());
            stmt.setString(2, materia.getNombreMateria());
            stmt.setInt(3, materia.getCreditos());

            stmt.executeUpdate();
            System.out.println("Materia registrada correctamente.");

        } catch (Exception e) {
            System.out.println("Error al insertar materia: " + e.getMessage());
        }
    }

    public List<Materia> listar() {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Materia materia = new Materia(
                        rs.getInt("id_materia"),
                        rs.getString("nombre_materia"),
                        rs.getInt("creditos")
                );

                materias.add(materia);
            }

        } catch (Exception e) {
            System.out.println("Error al listar materias: " + e.getMessage());
        }

        return materias;
    }
}