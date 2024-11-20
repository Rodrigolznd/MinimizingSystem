package com.miempresa.modelo;

/**
 * Clase que representa la entidad Usuario en el sistema.
 */
public class Usuario {
    private int idUsuario;
    private String nombreCompleto;
    private String username;
    private String email;
    private String hashedPassword;
    private boolean activo;

    // Constructor vacío.
    public Usuario() {}

    // Constructor con parámetros.
    public Usuario(int idUsuario, String nombreCompleto, String username, String email, String hashedPassword, boolean activo) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.activo = activo;
    }

    // Métodos getter y setter para cada atributo.
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
