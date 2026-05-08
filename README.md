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
│   └── ArvoreAVL.java              # Árvore AVL (auto-balanceada)
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

## 📊 Comparação das Estruturas

| Estrutura | Balanceamento | Inserção Ordenada | Permite Duplicatas |
|-----------|---------------|-------------------|-------------------|
| **ArvoreBinaria** | ❌ Não | O(n) - degenera | ✅ Sim |
| **ArvoreAVL** | ✅ Sim | O(log n) | ✅ Sim |
| **TreeSet** | ✅ Sim (Red-Black) | O(log n) | ❌ Não |

### Quando usar cada uma?

**ArvoreBinaria**: Apenas para fins didáticos ou quando dados já vêm balanceados

**ArvoreAVL**: Quando precisa de controle total e permite duplicatas

**TreeSet**: Para produção - robusta, testada e com performance garantida

## 💡 Exemplo de Uso

```java
// Todas usam Comparator da mesma forma
IColecao<Funcionario> funcionarios = new ArvoreBinaria<>(
    (f1, f2) -> Long.compare(f1.getCpf(), f2.getCpf())
);

// ou

TreeSet<Funcionario> funcionarios = new TreeSet<>(
    (f1, f2) -> Long.compare(f1.getCpf(), f2.getCpf())
);

// Operações
funcionarios.adicionar(new Funcionario("João", 12345678901L, 5000.0f));
Funcionario f = funcionarios.pesquisar(new Funcionario("", 12345678901L, 0));
funcionarios.remover(f);
int total = funcionarios.quantidadeNos(); // ou size() no TreeSet
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

## 🔍 Diferenças Principais

### ArvoreBinaria vs TreeSet

**Semelhanças:**
- Ambos usam Comparator
- Sintaxe similar

**Diferenças:**
- TreeSet não permite duplicatas
- TreeSet nunca degenera
- TreeSet tem métodos extras: `ceiling()`, `floor()`, `first()`, `last()`

### Exemplo de Busca

```java
// ArvoreBinaria
Funcionario f = funcionarios.pesquisar(new Funcionario("", cpf, 0));

// TreeSet
Funcionario buscado = new Funcionario("", cpf, 0);
Funcionario f = funcionarios.ceiling(buscado);
if (f != null && f.getCpf() == cpf) {
    // Encontrado
}
```

## 📚 Documentação Adicional

- `RELATORIO_SECAO5_TREESET.md` - Análise completa do TreeSet
- `RESUMO_PARA_ENTREVISTA.md` - Pontos-chave
- `GUIA_RAPIDO.md` - Instruções rápidas

## 👥 Equipe

- Larissa
- Luma
- Sofia

## 📌 Repositório

https://github.com/lari-ms/trab-1-tpa

---

**Disciplina**: Técnicas de Programação Avançada (TPA)  
**Tema**: Árvores Binárias e Análise de Complexidade
