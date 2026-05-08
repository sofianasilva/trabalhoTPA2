package domain;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Versão do aplicativo usando a estrutura de árvore padrão do Java (TreeSet).
 * 
 * TreeSet é uma implementação de NavigableSet baseada em TreeMap, que por sua vez
 * é implementado como uma Red-Black Tree (árvore rubro-negra).
 * 
 * TreeSet armazena elementos únicos e ordenados. A ordenação é definida por um
 * Comparator fornecido no construtor ou pela ordem natural dos elementos.
 * 
 * Complexidade das operações no TreeSet:
 * - Inserção (add): O(log n)
 * - Busca (contains/ceiling/floor): O(log n)
 * - Remoção (remove): O(log n)
 * - Tamanho (size): O(1)
 * 
 * A árvore Red-Black garante que a altura da árvore seja sempre O(log n),
 * evitando degeneração mesmo com inserções ordenadas.
 */
public class MainTreeSet {

    public static void main(String[] args) {
        // TreeSet com Comparator que compara funcionários por CPF
        // Isso é equivalente ao Comparator usado na ArvoreBinaria
        TreeSet<Funcionario> funcionarios = new TreeSet<>(
            (f1, f2) -> Long.compare(f1.getCpf(), f2.getCpf())
        );
        
        Funcionario func;
        String nome;
        long cpf;
        int opcao;
        float salario;

        Scanner s = new Scanner(System.in);

        // Menu
        do {
            System.out.println("=== SISTEMA DE FUNCIONÁRIOS (TreeSet - Java) ===");
            System.out.println("Escolha uma opcao");
            System.out.println("1 - Cadastrar um funcionario");
            System.out.println("2 - Pesquisar um funcionario");
            System.out.println("3 - Visualizar lista de funcionarios");
            System.out.println("4 - Excluir um funcionario");
            System.out.println("5 - Encerrar o programa");
            System.out.print(">>> ");
            opcao = s.nextInt();
            s.nextLine(); // pra pegar o enter
            System.out.println();

            switch (opcao) {
                case 1: // CADASTRAR
                    try {
                        System.out.print("Digite o nome: ");
                        nome = s.nextLine();
                        if (nome.isEmpty()) {
                            System.out.println("O nome nao pode ser vazio. Tente novamente.");
                            break;
                        }

                        System.out.print("Digite o cpf (apenas os digitos): ");
                        try {
                            cpf = s.nextLong();
                        } catch (Exception e) {
                            System.out.println("Cpf deve conter apenas numeros. Tente novamente.");
                            s.nextLine(); // limpa o buffer
                            break;
                        }

                        System.out.print("Digite o salario (xxxx.xx): ");
                        try {
                            salario = s.nextFloat();
                        } catch (Exception e) {
                            System.out.println("Salario deve conter apenas numeros e um ponto decimal. Tente novamente.");
                            s.nextLine(); // limpa o buffer
                            break;
                        }

                        s.nextLine(); // pra pegar o enter

                        // Criando o funcionario
                        func = new Funcionario(nome, cpf, salario);
                        
                        // add() retorna false se o elemento já existe (CPF duplicado)
                        // Equivalente ao adicionar() da IColecao
                        boolean adicionado = funcionarios.add(func);
                        if (adicionado) {
                            System.out.println("Funcionario cadastrado com sucesso.");
                        } else {
                            System.out.println("Ja existe um funcionario cadastrado com este CPF.");
                        }
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro. Tente novamente.");
                        s.nextLine(); // limpa o buffer
                    }
                    break;

                case 2: // PESQUISAR
                    try {
                        if (funcionarios.isEmpty()) {
                            System.out.println("Nenhum funcionario cadastrado.");
                            break;
                        }
                        System.out.print("Digite o cpf (apenas os digitos): ");
                        try {
                            cpf = s.nextLong();
                        } catch (Exception e) {
                            System.out.println("Cpf deve conter apenas numeros. Tente novamente.");
                            s.nextLine(); // limpa o buffer
                            break;
                        }
                        s.nextLine(); // pra pegar o enter
                        System.out.println();

                        // TreeSet não tem método get() direto como TreeMap
                        // Usamos ceiling() para buscar o elemento
                        // Criamos um funcionário temporário apenas com o CPF para busca
                        Funcionario buscado = new Funcionario("", cpf, 0);
                        
                        // ceiling() retorna o menor elemento >= ao buscado
                        // Se o CPF for igual, encontramos o funcionário
                        func = funcionarios.ceiling(buscado);
                        
                        if (func != null && func.getCpf() == cpf) {
                            System.out.println("Funcionario encontrado.");
                            System.out.println(func);
                        } else {
                            System.out.println("Funcionario nao cadastrado.");
                        }
                        System.out.println();
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println("Erro ao pesquisar.");
                        s.nextLine(); // limpa o buffer
                    }
                    break;

                case 3: // LISTAR
                    if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionario cadastrado.");
                    } else {
                        System.out.println("Funcionarios cadastrados (ordenados por CPF):");
                        // TreeSet mantém os elementos ordenados pelo Comparator
                        for (Funcionario f : funcionarios) {
                            System.out.println(f);
                        }
                        System.out.println();
                        System.out.println("Total: " + funcionarios.size() + " funcionarios");
                        System.out.println();
                    }
                    break;

                case 4: // EXCLUIR
                    try {
                        if (funcionarios.isEmpty()) {
                            System.out.println("Nenhum funcionario cadastrado.");
                            break;
                        }
                        
                        System.out.println("Funcionarios cadastrados:");
                        for (Funcionario f : funcionarios) {
                            System.out.println(f);
                        }
                        
                        System.out.println("Digite o cpf do funcionario a ser excluido: ");
                        System.out.print(">>> ");
                        cpf = s.nextLong();
                        s.nextLine(); // pra pegar o enter
                        System.out.println();

                        // Criar funcionário temporário para busca
                        Funcionario buscado = new Funcionario("", cpf, 0);
                        
                        // Primeiro verificar se existe
                        func = funcionarios.ceiling(buscado);
                        if (func == null || func.getCpf() != cpf) {
                            System.out.println("Funcionario nao cadastrado.");
                            break;
                        }
                        
                        // remove() retorna true se removeu, false caso contrário
                        // Equivalente ao remover() da IColecao
                        boolean removido = funcionarios.remove(func);
                        if (removido) {
                            System.out.println(String.format("O funcionario %s foi excluido com sucesso.", func.getNome()));
                        } else {
                            System.out.println("Nao foi possivel excluir o funcionario.");
                        }
                        System.out.println();
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println("Erro ao excluir funcionario. Tente novamente.");
                        s.nextLine(); // limpa o buffer
                    }
                    break;

                default:
                    if (opcao != 5) {
                        System.out.println("Opcao invalida. Tente novamente.");
                    }
                    break;
            }
        } while (opcao != 5);

        System.out.println("Programa encerrado.");
        s.close();
    }
}
