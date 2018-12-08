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
            tabela.put("Pessoas", pessoas);
            file.write(tabela.toJSONString());
            file.flush();

        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

        // JSONParser parser = new JSONParser();
        // Reader reader = new FileReader("Pessoas.json");

        // Object jsonObj = parser.parse(reader);

        // JSONObject jsonObject = (JSONObject) jsonObj;

        // String name = (String) jsonObject.get("name");
        // System.out.println("Name = " + name);

        // long age = (Long) jsonObject.get("age");
        // System.out.println("Age = " + age);

        // JSONArray cities = (JSONArray) jsonObject.get("cities");

        // @SuppressWarnings("unchecked")
        // Iterator<String> it = cities.iterator();
        // while (it.hasNext()) {
        // System.out.println("City = " + it.next());
        // }
        // reader.close();

        Path path1 = Paths.get("Pessoas.json");
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONObject tabela = (JSONObject) obj;

            JSONArray pessoas = (JSONArray) tabela.get("Pessoas");
            System.out.println(pessoas.toJSONString());
            if (pessoas == null)
                System.out.println("É Null");

            System.out.println("Tamanho de Pessoas: " + pessoas.size());

            @SuppressWarnings("unchecked")
            Iterator<JSONObject> it = pessoas.iterator();
            while (it.hasNext()) {
                System.out.println("City = " + it.next());
            }
            reader.close();

        } catch (ParseException e) {
            System.err.format("Erro de E/S: %s%n", e);
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        } catch (Exception e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

        // -------------------------------

        // Path path1 = Paths.get("teste2.csv");
        // try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1,
        // Charset.defaultCharset()))) {
        // for (Pessoa p : lista) {
        // writer.println(p.getNome() + ";" + p.getIdade() + ";" + p.getGenero());
        // }
        // } catch (IOException e) {
        // System.err.format("Erro de E/S: %s%n", e);
        // }

    }

}