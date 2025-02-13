package com.mycompany.astrostock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ControleMembros {

    private List<Membro> membros;
    private List<Tarefa> tarefas;
    private static ControleMembros instanciaUnica;

    private ControleMembros() {
        membros = new ArrayList<>();
        tarefas = new ArrayList<>();
    }

    // Método Singleton
    public static ControleMembros getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new ControleMembros();
        }
        return instanciaUnica;
    }

    // Métodos para Gerenciar Membros
    public Membro adicionarMembro(Membro membro) {
        if (membro == null || membro.getId() <= 0) {
            throw new IllegalArgumentException("Membro inválido.");
        }
        if (buscarMembroPorId(membro.getId()).isPresent()) {
            return null; // Evitar duplicatas
        }
        membros.add(membro);
        return membro;
    }

    public Membro removerMembro(int id) {
        Optional<Membro> membroRemovido = buscarMembroPorId(id);
        membroRemovido.ifPresent(membros::remove);
        return membroRemovido.orElse(null);
    }

    public List<Membro> listarMembros() {
        return new ArrayList<>(membros); // Retorna uma cópia para evitar modificações externas
    }

    private Optional<Membro> buscarMembroPorId(int id) {
        return membros.stream().filter(membro -> membro.getId() == id).findFirst();
    }

    // Métodos para Gerenciar Tarefas
    public Tarefa adicionarTarefa(Tarefa tarefa) {
        if (tarefa == null || tarefa.getId() <= 0) {
            throw new IllegalArgumentException("Tarefa inválida.");
        }
        if (buscarTarefaPorId(tarefa.getId()).isPresent()) {
            return null; // Evitar duplicatas
        }
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa atualizarStatusTarefa(int idTarefa, String novoStatus) {
        if (novoStatus == null || novoStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("O status não pode ser vazio.");
        }
        Optional<Tarefa> tarefa = buscarTarefaPorId(idTarefa);
        tarefa.ifPresent(t -> t.setStatus(novoStatus));
        return tarefa.orElse(null);
    }

    public List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas); // Retorna uma cópia para evitar modificações externas
    }

    public List<Tarefa> listarTarefasPorMembro(int idMembro) {
        if (buscarMembroPorId(idMembro).isEmpty()) {
            throw new IllegalArgumentException("Membro não encontrado.");
        }
        List<Tarefa> tarefasMembro = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getIdMembroResponsavel() == idMembro) {
                tarefasMembro.add(tarefa);
            }
        }
        return tarefasMembro;
    }

    private Optional<Tarefa> buscarTarefaPorId(int idTarefa) {
        return tarefas.stream().filter(tarefa -> tarefa.getId() == idTarefa).findFirst();
    }

    @Override
    public String toString() {
        return "ControleMembros{" +
               "membros=" + membros +
               ", tarefas=" + tarefas +
               '}';
    }
}


   