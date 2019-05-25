package implementhash;

public class HashTable<K, T> {

    private ListaEncadeada<T>[] table;
    private int carga;

    public HashTable() {
        this.table = new ListaEncadeada[2003];
        this.carga = 0;
    }

    public ListaEncadeada<T> getTable(int indice) {
        return this.table[indice];
    }
    
    public int Tamanho(){
        return this.table.length;
    }

    public void Inserir(K key, T elemento) {

    //  if (this.CargaTotal()) {
    //      this.Redimensionar();
    //  }

        int indice = this.Hash(key);

        if (this.table[indice] == null) {
            this.table[indice] = new ListaEncadeada();
            this.carga++;
        }
        this.table[indice].Adicionar(elemento);
    }

    public T Buscar(K key) {

        int indice = this.Hash(key);
        if (this.table[indice] != null) {
            return this.table[indice].Get(key);
        }
        return null;
    }
 
    public boolean Remover(K key) {

        int indice = this.Hash(key);

        return this.table[indice].Remover(key);
    }

    private boolean CargaTotal() {

        float total = (this.table.length * 75) / 100;

        if (this.carga >= total) {
            return true;
        }
        return false;
    }

    private int Hash(K key) {

        int hash = 0;
        for (int i = 0; i < key.toString().length(); i++) {
            hash = (31 * hash + key.toString().charAt(i)) % this.table.length;
        }
        return hash;
    }
/*
    private void Redimensionar() {

        ListaEncadeada<T>[] novaTable = new ListaEncadeada[this.table.length * 2];
        for (int i = 0; i < table.length; i++) {
            novaTable[i] = this.table[i];
        }
        this.table = novaTable;
    }
*/
}
