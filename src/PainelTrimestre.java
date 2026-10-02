/**
 * Parte do Painel que representa o total dos últimos 3 meses por departamento
 */
import java.time.*;
import java.util.*;

public class PainelTrimestre {

    public static void exibirPainel(List<Custo> listaCustos) {

        if (listaCustos == null || listaCustos.isEmpty()) {

            System.out.println("\n[ERRO] Não existem custos registrados para exibir.");

            return;

        }

        System.out.println("\n=== Custos dos últimos 3 meses por departamento ===");

        LocalDate hoje = LocalDate.now();
        int anoAtual = hoje.getYear();
        int mesAtual = hoje.getMonthValue();
        int cmesAtual = anoAtual * 12 + mesAtual; // Ano e mês viram um número só separados por 1

        Map<String, Double> totalPorDepartamento = new HashMap<>();

        for (Custo custo : listaCustos) {

            int anoCusto = custo.getAno();
            int mesCusto = custo.getMes();
            int cmesCusto = anoCusto * 12 + mesCusto;

            if (cmesAtual - cmesCusto >= 1 && cmesAtual - cmesCusto <= 3) { // Verifica se é dos ultimos 3 meses sem contar o mês atual

                String departamentoNome = custo.getDepartamento().getNome();
                double valor = custo.getValor();

                totalPorDepartamento.put(departamentoNome, totalPorDepartamento.getOrDefault(departamentoNome, 0.0) + valor);
            }
        }

        if (totalPorDepartamento.isEmpty()) {

            System.out.println("\n[INFO] Não existem custos registrados nos últimos 3 meses.");

            return;

        }

        for (Map.Entry<String, Double> entry : totalPorDepartamento.entrySet()) {

            String departamento = entry.getKey();
            double total = entry.getValue();

            System.out.println("Departamento: " + departamento + " | Total dos últimos 3 meses: R$ " + String.format("%.2f", total));

        }
    }
}