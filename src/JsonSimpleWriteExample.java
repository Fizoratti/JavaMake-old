import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class JsonSimpleWriteExample {

    public static void main(String[] args) {

        ArrayList<Pessoa> lista = Pessoas.getInstance().getLista();

        try (FileWriter file = new FileWriter("Pessoas.json")) {
            JSONObject tabela = new JSONObject();
            JSONArray pessoas = new JSONArray();
            for (Pessoa p : lista) {
                pessoas.add(p.toJSON());
            }
            tabela.put("Pessoas", pessoas);
            file.write(tabela.toJSONString());
            file.flush();

        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

        Path path1 = Paths.get("Pessoas.json");
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONObject tabela = (JSONObject) obj;
            JSONArray pessoas = (JSONArray) tabela.get("Pessoas");

            // System.out.println(pessoas.toJSONString());
            // System.out.println("Tamanho de Pessoas: " + pessoas.size());

            @SuppressWarnings("unchecked")
            Iterator<JSONObject> it = pessoas.iterator();
            while (it.hasNext()) {
                System.out.println("pessoa: " + it.next());
            }

            reader.close();

        } catch (ParseException e) {
            System.err.format("Erro de E/S: %s%n", e);
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        } catch (Exception e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

    }

}