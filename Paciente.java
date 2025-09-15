public class Paciente {
    private static int contadorId = 0;
    private int id;
    private String nome;
    private int idade;
    private String sintoma;

    public Paciente(String nome, int idade, String sintoma) {
        this.id = ++contadorId;
        this.nome = nome;
        this.idade = idade;
        this.sintoma = sintoma;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String exibirInfo() {
        return "ID: " + this.id + " | Nome: " + this.nome + " | Idade: " + this.idade + " | Sintoma: " + this.sintoma;
    }
}
