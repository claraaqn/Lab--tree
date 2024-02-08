package tree;

public class No {
    private int valor;
    private No proximo;
    private No anterior;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }

    public int getValor() {
        return this.valor;
    }

    public No getProximo() {
        return this.proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return this.anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}
