/**
 * Parte do Painel que representa os 3 funcionários com maiores custos
 */
import java.util.*;

public class FuncionariosCustos {
    
    public static void funcionariosMaioresCustos(List<Custo> listaCustos) {

        if (listaCustos == null || listaCustos.isEmpty()) {
            System.out.println("\n[ERRO] Não existem custos registrados para exibir.");
            return;
        }

        System.out.println("\n=== Top 3 funcionários com a maior soma de custos ===");

        Map<String, Double> totalPorFuncionario = new HashMap<>();

        for (Custo custo : listaCustos) {
            String chave = custo.getFuncionario().getMatricula();
            String funcionarioNome = chave + " - " + custo.getFuncionario().getNome();
            double valor = custo.getValor();

            totalPorFuncionario.put(funcionarioNome, totalPorFuncionario.getOrDefault(funcionarioNome, 0.0) + valor);
        }

        String top1 = "";
        String top2 = "";
        String top3 = "";

        double primeiro = -1;
        double segundo = -1;
        double terceiro = -1;

        for (String funcionario : totalPorFuncionario.keySet()) {
            double total = totalPorFuncionario.get(funcionario);

            if (total > primeiro) {
                terceiro = segundo;
                top3 = top2;

                segundo = primeiro;
                top2 = top1;

                primeiro = total;
                top1 = funcionario;
            } else if (total > segundo) {
                terceiro = segundo;
                top3 = top2;

                segundo = total;
                top2 = funcionario;
            } else if (total > terceiro) {
                terceiro = total;
                top3 = funcionario;
            }
        }
        
        if (top1.isEmpty() && top2.isEmpty() && top3.isEmpty()) {
            System.out.println("\n[INFO] Não existem custos registrados para exibir.");
            } else {
            System.out.println("1. " + top1 + " - R$ " + String.format("%.2f", primeiro));
        
            if (!top2.isEmpty()) {    
            System.out.println("2. " + top2 + " - R$ " + String.format("%.2f", segundo));
            }
        
            if (!top3.isEmpty()) {
            System.out.println("3. " + top3 + " - R$ " + String.format("%.2f", terceiro));
            }
        }
    }
}
