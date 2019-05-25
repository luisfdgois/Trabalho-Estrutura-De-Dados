package implementhash;

import java.util.Iterator;

public class ListaEncadeada<T> implements IListaEncadeada<T> {

    private Caixa<T> inicio;
    private Caixa<T> fim;
    private int tamanho;

    public ListaEncadeada() {

    }

    public Caixa<T> getInicio() {
        return inicio;
    }

    public Caixa<T> getFim() {
        return fim;
    }

    @Override
    public void Adicionar(T elemento) {

        Caixa<T> caixa = new Caixa(elemento);

        if (this.inicio == null) {
            this.inicio = this.fim = caixa;
        } else {
            this.fim.setProximo(caixa);
            this.fim = caixa;
        }
        this.tamanho++;
    }

    @Override
    public T Remover(int indice) {

        Caixa<T> obj = this.inicio;
        int i = 0;

        if (indice == 0) {
            this.inicio = this.inicio.getProximo();

            if (this.inicio == null) {
                this.fim = null;
            }
            this.tamanho--;
            return this.inicio.getElemento();

        } else {

            while (i < (indice - 1)) {
                i++;
                obj = obj.getProximo();
            }

            Caixa<T> temp = obj.getProximo();

            if (temp.getElemento().equals(this.fim.getElemento())) {
                obj.setProximo(null);
                this.fim = obj;
                return this.fim.getElemento();
            } else {
                obj.setProximo(temp.getProximo());
            }

            this.tamanho--;

            return temp.getElemento();
        }
    }

    @Override
    public boolean Remover(Object elemento) {

        Caixa<T> obj = this.inicio;

        if (this.inicio.getElemento().equals(elemento)) {
            this.inicio = this.inicio.getProximo();

            if (this.inicio == null) {
                this.fim = null;
            }
            this.tamanho--;
            return true;

        } else {

            while (!obj.getProximo().getElemento().equals(elemento)) {
                obj = obj.getProximo();
            }

            if (obj.getProximo().getElemento().equals(this.fim.getElemento())) {
                obj.setProximo(null);
                this.fim = obj;
            } else {
                obj.setProximo(obj.getProximo().getProximo());
            }
            this.tamanho--;
            return true;
        }

    }

    @Override
    public int Tamanho() {
        return this.tamanho;
    }

    @Override
    public T Get(int indice) {

        Caixa<T> obj = this.inicio;
        int i = 0;

        while (i < indice) {
            obj = obj.getProximo();
            i++;
        }
        return obj.getElemento();
    }

    public T Get(Object elemento) {

        Caixa<T> obj = this.inicio;

        while (obj != null){
            if(obj.getElemento().equals(elemento)){
                return obj.getElemento();
            }
            obj = obj.getProximo();
        }
        return null;
    }

    @Override
    public boolean Contem(T elemento) {

        Caixa<T> obj = this.inicio;

        while (obj != null) {
            if (obj.getElemento().equals(elemento)) {
                return true;
            }
            obj = obj.getProximo();
        }

        return false;
    }

    @Override
    public void Limpar() {
        this.inicio = this.fim = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorLista(this);
    }

}
