public class Tarefa {
    private int id;
    private String descricao;
    private String status; // Exemplo: "Pendente", "Em Progresso", "Concluída"
    private int idMembroResponsavel;

    public Tarefa(int id, String descricao, String status, int idMembroResponsavel) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.idMembroResponsavel = idMembroResponsavel;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        return "Tarefa [ID: " + id + ", Descrição: " + descricao + ", Status: " + status + 
               ", ID Membro Responsável: " + idMembroResponsavel + "]";
    }
}
