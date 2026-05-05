package arvoreAVL;
import arvorebinaria.*;
import java.util.Comparator;

public class ArvoreAVL<T> extends ArvoreBinaria<T> {
    private Comparator<T> comparator;
    private No<T> raiz;


    //construtor recebe o comparador pra saber como ordenar
    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
        this.comparator = comparator;
        this.raiz = null;
    }
    
    @Override
    public void adicionar(T valor) {
        this.raiz = adicionar(this.raiz, valor);
    }

    private No<T> adicionar (No<T> noAtual, T valor){
        //caso a arvore esteja vazia ou tenha chegado num lugar vazio, cria o no aqui
        if(noAtual==null){
            return new No<>(valor);
        }
        int comparacao = comparator.compare(valor, noAtual.getValor());
        //se menor que zero o valor atual é menor que o valor do nó, entao vai pra esquerda
        if(comparacao<0){
            noAtual.setNoEsquerdo(adicionar(noAtual.getNoEsquerdo(), valor));
        }
        //se maior que zero o valor atual é maior que o valor do nó, entao vai pra direita
        if(comparacao>0){
            noAtual.setNoDireito(adicionar(noAtual.getNoDireito(), valor));
        }
        if(comparacao==0){
            //se for igual nao adiciona de novo
            return noAtual;
        }

        atualizarAltura(noAtual);

        //verificar o balanceamento da arvore e fazer as rotações se necessário quando adicionar o novo nó - o balanceamento é feito de baixo pra cima
        return balanceararvore(noAtual);
          
    }

    private void atualizarAltura(No<T> noAtual){
       if(noAtual.getNoEsquerdo()==null && noAtual.getNoDireito()==null){
            noAtual.setAltura(0);
        }
        else if(noAtual.getNoEsquerdo()==null){
            noAtual.setAltura(1+noAtual.getNoDireito().getAltura());
        }
        else if(noAtual.getNoDireito()==null){
            noAtual.setAltura(1+noAtual.getNoEsquerdo().getAltura());
        }
        else{
            noAtual.setAltura(1+Math.max(noAtual.getNoEsquerdo().getAltura(), noAtual.getNoDireito().getAltura()));
        }
        return;
    }

    private int getFatorBalanceamento(No<T> noAtual){
        //inicializa os nos com altura -1
        int alturaEsquerda = -1;
        int alturaDireita = -1;
        //verifica se os nos existem, se existirem pega a altura, se nao existirem fica -1
        if(noAtual.getNoEsquerdo()!=null) {
            alturaEsquerda = noAtual.getNoEsquerdo().getAltura();
        }
        if(noAtual.getNoDireito()!=null) {
            alturaDireita = noAtual.getNoDireito().getAltura();
        }
        return alturaEsquerda - alturaDireita;
    }

    private No<T> rotacaoEsquerda(No<T> noAtual){
        No<T> novaRaiz = noAtual.getNoDireito();
        noAtual.setNoDireito(novaRaiz.getNoEsquerdo());
        novaRaiz.setNoEsquerdo(noAtual);
        atualizarAltura(noAtual);
        atualizarAltura(novaRaiz);
        return novaRaiz;
    }

    private No<T> rotacaoDireita(No<T> noAtual){
        No<T> novaRaiz = noAtual.getNoEsquerdo();
        noAtual.setNoEsquerdo(novaRaiz.getNoDireito());
        novaRaiz.setNoDireito(noAtual);
        atualizarAltura(noAtual);
        atualizarAltura(novaRaiz);
        return novaRaiz;
    }

    private No<T> rotacaoDireitaEsquerda(No<T> noAtual){
        noAtual.setNoDireito(rotacaoDireita(noAtual.getNoDireito()));
        return rotacaoEsquerda(noAtual);
    }

    private No<T> rotacaoEsquerdaDireita(No<T> noAtual){
        noAtual.setNoEsquerdo(rotacaoEsquerda(noAtual.getNoEsquerdo()));
        return rotacaoDireita(noAtual);
    }



    
    private No<T> balanceararvore(No<T> noAtual) {
        int fb = getFatorBalanceamento(noAtual);

        // CASO 1: Pendente para a Esquerda (FB > 1)
        if (fb > 1) {
            // Verifica o filho ESQUERDO
            if (getFatorBalanceamento(noAtual.getNoEsquerdo()) >= 0) {
                // Caso LL (Linha reta à esquerda)
                return rotacaoDireita(noAtual);
            } else {
                // Caso LR (Joelho à esquerda)
                return rotacaoEsquerdaDireita(noAtual);
            }
        }

        // CASO 2: Pendente para a Direita (FB < -1)
        if (fb < -1) {
            // Verifica o filho DIREITO
            if (getFatorBalanceamento(noAtual.getNoDireito()) <= 0) {
                // Caso RR (Linha reta à direita)
                return rotacaoEsquerda(noAtual);
            } else {
                // Caso RL (Joelho à direita)
                return rotacaoDireitaEsquerda(noAtual);
            }
        }

        // Se não precisar de balanceamento, retorna o próprio nó
        return noAtual;
    }

}