package com.uniajc.dao;

import com.uniajc.config.ConexionPostgresDatabase;
import com.uniajc.modelo.Docente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocenteDao {

    public void insertar(Docente docente) {
        String sql = "INSERT INTO docente (id_docente, nombre, especialidad) VALUES (?, ?, ?)";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, docente.getIdDocente());
            stmt.setString(2, docente.getNombre());
            stmt.setString(3, docente.getEspecialidad());

            stmt.executeUpdate();
            System.out.println("Docente registrado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al insertar docente: " + e.getMessage());
        }
    }

    public List<Docente> listar() {
        List<Docente> docentes = new ArrayList<>();
        String sql = "SELECT * FROM docente";

        try (Connection conn = ConexionPostgresDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Docente docente = new Docente(
                        rs.getInt("id_docente"),
                        rs.getString("nombre"),
                        rs.getString("especialidad")
                );

                docentes.add(docente);
            }

        } catch (Exception e) {
            System.out.println("Error al listar docentes: " + e.getMessage());
        }

        return docentes;
    }
}