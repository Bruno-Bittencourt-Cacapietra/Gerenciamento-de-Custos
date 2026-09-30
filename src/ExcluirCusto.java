/**
* Tarefa 8: Apaga só o último item da lista e impede apagar qualquer outro.
*/

import java.util.*;

public class ExcluirCusto {

    public static void executar(List<Custo> listaCustos) {


        if (listaCustos == null || listaCustos.isEmpty()) {

            System.out.println("\n[ERRO] Não existem custos registrados para excluir.");

            return;

        }


        int ultimoIndice = listaCustos.size() - 1;


        Custo removido = listaCustos.remove(ultimoIndice);


        System.out.println("\n[SUCESSO] O último custo cadastrado foi excluído:");

        System.out.println("-> Descrição: " + removido.getDescricao());

        System.out.println("-> Valor: R$ " + removido.getValor());

    }

}