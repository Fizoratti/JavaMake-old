import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class App {
    public static void main(String args[]) {

        CadastroFuncionario cf = new CadastroFuncionario();

        cf.add(new Funcionario("Felipe", "Bolsista"));
        cf.add(new Funcionario("Matheus", "Bolsista"));
        cf.add(new Funcionario("Gabriel", "Bolsista"));
        cf.add(new Funcionario("Darlan", "Mestrando"));

        cf.exibeTodos();

        cf.exibeTotalPorCargo();
    }
}