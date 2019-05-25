package meestruturadedados;

import implementhash.HashTable;
import java.util.Objects;

public class Bairro {

    private String nome;
    private HashTable<String, Logradouro> logradouros;

    public Bairro() {
        this.logradouros = new HashTable();
    }

    public Bairro(String nome) {
        this();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public HashTable<String, Logradouro> getLogradouros() {
        return logradouros;
    }

    public void Adicionar(Logradouro logradouro) {
        this.logradouros.Inserir(logradouro.getCep(), logradouro);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.nome.equals(obj.toString());
    }
}
