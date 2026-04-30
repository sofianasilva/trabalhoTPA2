package domain;
import colecao.IColecao;
import arvorebinaria.*;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        IColecao<Funcionario> funcionarios = new ArvoreBinaria<>(
            (f1, f2) -> Long.compare(f1.getCpf(), f2.getCpf())
        );
        Funcionario func;
        String nome;
        int cpf, opcao;
        float salario;

        Scanner s = new Scanner(System.in);

        //menu
        do{
            System.out.println("Escolha uma opcao");
            System.out.println("1 - Cadastrar um funcionario");
            System.out.println("2 - Pesquisar um funcionario");
            System.out.println("3 - Visualizar lista de funcionarios");
            System.out.println("4 - Excluir um funcionario");
            System.out.println("5 - Encerrar o programa");
            System.out.print(">>> ");
            opcao = s.nextInt();
            s.nextLine();//pra pegar o enter
            System.out.println();

            switch (opcao) {
                case 1: //CADASTRAR
                try{
                    System.out.print("Digite o nome: ");
                    nome = s.nextLine();
                    if (nome.isEmpty()){
                        System.out.println("O nome nao pode ser vazio. Tente novamente.");
                        break;
                    }
                    //System.out.println();


                    System.out.print("Digite o o cpf (apenas os digitos): ");
                    try{
                        cpf = s.nextInt();
                    }
                    catch(Exception e){
                        System.out.println("Cpf deve conter apenas numeros. Tente novamente.");
                        s.nextLine();//limpa o buffer
                        break;
                    }
                    //System.out.println();

                    System.out.print("Digite o salario (xxxx.xx): ");
                    try{
                        salario = s.nextFloat();
                    }
                    catch(Exception e){
                        System.out.println("Salario deve conter apenas numeros e um ponto decimal. Tente novamente.");
                        s.nextLine();//limpa o buffer
                        break;
                    }

                    s.nextLine();//pra pegar o enter
                    //System.out.println();
    
                    //criando o funcionario e add na lista
                    func = new Funcionario(nome, cpf, salario);
                    funcionarios.adicionar(func);
                    System.out.println("Funcionario cadastrado com sucesso.");
                }
                catch(Exception e){
                    System.out.println("Ocorreu um erro. Tente novamente.");
                }                
                break;
                
                case 2: //PESQUISAR
                    try{
                        if(funcionarios.quantidadeNos() == 0){
                            System.out.println("Nenhum funcionario cadastrado.");
                            break;
                        }
                        System.out.print("Digite o cpf (apenas os digitos): ");
                        try{
                            cpf = s.nextInt();
                        } catch(Exception e){
                            System.out.println("Cpf deve conter apenas numeros. Tente novamente.");
                            s.nextLine();//limpa o buffer
                            break;
                        }
                        s.nextLine();//pra pegar o enter
                        System.out.println();

                        func = funcionarios.pesquisar(new Funcionario("", cpf, 0));
                        if (func != null){
                            System.out.println("Funcionario encontrado.");
                            System.out.println(func);
                        } else {
                            System.out.println("Funcionario nao cadastrado.");
                        }
                        System.out.println();
                        System.out.println();
                    }catch(Exception e){
                        System.out.println("Erro ao pesquisar.");
                        s.nextLine();//limpa o buffer
                    }
                    break;

                case 3: //LISTAR
                    if (funcionarios.quantidadeNos() == 0){
                        System.out.println("Nenhum funcionario cadastrado.");
                    }else{
                        System.out.println("Funcionarios cadastrados:");
                        System.out.println(funcionarios);
                        System.out.println();
                        System.out.println();
                    }
                break;

                case 4: //EXCLUIR
                    try{
                        System.out.println("Digite o cpf do funcionario a ser excluido: ");
                        if (funcionarios.quantidadeNos() == 0){
                            System.out.println("Nenhum funcionario cadastrado.");
                            break;
                        }
                        System.out.println(funcionarios);
                        System.out.print(">>> ");
                        cpf = s.nextInt();
                        s.nextLine();//pra pegar o enter
                        System.out.println();

                        func = funcionarios.pesquisar(new Funcionario("", cpf, 0));
                        if (func == null){
                            System.out.println("Funcionario nao cadastrado.");
                            break;
                        }
                        //remover da lista
                        if (funcionarios.remover(func)){
                            System.out.println(String.format("O funcionario %s foi exluido com sucesso.", func.getNome()));
                        } else {
                            System.out.println("nao foi possivel excluir o funcionario.");
                        }
                        System.out.println();
                        System.out.println();
                    }catch(Exception e){
                        System.out.println("Erro ao excluir funcionario. Tente novamente.");    
                    } 
                break;
                    

            default:
                break;
                
            }
        } while (opcao != 5);

        s.close();
    }
}