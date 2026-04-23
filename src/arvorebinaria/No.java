package arvorebinaria;

public class No<T> {
    
    private T valor;
    private No<T> noEsquerdo;
    private No<T> noDireito;

    public No(T valor){
        this.valor = valor;
        this.noEsquerdo = null;
        this.noDireito = null;
    }

    public T getValor() {
        return valor;
    }

    public No<T> getNoEsquerdo() {
        return noEsquerdo;
    }

    public No<T> getNoDireito() {
        return noDireito;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void setNoEsquerdo(No<T> noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public void setNoDireito(No<T> noDireito) {
        this.noDireito = noDireito;
    }
}
