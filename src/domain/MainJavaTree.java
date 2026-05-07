package domain;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class MainJavaTree {

    public static void main(String[] args) {
        // treemap usa cpf como chave e funcionario como valor
        // o comparator compara os cpf para manter a arvore ordenada
        TreeMap<Long, Funcionario> funcionarios = new TreeMap<>();
        
        Funcionario func;
        String nome;
        long cpf;
        int opcao;
        float salario;

        Scanner s = new Scanner(System.in);

        // menu
        do {
            System.out.println("=== SISTEMA DE FUNCIONÁRIOS (TreeMap - Java) ===");
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

                        // Verificar se CPF já existe
                        if (funcionarios.containsKey(cpf)) {
                            System.out.println("Ja existe um funcionario cadastrado com este CPF.");
                            break;
                        }

                        // Criando o funcionario e adicionando no TreeMap
                        func = new Funcionario(nome, cpf, salario);
                        funcionarios.put(cpf, func); // put() é equivalente ao adicionar()
                        System.out.println("Funcionario cadastrado com sucesso.");
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

                        // get() é equivalente ao pesquisar()
                        func = funcionarios.get(cpf);
                        if (func != null) {
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
                        // TreeMap mantém os elementos ordenados pela chave (CPF)
                        for (Funcionario f : funcionarios.values()) {
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
                        for (Funcionario f : funcionarios.values()) {
                            System.out.println(f);
                        }
                        
                        System.out.println("Digite o cpf do funcionario a ser excluido: ");
                        System.out.print(">>> ");
                        cpf = s.nextLong();
                        s.nextLine(); // pra pegar o enter
                        System.out.println();

                        // Verificar se o funcionário existe antes de remover
                        func = funcionarios.get(cpf);
                        if (func == null) {
                            System.out.println("Funcionario nao cadastrado.");
                            break;
                        }
                        
                        // remove() é equivalente ao remover()
                        // Retorna o valor removido ou null se não existir
                        Funcionario removido = funcionarios.remove(cpf);
                        if (removido != null) {
                            System.out.println(String.format("O funcionario %s foi excluido com sucesso.", removido.getNome()));
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
