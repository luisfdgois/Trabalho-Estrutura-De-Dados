package implementhash;

public class Caixa<T> {

    private T elemento;
    private Caixa<T> proximo;

    public Caixa() {

    }

    public Caixa(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public T getElemento() {
        return elemento;
    }

    public Caixa<T> getProximo() {
        return proximo;
    }

    public void setProximo(Caixa<T> proximo) {
        this.proximo = proximo;
    }
    
    
}
