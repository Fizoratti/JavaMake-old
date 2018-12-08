import java.util.ArrayList;

public class Pessoas {
    private static Pessoas pessoas;

    private ArrayList<Pessoa> lista;

    private Pessoas() {
        lista = new ArrayList<>();
        populateLista();
    }

    public static Pessoas getInstance() {
        if (pessoas == null) {
            pessoas = new Pessoas();
        }
        return pessoas;
    }

    public void add(Pessoa p) {
        lista.add(p);
    }

    public ArrayList getLista() {
        return this.lista;
    }

    private void populateLista() {
        lista.add(new Pessoa("Jose", 12, Pessoa.Genero.MASC));
        lista.add(new Pessoa("Maria", 14, Pessoa.Genero.FEM));
        lista.add(new Pessoa("Jesus", 1, Pessoa.Genero.MASC));
        lista.add(new Pessoa("Judas", 2, Pessoa.Genero.MASC));
        lista.add(new Pessoa("Madalena", 2, Pessoa.Genero.FEM));
        lista.add(new Pessoa("Moisés", 6, Pessoa.Genero.MASC));
        lista.add(new Pessoa("Jaco", 9, Pessoa.Genero.MASC));
        lista.add(new Pessoa("Cain", 0, Pessoa.Genero.MASC));
        lista.add(new Pessoa("Abel", 0, Pessoa.Genero.MASC));
        lista.add(new Pessoa("Noé", 999, Pessoa.Genero.MASC));
        lista.add(new Pessoa("Eva", 2018, Pessoa.Genero.FEM));
        lista.add(new Pessoa("Adão", 2018, Pessoa.Genero.MASC));
    }

}