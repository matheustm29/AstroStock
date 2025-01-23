import java.io.*;
import java.util.List;

public class Persistencia {

    // Método para salvar membros em arquivo
    public static void salvarMembros(List<Membro> membros, String caminhoArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            oos.writeObject(membros);
        } catch (IOException e) {
            throw new IOException("Erro ao salvar os membros: " + e.getMessage());
        }
    }

    // Método para carregar membros de arquivo
    public static List<Membro> carregarMembros(String caminhoArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            return (List<Membro>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo de membros não encontrado: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Erro ao carregar os membros: " + e.getMessage());
        }
    }

    // Método para salvar tarefas em arquivo
    public static void salvarTarefas(List<Tarefa> tarefas, String caminhoArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            oos.writeObject(tarefas);
        } catch (IOException e) {
            throw new IOException("Erro ao salvar as tarefas: " + e.getMessage());
        }
    }

    // Método para carregar tarefas de arquivo
    public static List<Tarefa> carregarTarefas(String caminhoArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            return (List<Tarefa>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo de tarefas não encontrado: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Erro ao carregar as tarefas: " + e.getMessage());
        }
    }

    // Método para salvar projetos em arquivo
    public static void salvarProjetos(List<Projeto> projetos, String caminhoArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            oos.writeObject(projetos);
        } catch (IOException e) {
            throw new IOException("Erro ao salvar os projetos: " + e.getMessage());
        }
    }

    // Método para carregar projetos de arquivo
    public static List<Projeto> carregarProjetos(String caminhoArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            return (List<Projeto>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo de projetos não encontrado: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Erro ao carregar os projetos: " + e.getMessage());
        }
    }
}
