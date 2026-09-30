import java.util.List;
import java.util.Scanner;


public class RegistrarCusto {


    public static void executar(Scanner scanner, List<Custo> custos, List<Departamento> departamentos, Funcionario operadorAtual) {


        if (operadorAtual == null) {
            System.out.println("\nNenhum operador logado");
            return;
        }

        System.out.println("\nRegistrar novo custo");

        double valor = lerValor(scanner);
        String descricao = lerDescricao(scanner);
        int[] data = lerData(scanner);
        Categoria categoria = lerCategoria(scanner);
        Departamento departamento = lerDepartamento(scanner, departamentos);


        Custo novoCusto = new Custo(valor, descricao, data[0], data[1], data[2], categoria, departamento, operadorAtual);

        custos.add(novoCusto);

        System.out.println("\nCusto registrado com sucesso");
    }

    private static double lerValor(Scanner scanner) {
        while (true) {
            System.out.print("Valor do custo (Ex: 150.50):");
            try {
                double valor = Double.parseDouble(scanner.nextLine().replace(",", "."));

                if (ValidacaoCusto.validarValor(valor)) {
                    return valor;
                } else {
                    System.out.println("O valor não pode ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }


    private static String lerDescricao(Scanner scanner) {
        while (true) {
            System.out.print("Descrição do custo: ");
            String descricao = scanner.nextLine().trim();
            if (!descricao.isEmpty()) {
                return descricao;
            }
            System.out.println("A descrição não pode ficar em branco.");
        }
    }


    private static int[] lerData(Scanner scanner) {
        while (true) {
            System.out.print("Data (DD/MM/AAAA): ");
            String entrada = scanner.nextLine();
            String[] partes = entrada.split("/");


            if (partes.length == 3) {
                try {
                    int dia = Integer.parseInt(partes[0]);
                    int mes = Integer.parseInt(partes[1]);
                    int ano = Integer.parseInt(partes[2]);


                    if (ValidacaoCusto.validarData(dia, mes, ano)) {
                        return new int[] {dia, mes, ano};
                    } else {
                        System.out.println("Data inválida");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Use apenas números e barras para a data.");
                }
            } else {
                System.out.println("Formato incorreto. O correto é DD/MM/AAAA.");
            }
        }
    }


    private static Categoria lerCategoria(Scanner scanner) {
        while (true) {
            System.out.println("\nCategorias disponíveis:");
            Categoria[] categorias = Categoria.values();
            for (int i = 0; i < categorias.length; i++) {
                System.out.println((i + 1) + " - " + categorias[i].name());
            }


            System.out.print("Escolha o número da categoria: ");
            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao >= 1 && opcao <= categorias.length) {
                    Categoria escolhida = categorias[opcao - 1];


                    if (ValidacaoCusto.validarCategoria(escolhida)) {
                        return escolhida;
                    } else {
                        System.out.println("Categoria inválida.");
                    }
                } else {
                    System.out.println("Opção inexistente. Digite um número da lista.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas o número da opção desejada.");
            }
        }
    }

    private static Departamento lerDepartamento(Scanner scanner, List<Departamento> departamentos) {
        if (departamentos.isEmpty()) {
            System.out.println("Não há departamentos cadastrados no sistema.");
            return null;
        }


        while (true) {
            System.out.println("\nDepartamentos disponíveis:");
            for (int i = 0; i < departamentos.size(); i++) {
                System.out.println((i + 1) + " - " + departamentos.get(i).getNome());
            }


            System.out.print("Escolha o número do departamento: ");
            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao >= 1 && opcao <= departamentos.size()) {
                    Departamento escolhido = departamentos.get(opcao - 1);


                    if (ValidacaoCusto.validarDepartamento(escolhido, departamentos)) {
                        return escolhido;
                    } else {
                        System.out.println("Departamento não encontrado ou inválido.");
                    }
                } else {
                    System.out.println("Opção inexistente. Digite um número da lista.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas o número da opção desejada.");
            }
        }
    }
}

