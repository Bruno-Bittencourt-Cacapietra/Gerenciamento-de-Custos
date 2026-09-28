import java.time.*;
import java.util.*;

public class ValidacaoCusto {
    
    public static boolean validarValor(double valor) {
        return valor >= 0;
    }

    public static boolean validarData(int dia, int mes, int ano) {
        try {
            LocalDate.of(ano, mes, dia);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public static boolean validarCategoria(Categoria categoria) {
        return categoria != null;
    }

    public static boolean validarDepartamento(Departamento departamento, List<Departamento> departamentos) {
        if (departamento == null) {
            return false;
        }

        for (int i = 0; i < departamentos.size(); i++) {
            if (departamentos.get(i) == departamento) {
                return true;
            }
        }

        return false;
    }
}



