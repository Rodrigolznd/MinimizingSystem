package com.miempresa.dao;

import com.miempresa.modelo.Usuario;
import com.miempresa.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que realiza operaciones CRUD en la tabla 'usuarios'.
 */
public class UsuarioDAO {

    /**
     * Inserta un nuevo usuario en la base de datos.
     * @param usuario Objeto Usuario a insertar.
     * @return true si se insertó correctamente, false en caso contrario.
     */
    public boolean insertarUsuario(Usuario usuario) {
        String query = "INSERT INTO usuario (NombreCompleto, username, email, hashed_password, activo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombreCompleto());
            stmt.setString(2, usuario.getUsername());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getHashedPassword());
            stmt.setBoolean(5, usuario.isActivo());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Obtiene todos los usuarios de la base de datos.
     * @return Lista de usuarios.
     */
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("NombreCompleto"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("hashed_password"),
                    rs.getBoolean("activo")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    /**
     * Actualiza los datos de un usuario existente.
     * @param usuario Objeto Usuario con los datos actualizados.
     * @return true si se actualizó correctamente, false en caso contrario.
     */
    public boolean actualizarUsuario(Usuario usuario) {
        String query = "UPDATE usuario SET NombreCompleto = ?, username = ?, email = ?, hashed_password = ?, activo = ? WHERE id_usuario = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombreCompleto());
            stmt.setString(2, usuario.getUsername());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getHashedPassword());
            stmt.setBoolean(5, usuario.isActivo());
            stmt.setInt(6, usuario.getIdUsuario());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Elimina un usuario por su ID.
     * @param idUsuario ID del usuario a eliminar.
     * @return true si se eliminó correctamente, false en caso contrario.
     */
    public boolean eliminarUsuario(int idUsuario) {
        String query = "DELETE FROM usuario WHERE id_usuario = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idUsuario);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
