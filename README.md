# Sistema de Gestão de Custos

Um sistema em Java de interface via linha de comando (CLI) projetado para registrar, gerenciar e analisar custos operacionais e despesas de diferentes departamentos de uma empresa. 

O projeto aplica conceitos fundamentais de Programação Orientada a Objetos (POO), como Herança, Encapsulamento, Validações de Dados e manipulação de Listas.

## Funcionalidades

O sistema baseia-se em um menu interativo com as seguintes opções:

- **Trocar Operador:** Permite selecionar qual funcionário cadastrado está operando o sistema no momento. Nenhum custo pode ser registrado sem um operador logado.
- **Cadastrar Funcionário:** Cria novos usuários no sistema associando-os a uma matrícula e a um departamento específico.
- **Registrar Custo:** Registra uma nova despesa contendo valor, descrição, data, categoria e o departamento responsável. Inclui validações rigorosas (ex: impede valores negativos e datas inexistentes).
- **Pesquisar Custos**: Permitirá filtrar despesas por descrição, categoria, data ou departamento.
- **Excluir Custo Mais Recente:** Remove apenas o último custo inserido no sistema, funcionando como uma opção de "Desfazer".
- **Painel de Indicadores**: Exibirá estatísticas financeiras, como total gasto no mês, top 3 funcionários com maiores gastos e histórico dos últimos meses.

## Tecnologias Utilizadas e Pré-Requisitos

- **Linguagem:** Java (JDK 8 ou superior, devido ao uso do pacote `java.time`).
- **Bibliotecas padrão:** `java.util.*` (List, ArrayList, Scanner) e `java.time.*` (LocalDate para validação de datas).

## Estrutura de Classes (Arquitetura)

O sistema foi modularizado para facilitar a manutenção e leitura do código:

* **`App`**: Classe principal que contém o método `main`, gerencia as listas globais e exibe o menu interativo.
* **`Operador`** *(Abstract)*: Classe base para usuários do sistema. Contém a lógica para extração das iniciais do nome.
* **`Funcionario`**: Herda de `Operador`. Representa os colaboradores da empresa e adiciona atributos como matrícula e departamento.
* **`Custo`**: Classe central do sistema. Associa um valor financeiro a uma categoria, departamento e funcionário.
* **`Departamento`**: Representa os setores da empresa (ex: TI, Recursos Humanos, Financeiro).
* **`Categoria`** *(Enum)*: Padroniza os tipos de custos aceitos (`AQUISICAO_DE_BENS`, `MANUTENCAO_DE_BENS`, `OUTROS_SERVICOS`).
* **Classes de Serviço/Execução**: `CadastrarFuncionario`, `RegistrarCusto`, `ExcluirCusto`, `Sistema` (responsável pelo login/troca de operador).
* **`ValidacaoCusto`**: Classe utilitária focada em garantir a integridade dos dados (impede datas como 30/02, valores negativos, etc.).

## Como Executar o Projeto

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado na sua máquina.
2. Faça o clone do repositório ou baixe os arquivos fonte.
3. Abra o terminal na pasta raiz onde os arquivos `.java` estão localizados.
4. Compile todos os arquivos Java com o comando:
   ```bash
   javac *.java
