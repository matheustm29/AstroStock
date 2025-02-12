package com.mycompany.astrostock;

import java.util.List;

public class Relatorio {

    // Método para gerar relatório de membros
    public static String gerarRelatorioMembros(List<Membro> membros) {
        if (membros == null || membros.isEmpty()) {
            return "Não há membros cadastrados.";
        }

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== Relatório de Membros ===\n");
        for (Membro membro : membros) {
            relatorio.append("ID: ").append(membro.getId()).append("\n")
                     .append("Nome: ").append(membro.getNome()).append("\n")
                     .append("Curso: ").append(membro.getCurso()).append("\n")
                     .append("Função: ").append(membro.getFuncao()).append("\n")
                     .append("Contato: ").append(membro.getContato()).append("\n")
                     .append("--------------------------\n");
        }
        return relatorio.toString();
    }

    // Método para gerar relatório de tarefas
    public static String gerarRelatorioTarefas(List<Tarefa> tarefas) {
        if (tarefas == null || tarefas.isEmpty()) {
            return "Não há tarefas cadastradas.";
        }

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== Relatório de Tarefas ===\n");
        for (Tarefa tarefa : tarefas) {
            relatorio.append("ID: ").append(tarefa.getId()).append("\n")
                     .append("Descrição: ").append(tarefa.getDescricao()).append("\n")
                     .append("Status: ").append(tarefa.getStatus()).append("\n")
                     .append("Responsável (ID): ").append(tarefa.getIdMembroResponsavel()).append("\n")
                     .append("--------------------------\n");
        }
        return relatorio.toString();
    }

    // Método para gerar relatório de projetos
    public static String gerarRelatorioProjetos(List<Projeto> projetos) {
        if (projetos == null || projetos.isEmpty()) {
            return "Não há projetos cadastrados.";
        }

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== Relatório de Projetos ===\n");
        for (Projeto projeto : projetos) {
            relatorio.append("ID: ").append(projeto.getId()).append("\n")
                     .append("Nome: ").append(projeto.getNome()).append("\n")
                     .append("Descrição: ").append(projeto.getDescricao()).append("\n")
                     .append("Tarefas:\n");
            for (Tarefa tarefa : projeto.listarTarefas()) {
                relatorio.append("  - [ID: ").append(tarefa.getId()).append("] ")
                         .append(tarefa.getDescricao()).append(" (")
                         .append(tarefa.getStatus()).append(")\n");
            }
            relatorio.append("--------------------------\n");
        }
        return relatorio.toString();
    }

    // Método para salvar o relatório em arquivo (opcional)
    public static void salvarRelatorioEmArquivo(String relatorio, String caminhoArquivo) {
        try (java.io.FileWriter writer = new java.io.FileWriter(caminhoArquivo)) {
            writer.write(relatorio);
        } catch (java.io.IOException e) {
            System.err.println("Erro ao salvar o relatório: " + e.getMessage());
        }
    }
}

