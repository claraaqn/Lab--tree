package tree;

import estrut.Tree;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree implements Tree {

    private No raiz;

    // Implementação da classe No
    private static class No {
        int valor;
        No esquerda;
        No direita;

        No(int valor) {
            this.valor = valor;
        }
    }

    @Override
    public boolean buscaElemento(int valor) {
        return buscaElementoRecursivo(raiz, valor);
    }

    private boolean buscaElementoRecursivo(No no, int valor) {
        if (no == null) {
            return false;
        }

        if (valor == no.valor) {
            return true;
        } else if (valor < no.valor) {
            return buscaElementoRecursivo(no.esquerda, valor);
        } else {
            return buscaElementoRecursivo(no.direita, valor);
        }
    }

    @Override
    public int minimo() {
        if (raiz == null) {
            throw new IllegalStateException("Árvore vazia");
        }
        return encontraMenorValor(raiz);
    }

    private int encontraMenorValor(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no.valor;
    }

    @Override
    public int maximo() {
        if (raiz == null) {
            throw new IllegalStateException("Árvore vazia");
        }
        return encontraMaiorValor(raiz);
    }

    private int encontraMaiorValor(No no) {
        while (no.direita != null) {
            no = no.direita;
        }
        return no.valor;
    }

    @Override
    public void insereElemento(int valor) {
        raiz = insereElementoRecursivo(raiz, valor);
    }

    private No insereElementoRecursivo(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerda = insereElementoRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = insereElementoRecursivo(no.direita, valor);
        }

        return no;
    }

    @Override
    public void remove(int valor) {
        raiz = removeRecursivo(raiz, valor);
    }

    private No removeRecursivo(No no, int valor) {
        if (no == null) {
            return null;
        }

        if (valor == no.valor) {
            if (no.esquerda == null) {
                return no.direita;
            } else if (no.direita == null) {
                return no.esquerda;
            } else {
                no.valor = encontraMenorValor(no.direita);
                no.direita = removeRecursivo(no.direita, no.valor);
            }
        } else if (valor < no.valor) {
            no.esquerda = removeRecursivo(no.esquerda, valor);
        } else {
            no.direita = removeRecursivo(no.direita, valor);
        }

        return no;
    }

    @Override
    public int[] preOrdem() {
        List<Integer> elementos = new ArrayList<>();
        preOrdemRecursivo(raiz, elementos);
        return elementos.stream().mapToInt(i -> i).toArray();
    }

    private void preOrdemRecursivo(No no, List<Integer> elementos) {
        if (no != null) {
            elementos.add(no.valor);
            preOrdemRecursivo(no.esquerda, elementos);
            preOrdemRecursivo(no.direita, elementos);
        }
    }

    @Override
    public int[] emOrdem() {
        List<Integer> elementos = new ArrayList<>();
        emOrdemRecursivo(raiz, elementos);
        return elementos.stream().mapToInt(i -> i).toArray();
    }

    private void emOrdemRecursivo(No no, List<Integer> elementos) {
        if (no != null) {
            emOrdemRecursivo(no.esquerda, elementos);
            elementos.add(no.valor);
            emOrdemRecursivo(no.direita, elementos);
        }
    }

    @Override
    public int[] posOrdem() {
        List<Integer> elementos = new ArrayList<>();
        posOrdemRecursivo(raiz, elementos);
        return elementos.stream().mapToInt(i -> i).toArray();
    }

    private void posOrdemRecursivo(No no, List<Integer> elementos) {
        if (no != null) {
            posOrdemRecursivo(no.esquerda, elementos);
            posOrdemRecursivo(no.direita, elementos);
            elementos.add(no.valor);
        }
    }
}
