import java.util.*;

public class App {
    // Listas globais para armazenar os dados e partilhar entre as opções do menu
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Custo> custos = new ArrayList<>();
    private static List<Departamento> departamentos = new ArrayList<>();
    private static Funcionario operadorAtual = null; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        // Pré-cadastrar alguns departamentos para o sistema não iniciar vazio
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
                    /*
                     * TODO: Tarefa 3
                     * 1. Verificar se a lista 'funcionarios' está vazia. Se estiver, avisar e dar 'break'.
                     * 2. Fazer um 'for' para listar os funcionários cadastrados (mostrando o índice).
                     * 3. Pedir ao utilizador para digitar o número correspondente ao funcionário.
                     * 4. Atribuir o funcionário escolhido à variável 'operadorAtual'.
                     */
                    System.out.println("Funcionalidade em desenvolvimento...");
                    break;
                    
                case 2:
                    System.out.println("\n--- Cadastrar Funcionário ---");
                    
                    CadastrarFuncionario.Cadastrar(scanner, funcionarios, departamentos);
                    
                    System.out.println("Funcionalidade em desenvolvimento...");
                    break;
                    
                case 3:
                    System.out.println("\n--- Registrar Custo ---");
                    /*
                     * TODO: Tarefas 5 e 6
                     * 1. Verificar se 'operadorAtual' é nulo. Se for, obrigar a trocar de operador primeiro.
                     * 2. Pedir o valor do custo. Se for negativo, dar erro e pedir de novo.
                     * 3. Pedir a descrição e a data (dia, mês e ano).
                     * 4. Listar o Enum Categoria e pedir para escolher.
                     * 5. Listar os 'departamentos' e pedir para escolher.
                     * 6. Criar um 'new Custo(...)' passando o 'operadorAtual'.
                     * 7. Adicionar o custo gerado à lista 'custos'.
                     */
                    RegistrarCusto.executar(scanner, custos, departamentos, operadorAtual);
                    break;
                    
                case 4:
                    System.out.println("\n--- Pesquisar Custos ---");
                    /*
                     * TODO: Tarefa 7
                     * 1. Exibir um sub-menu perguntando qual o filtro (descrição, categoria, data ou departamento).
                     * 2. Capturar o termo a ser pesquisado.
                     * 3. Percorrer a lista 'custos' num 'for'.
                     * 4. Fazer 'if' verificando se o custo atual bate com o filtro escolhido.
                     * 5. Exibir os resultados.
                     */
                    PesquisarCustos.pesquisa(custos, scanner);
                    System.out.println("Funcionalidade em desenvolvimento...");
                    break;
                    
                case 5:
                    System.out.println("\n--- Excluir Custo Mais Recente ---");
                    ExcluirCusto.executar(custos);
                    break;
                    
                case 6:
                    System.out.println("\n--- Painel de Indicadores ---");
                    /*
                     * TODO: Tarefas 9 e 10
                     * 1. Mostrar o 'operadorAtual.getNome()'.
                     * 2. Somar e mostrar o valor de todos os 'custos' do mês atual.
                     * 3. Calcular e mostrar os totais dos últimos 3 meses filtrando por departamento.
                     * 4. Agrupar os custos por funcionário e encontrar o top 3 maiores gastadores.
                     */
                    System.out.println("Funcionalidade em desenvolvimento...");
                    break;

                /* Criei esse case apenas pra testar as validações da classe ValidacaoCusto, deve ser removido
                 * antes de entregar o projeto final
                 */ 
                case 7:
                    System.out.println("\n--- Teste das Validações ---");

                    System.out.println("Valor 200: " +
                            ValidacaoCusto.validarValor(200));

                    System.out.println("Valor -80: " +
                            ValidacaoCusto.validarValor(-80));

                    System.out.println("Data 28/09/2026: " +
                            ValidacaoCusto.validarData(28, 9, 2026));

                    System.out.println("Data 30/02/2026: " +
                            ValidacaoCusto.validarData(30, 2, 2026));

                    System.out.println("Categoria válida: " +
                            ValidacaoCusto.validarCategoria(Categoria.OUTROS_SERVICOS));

                    System.out.println("Categoria nula: " +
                            ValidacaoCusto.validarCategoria(null));

                    Departamento departamentoTeste = departamentos.get(0);

                    System.out.println("Departamento existente: " +
                            ValidacaoCusto.validarDepartamento(departamentoTeste, departamentos));

                    Departamento departamentoInexistente = new Departamento("Marketing");

                    System.out.println("Departamento inexistente: " +
                            ValidacaoCusto.validarDepartamento(departamentoInexistente, departamentos));
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
        //Criei a opção 7 para testar as validações
        System.out.println("7. Testar validações");
        System.out.println("0. Sair");
        System.out.println("=========================================");
    }
}