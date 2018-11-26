import java.util.*;

public class CadastroFuncionario implements Cadastro {
    private Map<String, Funcionario> lista = new HashMap<>();

    public void add(Funcionario fun) {
        lista.put(fun.getCargo(), fun);
    }

    public void exibeTotalPorCargo() {
        lista.values();
    }
}