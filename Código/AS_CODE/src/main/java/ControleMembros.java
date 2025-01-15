
import java.util.ArrayList;
import java.util.List;

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
        for (Membro m : membros) {
            if (m.getId() == membro.getId()) {
                return null; // Evitar duplicatas
            }
        }
        membros.add(membro);
        return membro;
    }

    public Membro removerMembro(int id) {
        Membro membroRemovido = buscarMembroPorId(id);
        if (membroRemovido != null) {
            membros.remove(membroRemovido);
        }
        return membroRemovido;
    }

    public List<Membro> listarMembros() {
        return membros;
    }

    private Membro buscarMembroPorId(int id) {
        for (Membro membro : membros) {
            if (membro.getId() == id) {
                return membro;
            }
        }
        return null;
    }

    // Métodos para Gerenciar Tarefas
    public Tarefa adicionarTarefa(Tarefa tarefa) {
        for (Tarefa t : tarefas) {
            if (t.getId() == tarefa.getId()) {
                return null; // Evitar duplicatas
            }
        }
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa atualizarStatusTarefa(int idTarefa, String novoStatus) {
        Tarefa tarefa = buscarTarefaPorId(idTarefa);
        if (tarefa != null) {
            tarefa.setStatus(novoStatus);
        }
        return tarefa;
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

    private Tarefa buscarTarefaPorId(int idTarefa) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == idTarefa) {
          

