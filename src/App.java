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

        Pessoa.printPessoas(pessoas, p -> p.getIdade() >= 18 && p.getGenero() == Pessoa.Genero.MASC);

    }
}