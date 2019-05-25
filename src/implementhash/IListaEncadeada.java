package implementhash;

public interface IListaEncadeada<T> extends Iterable<T> {

    public void Adicionar(T elemento);

    public T Remover(int indice);

    public boolean Remover(Object elemento);

    public int Tamanho();

    public T Get(int indice);
    
    public T Get(Object elemento);

    public boolean Contem(T elemento);

    public void Limpar();
}
