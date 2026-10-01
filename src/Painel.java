import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Painel {

   private Funcionario operadorAtual;
    private List<Custo> custos;

    public Painel(Funcionario operadorAtual, List<Custo> custos) {
        this.operadorAtual = operadorAtual;
        this.custos = custos;
    }

    public void exibirPainel() {
        System.out.println("========= PAINEL =========");
        exibirOperadorLogado();
        exibirTotalMesAtual();
    }


    private void exibirOperadorLogado() {
        if (operadorAtual == null) {
            System.out.println("Operador logado: nenhum operador selecionado");
            return;
        }

        System.out.println("Operador logado: " + operadorAtual.getNome()
                + " (" + operadorAtual.getIniciais() + ")");
    }

    private void exibirTotalMesAtual() {
        LocalDate hoje = LocalDate.now();
        int mesAtual = hoje.getMonthValue();
        int anoAtual = hoje.getYear();

        double total = 0;

        for (int i = 0; i < custos.size(); i++) {
            Custo c = custos.get(i);
            if (c.getMes() == mesAtual && c.getAno() == anoAtual) {
                total += c.getValor();
            }
        }

        System.out.println("Total de custos do mês atual: "
                + String.format(new Locale("pt", "BR"), "R$ %,.2f", total));
    }
}