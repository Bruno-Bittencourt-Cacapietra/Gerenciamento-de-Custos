public  abstract class Operador {
    protected String nome;

    public Operador(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getIniciais(){
        // Validação para evitar erros caso o nome venha vazio
        if (nome == null || nome.isBlank()){
            return "Não há um nome registrado";
        }
        // Divide o nome em palavras isoladas eliminando múltiplos espaços entre as palavras e das pontas
        String[] partes = this.nome.trim().split("\\s+");
        String iniciais = "";
        // Percorre cada palavra do nome capturando a primeira letra
        for (int i = 0; i < partes.length; i++){
                iniciais += partes[i].charAt(0);
        }
        // Retorna as iniciais em letras maiúsculas
        return iniciais.toUpperCase();

    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\nIniciais: " + getIniciais();
    }

}
