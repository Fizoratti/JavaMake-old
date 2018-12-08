public class Funcionario {
    private String nome;
    private String cargo;

    public Funcionario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCargo() {
        return this.cargo;
    }

    @Override
    public String toString() {
        return this.nome + ", " + this.cargo;
    }
}