public class Membro {

    private int id;
    private String nome;
    private String curso;
    private String funcao;
    private String contato;

    public Membro() {
        id = 0;
        nome = "";
        curso = "";
        funcao = "";
        contato = "";
    }

    // Sobrecarga
    public Membro(int id, String nome, String curso, String funcao, String contato) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.funcao = funcao;
        this.contato = contato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

}

