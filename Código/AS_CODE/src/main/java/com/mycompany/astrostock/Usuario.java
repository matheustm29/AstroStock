package com.mycompany.astrostock;

import java.util.Objects;

public class Usuario {

    private String username;
    private String senha;
    private String nivelAcesso; // Exemplo: "Admin", "Membro", "Convidado"

    public Usuario() {
        this.username = "";
        this.senha = "";
        this.nivelAcesso = "Membro"; // Nível de acesso padrão
    }

    public Usuario(String username, String senha, String nivelAcesso) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("O username não pode ser vazio.");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("A senha não pode ser vazia.");
        }
        if (nivelAcesso == null || nivelAcesso.trim().isEmpty()) {
            throw new IllegalArgumentException("O nível de acesso não pode ser vazio.");
        }
        this.username = username;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    // Métodos para Autenticação
    public boolean autenticar(String username, String senha) {
        if (username == null || senha == null) {
            throw new IllegalArgumentException("Username e senha não podem ser nulos.");
        }
        return this.username.equals(username) && this.senha.equals(senha);
    }

    public boolean verificarPermissao(String nivelRequerido) {
        if (nivelRequerido == null || nivelRequerido.trim().isEmpty()) {
            throw new IllegalArgumentException("O nível de acesso requerido não pode ser vazio.");
        }
        return this.nivelAcesso.equalsIgnoreCase(nivelRequerido);
    }

    // Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("O username não pode ser vazio.");
        }
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("A senha não pode ser vazia.");
        }
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        if (nivelAcesso == null || nivelAcesso.trim().isEmpty()) {
            throw new IllegalArgumentException("O nível de acesso não pode ser vazio.");
        }
        this.nivelAcesso = nivelAcesso;
    }

    // Sobrescrevendo métodos equals, hashCode e toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return username.equals(usuario.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "username='" + username + '\'' +
               ", nivelAcesso='" + nivelAcesso + '\'' +
               '}';
    }
}
