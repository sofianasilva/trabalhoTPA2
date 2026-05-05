package arvoreAVL;
import arvorebinaria.*;
import java.util.Comparator;

public class ArvoreAVL<T> extends ArvoreBinaria<T> {
    private Comparator<T> comparator;
    private No<T> raiz;


    //construtor recebe o comparador pra saber como ordenar
    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
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

    
    private No<T> balanceararvore(No<T> noAtual){
        int fatorbalanceamento = getFatorBalanceamento(noAtual);

        //se o fator de balanceamento for maior que 1, a subarvore esquerda é mais alta que a direita, entao tem que rotacionar pra direita
        if(fatorbalanceamento>1){
        
    }
}