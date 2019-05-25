package implementhash;

import java.util.Iterator;

public class IteratorLista<T> implements Iterator<T> {

    private int passos;
    private ListaEncadeada<T> lista;
    private Caixa<T> caixa;

    public IteratorLista() {
    }

    public IteratorLista(ListaEncadeada<T> lista) {
        this.lista = lista;
        this.caixa = lista.getInicio();
    }

    @Override
    public boolean hasNext() {
        return this.passos < this.lista.Tamanho();
    }

    @Override
    public T next() {

        Caixa<T> obj = this.caixa;
        this.caixa = this.caixa.getProximo();
        this.passos++;
        return obj.getElemento();
    }

}
