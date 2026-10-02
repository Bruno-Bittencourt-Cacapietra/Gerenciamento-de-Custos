import java.util.List;
import java.util.Scanner;
public class PesquisarCustos {

    /* Menu para o usuário escolher a opção desejada */
    private static void subMenu(){
        System.out.println("Qual filtro gostaria de usar?");
        System.out.println("1 - Descrição");
        System.out.println("2 - Categoria");
        System.out.println("3 - Data");
        System.out.println("4 - Departamento");
    }


    /* Tarefa 7 - Busca os custos pela categoria escolhida e os mostra  */
    public static void pesquisa(List<Custo> custos, Scanner sc){
        if(custos == null || custos.isEmpty()){
            System.out.println("Não há custos registrados.");
            return;
        }
        subMenu();
        while(!sc.hasNextInt()){
            System.out.println("Por favor, digite um número.");
            sc.nextLine();
        }
        int option = sc.nextInt();

        sc.nextLine();

        switch(option){
            case 1:
                boolean existe = false;

                System.out.println("Digite a descrição do custo:");
                String desc = sc.nextLine();

                for(Custo c : custos){
                    if(c.getDescricao().equals(desc)){
                        System.out.println(c);
                        existe = true;
                    }
                }
                if(existe == false){
                    System.out.println("O custo não foi encontrado.");
                }
                break;
            case 2:
                existe = false;

                System.out.println("Digite a descrição da categoria:");
                desc = sc.nextLine();

                for(Custo c : custos){
                    if(c.getCategoria().getDescricao().equals(desc)){
                        System.out.println(c);
                        existe = true;
                    }
                }
                if(existe == false){
                    System.out.println("O custo não foi encontrado.");
                }
                break;
            case 3:
                existe = false;

                System.out.println("Digite o dia:");
                int d = validaData(sc, 1, 31);

                System.out.println("Digite o mês:");
                int m = validaData(sc, 1, 12);

                System.out.println("Digite o ano:");
                int a = validaData(sc, 1, 9999);

                for(Custo c : custos){
                    if(c.getDia() == d && c.getMes() == m && c.getAno() == a){
                        System.out.println(c);
                        existe = true;
                    }
                }
                if(existe == false){
                    System.out.println("Não foi encontrado.");
                }
                break;
            case 4:
                existe = false;

                System.out.println("Digite o nome do departamento:");
                String n = sc.nextLine();

                for(Custo c : custos){
                    if(c.getDepartamento().getNome().equals(n)){
                        System.out.println(c);
                        existe = true;
                    }
                }
                if(existe == false){
                    System.out.println("O custo não foi encontrado.");
                }
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    /* Método que garante que a data não seja totalmente absurda */
    public static int validaData(Scanner sc, int min, int max){
        while(true){
            if(sc.hasNextInt()){
                int temp = sc.nextInt();
                sc.nextLine();
                if(temp >= min && temp <= max){
                    return temp;
                }
            } else{
                sc.nextLine();
            }
            System.out.println("Por favor, digite um valor válido.");
        }
    }


}
