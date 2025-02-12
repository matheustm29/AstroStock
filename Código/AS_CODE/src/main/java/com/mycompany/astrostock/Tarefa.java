package com.mycompany.astrostock;

import java.util.Objects;

public class Tarefa {

    private int id;
    private String descricao;
    private String status; // Enum pode ser usado aqui
    private int idMembroResponsavel;

    public Tarefa() {
        id = 0;
        descricao = "";
        status = "";
        idMembroResponsavel = 0;
    }

    public Tarefa(int id, String descricao, String status, int idMembroResponsavel) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID deve ser maior que zero.");
        }
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("O status não pode ser vazio.");
        }
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.idMembroResponsavel = idMembroResponsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID deve ser maior que zero.");
        }
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("O status não pode ser vazio.");
        }
        this.status = status;
    }

    public int getIdMembroResponsavel() {
        return idMembroResponsavel;
    }

    public void setIdMembroResponsavel(int idMembroResponsavel) {
        this.idMembroResponsavel = idMembroResponsavel;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
               "id=" + id +
               ", descricao='" + descricao + '\'' +
               ", status='" + status + '\'' +
               ", idMembroResponsavel=" + idMembroResponsavel +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return id == tarefa.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

