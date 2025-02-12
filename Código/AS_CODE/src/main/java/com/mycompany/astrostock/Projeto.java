package com.mycompany.astrostock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Projeto {

    private int id;
    private String nome;
    private String descricao;
    private List<Tarefa> tarefas;

    public Projeto() {
        this.id = 0;
        this.nome = "";
        this.descricao = "";
        this.tarefas = new ArrayList<>();
    }

    public Projeto(int id, String nome, String descricao) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID do projeto deve ser maior que zero.");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do projeto não pode ser vazio.");
        }
        if (descricao == null) {
            descricao = "";
        }
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tarefas = new ArrayList<>();
    }

    // Métodos para Gerenciar Tarefas
    public void adicionarTarefa(Tarefa tarefa) {
        if (tarefa == null) {
            throw new IllegalArgumentException("A tarefa não pode ser nula.");
        }
        if (tarefas.contains(tarefa)) {
            throw new IllegalArgumentException("A tarefa já está associada a este projeto.");
        }
        tarefas.add(tarefa);
    }

    public boolean removerTarefa(int idTarefa) {
        return tarefas.removeIf(tarefa -> tarefa.getId() == idTarefa);
    }

    public List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas); // Retorna uma cópia para evitar alterações externas
    }

    public Tarefa buscarTarefaPorId(int idTarefa) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == idTarefa) {
                return tarefa;
            }
        }
        return null; // Retorna null se a tarefa não for encontrada
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID do projeto deve ser maior que zero.");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do projeto não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null) {
            descricao = "";
        }
        this.descricao = descricao;
    }

    // Sobrescrevendo métodos equals, hashCode e toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projeto projeto = (Projeto) o;
        return id == projeto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Projeto{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", descricao='" + descricao + '\'' +
               ", tarefas=" + tarefas +
               '}';
    }
}

