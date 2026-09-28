/**
 * Enumeração para delimitar as categorias de custos aceitas pelo sistema,
 * conforme definido no enunciado do trabalho.
 */

public enum Categoria {
    AQUISICAO_DE_BENS("Aquisição de Bens"),
    MANUTENCAO_DE_BENS("Manutenção de Bens"),
    OUTROS_SERVICOS("Outros Serviços");

    private final String descricao;

    Categoria(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
    @Override
    public String toString(){
        return this.descricao;
    }
}
