package arvorebinaria;

public class No<T> {
    
    private T valor;
    private No<T> noEsquerdo;
    private No<T> noDireito;
    private int altura; //so pra AVL - mas como a AVL herda da binaria tem que ter aqui

    public No(T valor){
        this.valor = valor;
        this.noEsquerdo = null;
        this.noDireito = null;
        this.altura = 0;
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

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
