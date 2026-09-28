/**
 * Representa os setores da empresa pré-cadastrados no sistema para vincular aos custos e funcionários.
 */

public class Departamento{
    private String nome;
    
    public Departamento(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    @Override
    public String toString(){
        return this.nome;
    }
}
