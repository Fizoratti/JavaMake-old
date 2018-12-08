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

        JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", new Integer(100));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        try (FileWriter file = new FileWriter("test.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

        // -------------------------------

        ArrayList<Pessoa> lista = new ArrayList<>();
        lista.add(new Pessoa("Jose", 12, Pessoa.Genero.MASC));
        // ...inclui mais pessoas na lista

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