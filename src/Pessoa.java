import java.util.function.Predicate;

public class Pessoa {

    public String nome;
    public int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public int getIdade() {
        return this.idade;
    }

    public void printPessoa() {
        System.out.println(nome + ", " + idade);
    }

    public static void printPessoas(List<Pessoa> lista, Predicate<Pessoa> tester) {
        for (Pessoa p : lista) {
            if (tester.test(p)) {
                p.printPessoa();
            }
        }
    }
}