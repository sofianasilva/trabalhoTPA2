package arvorebinaria;

import java.util.Comparator;

public class ArvoreBinaria<T> extends ArvoreBinariaBase<T> {
    
    private No<T> raiz;

    // construtor recebe o comparador pra saber como ordenar
    public ArvoreBinaria(Comparator<T> comparador) {
        super(comparador);
        this.raiz = null;
    }

    @Override
    public void adicionar(T novoValor) {
        raiz = adicionarRecursivo(raiz, novoValor);
    }

    // adiciona recursivamente, vai descendo a arvore ate achar o lugar certo
    private No<T> adicionarRecursivo(No<T> noAtual, T valor) {
        // se chegou num lugar vazio, cria o no aqui
        if (noAtual == null) {
            return new No<>(valor);
        }

        int comparacao = comparador.compare(valor, noAtual.getValor());
        
        // menor vai pra esquerda
        if (comparacao < 0) {
            noAtual.setNoEsquerdo(adicionarRecursivo(noAtual.getNoEsquerdo(), valor));
        } else if (comparacao > 0) {
            // maior vai pra direita
            noAtual.setNoDireito(adicionarRecursivo(noAtual.getNoDireito(), valor));
        }
        // se for igual nao adiciona de novo
        
        return noAtual;
    }

    @Override
    public T pesquisar(T valor) {
        return pesquisarRecursivo(raiz, valor);
    }

    // busca o valor na arvore
    private T pesquisarRecursivo(No<T> noAtual, T valor) {
        // nao achou
        if (noAtual == null) {
            return null;
        }

        int comparacao = comparador.compare(valor, noAtual.getValor());

        if (comparacao == 0) {
            // achou!
            return noAtual.getValor();
        } else if (comparacao < 0) {
            // procura na esquerda
            return pesquisarRecursivo(noAtual.getNoEsquerdo(), valor);
        } else {
            // procura na direita
            return pesquisarRecursivo(noAtual.getNoDireito(), valor);
        }
    }

    @Override
    public boolean remover(T valor) {
        // verifica se existe antes de tentar remover
        if (pesquisar(valor) == null) {
            return false;
        }
        raiz = removerRecursivo(raiz, valor);
        return true;
    }

    private No<T> removerRecursivo(No<T> noAtual, T valor) {
        if (noAtual == null) {
            return null;
        }

        int comparacao = comparador.compare(valor, noAtual.getValor());

        if (comparacao < 0) {
            noAtual.setNoEsquerdo(removerRecursivo(noAtual.getNoEsquerdo(), valor));
        } else if (comparacao > 0) {
            noAtual.setNoDireito(removerRecursivo(noAtual.getNoDireito(), valor));
        } else {
            // achou o no pra remover
            
            // no sem filhos
            if (noAtual.getNoEsquerdo() == null && noAtual.getNoDireito() == null) {
                return null;
            }
            
            // no com um filho so
            if (noAtual.getNoEsquerdo() == null) {
                return noAtual.getNoDireito();
            }
            if (noAtual.getNoDireito() == null) {
                return noAtual.getNoEsquerdo();
            }
            
            // no com dois filhos (mais chato)
            // pega o menor da direita pra substituir
            T menorValor = encontrarMenorValor(noAtual.getNoDireito());
            noAtual.setValor(menorValor);
            noAtual.setNoDireito(removerRecursivo(noAtual.getNoDireito(), menorValor));
        }

        return noAtual;
    }

    // acha o menor valor descendo sempre pra esquerda
    private T encontrarMenorValor(No<T> no) {
        return no.getNoEsquerdo() == null ? no.getValor() : encontrarMenorValor(no.getNoEsquerdo());
    }

    @Override
    public int quantidadeNos() {
        return contarNos(raiz);
    }

    // conta quantos nos tem na arvore
    private int contarNos(No<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getNoEsquerdo()) + contarNos(no.getNoDireito());
    }

    @Override
    public int altura() {
        return calcularAltura(raiz);
    }

    // calcula a altura da arvore
    private int calcularAltura(No<T> no) {
        if (no == null) {
            return -1; // arvore vazia tem altura -1
        }
        
        int alturaEsquerda = calcularAltura(no.getNoEsquerdo());
        int alturaDireita = calcularAltura(no.getNoDireito());
        
        // pega a maior altura e soma 1
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    
}
