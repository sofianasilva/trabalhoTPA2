# Trabalho de TPA – Árvores Binárias

Implementação de biblioteca de árvores binárias em Java e análise de complexidade.

## 📁 Estrutura do Projeto

```
src/
├── arvorebinaria/
│   ├── ArvoreBinaria.java          # Árvore binária simples
│   ├── ArvoreBinariaBase.java      # Classe base
│   └── No.java                     # Nó da árvore
│
├── arvoreAVL/
│   └── ArvoreAVL.java              # Árvore AVL 
│
├── colecao/
│   └── IColecao.java               # Interface da coleção
│
├── domain/
│   ├── Funcionario.java            # Classe de domínio
│   ├── Main.java                   # App com ArvoreBinaria
│   └── MainTreeSet.java            # App com TreeSet (Java)
│
└── testes/
    ├── funcionariosBalanceados100k.txt
    ├── funcionariosBalanceados500k.txt
    ├── funcionariosBalanceados1Mi.txt
    ├── funcionariosOrdenados100k.txt
    ├── funcionariosOrdenados500k.txt
    └── funcionariosOrdenados1Mi.txt
```

## 🎯 O que foi implementado?

### 1. Biblioteca de Árvores Binárias
- **ArvoreBinaria**: Árvore binária de busca simples
- **ArvoreAVL**: Árvore AVL com auto-balanceamento
- Usa **Generics** e **Comparator** para flexibilidade

### 2. Aplicativo de Gerenciamento
Sistema interativo para cadastrar, pesquisar, listar e excluir funcionários.

### 3. Versão com TreeSet
Implementação usando a estrutura de árvore padrão do Java (Red-Black Tree).

## 🚀 Como Executar

### Versão com ArvoreBinaria
```bash
javac src/domain/Funcionario.java src/arvorebinaria/*.java src/colecao/*.java src/domain/Main.java
java -cp src domain.Main
```

### Versão com ArvoreAVL
```bash
javac src/domain/Funcionario.java src/arvoreAVL/*.java src/arvorebinaria/*.java src/colecao/*.java src/domain/Main.java
java -cp src domain.Main
```

### Versão com TreeSet (Java)
```bash
javac src/domain/Funcionario.java src/domain/MainTreeSet.java
java -cp src domain.MainTreeSet
```

## 📈 Análise de Complexidade

### ArvoreBinaria
- **Melhor caso** (balanceada): O(log n)
- **Pior caso** (degenerada): O(n)
- **Depende da ordem de inserção**

### ArvoreAVL
- **Sempre**: O(log n)
- Faz rotações para manter balanceamento
- Mais rotações que Red-Black

### TreeSet (Red-Black Tree)
- **Sempre**: O(log n)
- Menos rotações que AVL
- Melhor para uso geral

## 📝 Arquivos de Teste

Os arquivos na pasta `testes/` contêm funcionários para análise empírica:

- **Balanceados**: Inserção gera árvore balanceada
- **Ordenados**: Inserção gera árvore degenerada (pior caso)
- **Tamanhos**: 100k, 500k e 1Mi registros


## 👥 Equipe

- Larissa
- Luma
- Sofia

## 📄 Relatório Completo

O relatório completo com todas as análises matemáticas e empíricas está disponível em:
[Link para o documento]([https://docs.google.com/document/d/1s9j7zC113brwik7d8vEWFbzAqe7uH03om-F15QsihKU/edit?tab=t.0](https://docs.google.com/document/d/1DrJOuXkaV7Xl58u8MXh7q0BON3WFSHSX7K7MxTiUHL0/edit?usp=sharing))
