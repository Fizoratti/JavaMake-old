import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class JsonSimpleWriteExample {

    public static void main(String[] args) {

        ArrayList<Pessoa> lista = new ArrayList<>();
        lista.add(new Pessoa("Jose", 12, Pessoa.Genero.MASC));
        lista.add(new Pessoa("Maria", 14, Pessoa.Genero.FEM));
        lista.add(new Pessoa("Jesus", 1, Pessoa.Genero.MASC));
        lista.add(new Pessoa("Judas", 2, Pessoa.Genero.MASC));
        lista.add(new Pessoa("Madalena", 2, Pessoa.Genero.FEM));
        lista.add(new Pessoa("Moisés", 6, Pessoa.Genero.MASC));

        // JSONArray list = new JSONArray();
        // list.add("msg 1");
        // list.add("msg 2");
        // list.add("msg 3");

        // obj.put("messages", list);

        try (FileWriter file = new FileWriter("Pessoas.json")) {
            JSONObject tabela = new JSONObject();
            JSONArray pessoas = new JSONArray();
            for (Pessoa p : lista) {
                pessoas.add(p.toJSON());
            }
            tabela.put("Pessoas:", pessoas);
            file.write(tabela.toJSONString());
            file.flush();

        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

        // -------------------------------

        Path path1 = Paths.get("teste2.csv");
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
            for (Pessoa p : lista) {
                writer.println(p.getNome() + ";" + p.getIdade() + ";" + p.getGenero());
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

    }

}