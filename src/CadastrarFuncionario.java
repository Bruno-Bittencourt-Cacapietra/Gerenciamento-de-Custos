import java.util.*;

public class CadastrarFuncionario {

    public static void Cadastrar(Scanner scanner, List<Funcionario> funcionarios, List<Departamento> departamentos) {

        System.out.print("Digite a matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.println("\nDepartamentos disponíveis:");
        for (int i = 0; i < departamentos.size(); i++) {
            System.out.println(i + " - " + departamentos.get(i).getNome());
        }

        if (departamentos.isEmpty()) {
            System.out.println("\nERRO: Não há departamentos cadastrados.");
            return;
        }

        System.out.print("Escolha o departamento pelo número: ");
        int escolha = -1;

        if (scanner.hasNextInt()) {
            escolha = scanner.nextInt();
            scanner.nextLine();
        } else {
            scanner.nextLine();
        }

        if (escolha < 0 || escolha >= departamentos.size()) {
            System.out.println("\nERRO: Departamento inválido. Cadastro cancelado.");
            return;
        }

        Departamento departamentoEscolhido = departamentos.get(escolha);

        Funcionario novoFuncionario = new Funcionario(nome, matricula, departamentoEscolhido);
        
        funcionarios.add(novoFuncionario);

        System.out.println("\nFuncionário cadastrado:");
        
        System.out.println(novoFuncionario);
    }
}