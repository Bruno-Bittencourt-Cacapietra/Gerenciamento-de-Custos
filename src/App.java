import java.util.*;

public class App {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Custo> custos = new ArrayList<>();
    private static List<Departamento> departamentos = new ArrayList<>();
    private static Funcionario operadorAtual = null; 
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        departamentos.add(new Departamento("TI"));
        departamentos.add(new Departamento("Recursos Humanos"));
        departamentos.add(new Departamento("Financeiro"));

        System.out.println("Bem-vindo ao Sistema de Gestão de Custos!");

        while (opcao != 0) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Trocar Operador ---");

                    Sistema trocarOperador = new Sistema(funcionarios, scanner);
                    trocarOperador.trocarOperador();
                    operadorAtual = trocarOperador.getOperadorAtual();
                    break;
                    
                case 2:
                    System.out.println("\n--- Cadastrar Funcionário ---");
                    CadastrarFuncionario.Cadastrar(scanner, funcionarios, departamentos);
                    break;
                    
                case 3:
                    System.out.println("\n--- Registrar Custo ---");
                    RegistrarCusto.executar(scanner, custos, departamentos, operadorAtual);
                    break;
                    
                case 4:
                    System.out.println("\n--- Pesquisar Custos ---");
                    PesquisarCustos.pesquisa(custos, scanner);
                    break;
                    
                case 5:
                    System.out.println("\n--- Excluir Custo Mais Recente ---");
                    ExcluirCusto.executar(custos);
                    break;
                    
                case 6:
                    System.out.println("\n--- Painel de Indicadores ---");
                    Painel painel = new Painel(operadorAtual, custos);
                    painel.exibirPainel();
   
                    PainelTrimestre.exibirPainel(custos);
                    FuncionariosCustos.funcionariosMaioresCustos(custos);
                    break;

                case 0:
                    System.out.println("\nA sair do sistema... Até logo!");
                    break;
                    
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=========================================");
        System.out.println("             MENU PRINCIPAL              ");
        System.out.println("=========================================");
        System.out.println("Operador atual: " + (operadorAtual != null ? operadorAtual.getNome() : "Nenhum operador selecionado"));
        System.out.println("=========================================");
        System.out.println("1. Trocar operador logado");
        System.out.println("2. Cadastrar funcionário");
        System.out.println("3. Registrar novo custo");
        System.out.println("4. Pesquisar custos");
        System.out.println("5. Excluir custo mais recente");
        System.out.println("6. Exibir painel de indicadores");
        System.out.println("0. Sair");
        System.out.println("=========================================");
    }
}