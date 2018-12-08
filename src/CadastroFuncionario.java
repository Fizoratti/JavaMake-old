import java.util.*;

public class CadastroFuncionario implements Cadastro {

    private Map<Integer, Funcionario> lista = new HashMap<>();

    private Set<Map.Entry<Integer, Funcionario>> set = lista.entrySet();

    public void add(Funcionario fun) {
        int index = lista.size() + 1;
        lista.put(index, fun);

        // Map<String, Funcionario> funcionarios = new HashMap<>();
        // funcionarios.put(fun.getCargo(), fun);
        // lista.put(index, funcionarios);

        // if (lista.get(fun.getCargo() == null)) {
        // Set<Funcionario> funcionarios = new HashSet<>();
        // lista.put(fun.getCargo(), funcionarios);
        // }
        // if (lista.get(fun.getCargo()) == fun.getCargo()) {
        // lista.put(fun.getCargo(), funcionarios.add(fun));
        // }

    }

    public void exibeTodos() {
        for (Map.Entry<Integer, Funcionario> me : set) {
            System.out.println(me.getKey() + ": " + me.getValue());
        }
    }

    public void exibeTotalPorCargo() {
        Collection<Funcionario> funcionarios = lista.values();
        Collection<String> cargos = new ArrayList<>();

        for (Funcionario f : funcionarios) {
            cargos.add(f.getCargo());
        }

        System.out.println(cargos);

        // System.out.println(lista);
        // System.out.println(lista.get("Bolsista"));

        // Collection<Set<Funcionario>> funcionarios = lista.values();
        // for (Funcionario f : funcionarios) {
        // System.out.println(f);
        // }

        // Collection<String> cargos = lista.values().;

        // int i = 0;
        // for (String s : cargos) {
        // System.out.println("\n" + s);
        // System.out.println("car:" + cargos.size());
        // for (Funcionario fun : lista.values()) {
        // // System.out.println(i);
        // // i++;
        // System.out.println("fun:" + lista.values().size());
        // // if (fun.getCargo().equalsIgnoreCase(s)) {
        // // System.out.print("\n" + fun.getNome());
        // // }
        // }
        // }
    }
}