import java.util.ArrayList;
import java.util.List;

public class ControleMembros {
    private List<Membro> membros;
    private List<Tarefa> tarefas;

    public ControleMembros() {
        this.membros = new ArrayList<>();
        this.tarefas = new ArrayList<>();
    }

    // Métodos para Gerenciar Membros
    public void adicionarMembro(Membro membro) {
        membros.add(membro);
    }

    public void removerMembro(int id) {
        membros.removeIf(membro -> membro.getId() == id);
    }

    public List<Membro> listarMembros() {
        return membros;
    }

    // Métodos para Gerenciar Tarefas
    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void atualizarStatusTarefa(int idTarefa, String novoStatus) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == idTarefa) {
                tarefa.setStatus(novoStatus);
                break;
            }
        }
    }

    public List<Tarefa> listarTarefas() {
        return tarefas;
    }

    public List<Tarefa> listarTarefasPorMembro(int idMembro) {
        List<Tarefa> tarefasMembro = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getIdMembroResponsavel() == idMembro) {
                tarefasMembro.add(tarefa);
            }
        }
        return tarefasMembro;
    }
}
