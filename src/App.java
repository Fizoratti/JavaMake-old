import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class App {
    public static void main(String args[]) {
        /*
         * Message message = new Message("Hello World!");
         * System.out.println(message.getMessage());
         * 
         * Scanner ler = new Scanner(System.in);
         * 
         * String texto = ler.next();
         * 
         * ler.close();
         * 
         * System.out.println(texto);
         */

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Felipe", 23, Pessoa.Genero.MASC));
        pessoas.add(new Pessoa("Elon", 46, Pessoa.Genero.MASC));
        pessoas.add(new Pessoa("Bianca", 20, Pessoa.Genero.FEM));
        pessoas.add(new Pessoa("Fernanda", 8, Pessoa.Genero.FEM));

        System.out.println("\n#####\n# Print all people:");
        Pessoa.printPessoas(pessoas, (Pessoa p) -> true);

        System.out.println("\n#####\n# Print all people over 18:");
        Pessoa.printPessoas(pessoas, (Pessoa p) -> p.getIdade() >= 18);

        System.out.println("\n#####\n# Print all MASC people over 18:");
        Pessoa.printPessoas(pessoas, (Pessoa p) -> p.getIdade() >= 18 && p.getGenero() == Pessoa.Genero.MASC);

        System.out.println("\n#####\n# Print the avg age from all MASC people:");
        double idadeAvg = pessoas.stream().filter(p -> p.getGenero() == Pessoa.Genero.MASC).mapToInt(Pessoa::getIdade)
                .average().getAsDouble();
        System.out.println("Average: " + idadeAvg);

        System.out.println("\n#####\n# Print how many people are over 18:");
        long num = pessoas.stream().filter(p -> p.getIdade() > 18).count();
        System.out.println("Count: " + num);

    }
}