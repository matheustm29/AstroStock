public class Main {
    public static void main(String[] args) {
        ControleMembros controle = new ControleMembros();

        // Criando membros
        Membro membro1 = new Membro(1, "João Silva", "Engenharia Elétrica", "Líder de Projeto", "joao@email.com");
        Membro membro2 = new Membro(2, "Ana Souza", "Engenharia Mecânica", "Responsável pelo Chassi", "ana@email.com");

        controle.adicionarMembro(membro1);
        controle.adicionarMembro(membro2);

        // Criando tarefas
        Tarefa tarefa1 = new Tarefa(1, "Montar o chassi do foguete", "Pendente", 2);
        Tarefa tarefa2 = new Tarefa(2, "Documentar o progresso", "Pendente", 1);

        controle.adicionarTarefa(tarefa1);
        controle.adicionarTarefa(tarefa2);

        // Listando membros
        System.out.println("Membros da equipe:");
        for (Membro membro : controle.listarMembros()) {
            System.out.println(membro);
        }

        // Listando tarefas
        System.out.println("\nTarefas atribuídas:");
        for (Tarefa tarefa : controle.listarTarefas()) {
            System.out.println(tarefa);
        }
    }
}
