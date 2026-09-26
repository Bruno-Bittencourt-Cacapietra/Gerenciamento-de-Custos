import java.util.Scanner;
import java.util.List;

public class Sistema{

    private List<Funcionario> funcionario;
    private Funcionario operadorAtual;
    private Scanner scanner;

    public Sistema(List<Funcionario> funcionario, Scanner scanner){

        this.funcionario = funcionario;
        this.scanner = scanner;
    }

    public void trocarOperador(){

        if (funcionario == null || funcionario.isEmpty()){
            System.out.println("Não há funcionarios cadastrados");
            return;
        }

        System.out.println("=========Funcionarios Cadastrados============");

        for (int i = 0; i < funcionario.size();i++){
            Funcionario f = funcionario.get(i);
            System.out.println((i+1) + "-" + f.getNome() + " (Matricula: " + f.getMatricula() + ")");
            }

        int escolha = -1;

        while(escolha < 1 || escolha > funcionario.size()){
            System.out.println("Escolha o numero de funcionario que irá operar o sistema: ");
            if (scanner.hasNextInt()){
                escolha = scanner.nextInt();
            } else {
                System.out.println("Entrada Invalida. Digite um numero");
                scanner.next();
                }
        }
        scanner.nextLine();

        this.operadorAtual = funcionario.get(escolha -1);
        System.out.println("Operador alterado por: " + operadorAtual.getNome());
    } 
    
    public Funcionario getOperadorAtual(){
        return this.operadorAtual;
    }
}   