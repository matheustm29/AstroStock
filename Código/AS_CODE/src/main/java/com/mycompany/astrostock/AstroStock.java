package com.mycompany.astrostock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AstroStock {

    public static void main(String[] args) {
        // Inicializando o sistema
        ControleMembros controle = ControleMembros.getInstancia();
        String caminhoMembros = "membros.dat";
        String caminhoTarefas = "tarefas.dat";
        String caminhoProjetos = "projetos.dat";

        // Carregando dados persistidos
        carregarDados(controle, caminhoMembros, caminhoTarefas, caminhoProjetos);

        // Adicionando dados de exemplo
        System.out.println("\nAdicionando dados de exemplo...");
        adicionarDadosExemplo(controle);

        // Exibindo membros e tarefas
        System.out.println("\nMembros cadastrados:");
        System.out.println(Relatorio.gerarRelatorioMembros(controle.listarMembros()));

        System.out.println("Tarefas cadastradas:");
        System.out.println(Relatorio.gerarRelatorioTarefas(controle.listarTarefas()));

        // Salvando dados atualizados
        salvarDados(controle, caminhoMembros, caminhoTarefas, caminhoProjetos);
    }

    private static void carregarDados(ControleMembros controle, String caminhoMembros, String caminhoTarefas, String caminhoProjetos) {
        try {
            // Carregando membros
            List<Membro> membros = Persistencia.carregarMembros(caminhoMembros);
            for (Membro membro : membros) {
                controle.adicionarMembro(membro);
            }

            // Carregando tarefas
            List<Tarefa> tarefas = Persistencia.carregarTarefas(caminhoTarefas);
            for (Tarefa tarefa : tarefas) {
                controle.adicionarTarefa(tarefa);
                System.out.println("carreguei as tarefas aqui --------");
            }

            // Carregando projetos (se implementado)
            // List<Projeto> projetos = Persistencia.carregarProjetos(caminhoProjetos);
            // para cada projeto, carregue as tarefas associadas

            System.out.println("Dados carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }

    private static void adicionarDadosExemplo(ControleMembros controle) {
        // Adicionando membros
        controle.adicionarMembro(new Membro(1, "João", "Engenharia Mecânica", "Líder", "joao@email.com"));
        controle.adicionarMembro(new Membro(2, "Maria", "Engenharia Elétrica", "Membro", "maria@email.com"));

        // Adicionando tarefas
        controle.adicionarTarefa(new Tarefa(1, "Planejar lançamento", "Pendente", 1));
        controle.adicionarTarefa(new Tarefa(2, "Desenhar estrutura", "Em Progresso", 2));

        // Exemplo de adicionar projetos (opcional)
        // Projeto projeto1 = new Projeto(1, "Projeto Foguete A", "Lançamento experimental");
        // projeto1.adicionarTarefa(new Tarefa(3, "Montar o protótipo", "Pendente", 2));
        // controle.adicionarProjeto(projeto1);
    }

    private static void salvarDados(ControleMembros controle, String caminhoMembros, String caminhoTarefas, String caminhoProjetos) {
        try {
            // Salvando membros
            Persistencia.salvarMembros(controle.listarMembros(), caminhoMembros);

            // Salvando tarefas
            Persistencia.salvarTarefas(controle.listarTarefas(), caminhoTarefas);

            // Salvando projetos (se implementado)
            // Persistencia.salvarProjetos(controle.listarProjetos(), caminhoProjetos);

            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
}
