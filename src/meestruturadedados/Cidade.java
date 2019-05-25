package meestruturadedados;

import implementhash.HashTable;
import java.util.Objects;

public class Cidade {

    private String nome;
    private UnidadeFederacao uf;
    private HashTable<String, Bairro> bairros;

    public Cidade() {
        this.bairros = new HashTable();
    }

    public Cidade(String nome, UnidadeFederacao uf) {
        this();
        this.nome = nome;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public UnidadeFederacao getUf() {
        return uf;
    }

    public Bairro getBairros(String nome) {
        return this.bairros.Buscar(nome);
    }

    public void Adicionar(Bairro bairro) {
        this.bairros.Inserir(bairro.getNome(), bairro);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.nome.equals(obj.toString());
    }
}
