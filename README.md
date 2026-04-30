Trabalho de TPA – Árvores Binárias e Análise de complexidade

Este repositório contém a implementação prática e a análise de complexidade referentes ao trabalho sobre Árvores Binárias, desenvolvido para a disciplina de Técnicas de Programação Avançada (TPA).

🎯 Objetivos do Trabalho

O projeto teve como objetivos principais:

    Implementação de uma biblioteca de listas encadeadas genéricas em Java utilizando Generics.
    Desenvolvimento de métodos essenciais para manipulação de listas:
        adicionar(T novoValor)
        pesquisar(T valor)
        remover(T valor)
        quantidadeNos()
    Criação de um programa interativo para testar a biblioteca com objetos do tipo Funcionario.
    Análise matemática de complexidade dos métodos implementados.
    Análise empírica com medições de desempenho usando arquivos de teste de diferentes tamanhos.
    Estudo das estruturas nativas do Java (ArrayList e LinkedList), avaliando:
        Funcionamento interno
        Complexidade teórica das operações
        Resultados empíricos comparativos

🧩 Estrutura do Repositório

A organização dos arquivos foi feita de forma a facilitar a navegação e a execução dos testes:

src/
├── parte1/
│   └── domain/
│       └── Main.java                           # Programa de teste inicial
│
└── parte2/
    ├── colecao/
    │   └── IColecao.java                       # Interface da coleção
    │
    ├── domain/
    │   ├── Funcionario.java                    # Classe modelo 
    │   ├── Main.java                           # Programa interativo de teste
    │   └── LeitorArquivos.java                 # Programa de análise empírica
    │
    ├── src/
    │   ├── ListaEncadeada.java                 # Implementação da lista encadeada
    │   ├── ListaEncadeadaArrayList.java        # ArrayList
    │   ├── ListaEncadeadaLinkedList.java       # LinkedList
    │   └── No.java                             # Classe nó da lista
    │
    └── testes/
        ├── funcionarios100k.txt                # Arquivo de teste (100k registros)
        ├── funcionarios200k.txt                # Arquivo de teste (200k registros)
        ├── funcionarios400k.txt                # Arquivo de teste (400k registros)
        └── GeradorArquivosOrdenados.java       # Gerador de arquivos de teste

📚 Implementação

A lista encadeada foi projetada para ser genérica e reutilizável, aceitando qualquer tipo de objeto através de Generics.

A classe Funcionario representa o domínio escolhido para os testes, contendo:

    Nome
    CPF (usado para comparação no método equals())
    Salário

A biblioteca implementa a interface IColecao<T>, garantindo que todas as implementações (ListaEncadeada, ArrayList e LinkedList) sigam o mesmo contrato.
⏳ Análise de Complexidade

Foram analisadas as operações principais da lista encadeada:
Operação 	Complexidade 	Justificativa
Adicionar (final) 	O(1) 	Acesso direto ao último nó
Pesquisar 	O(n) 	Busca linear percorrendo todos os nós
Remover 	O(n) 	Necessário encontrar o nó anterior
Quantidade de nós 	O(1) 	Retorna contador mantido internamente

Além disso, o trabalho inclui uma comparação entre ArrayList e LinkedList, abordando:

    Busca por elemento
    Inserções no final
    Remoções do último elemento
    Explicando quando cada estrutura é mais eficiente

🧪 Testes Empíricos

Para validar a análise teórica, foram feitos testes de desempenho com entradas de tamanhos variados (100k, 200k, 400k elementos), medindo:

    Tempo de leitura e inserção de todos os elementos
    Tempo de busca pelo último elemento
    Tempo de busca por elemento inexistente
    Tempo de remoção do último elemento
    Tempo de obtenção da quantidade de elementos

🏗️ Tecnologias Utilizadas

    Java SE 8+
    Generics para implementação genérica
    ArrayList e LinkedList para testes comparativos
    System.nanoTime() para medições de desempenho

📌 Como Executar
1. Clone este repositório:

git clone https://github.com/lari-ms/trab-1-tpa.git
cd trab-1-tpa

2. Compile os arquivos:

cd src/parte2
javac -d bin domain/*.java colecao/*.java src/*.java

3. Execute o programa interativo:

java -cp bin domain.Main

O programa permite cadastrar, pesquisar, visualizar e excluir funcionários.
4. Execute a análise empírica:

java -cp bin domain.LeitorArquivos

Este programa lê um arquivo de teste e exibe os tempos de execução de cada operação.
📄 Relatório Completo

O relatório completo com todas as análises matemáticas e empíricas está disponível em: Link para o documento
👥 Integrantes do Projeto

    Larissa
    Luma
    Sofia
