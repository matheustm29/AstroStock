package com.mycompany.astrostock;

import java.util.Objects;

public class Membro {

    private int id;
    private String nome;
    private String curso;
    private String funcao;
    private String contato;

    public Membro() {
        id = 0;
        nome = "";
        curso = "";
        funcao = "";
        contato = "";
    }

    public Membro(int id, String nome, String curso, String funcao, String contato) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID deve ser maior que zero.");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.funcao = funcao;
        this.contato = contato;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getContato() {
        return contato;
    }

    @Override
    public String toString() {
        return "Membro{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", curso='" + curso + '\'' +
               ", funcao='" + funcao + '\'' +
               ", contato='" + contato + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membro membro = (Membro) o;
        return id == membro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


