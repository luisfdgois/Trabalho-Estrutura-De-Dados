package meestruturadedados;

import java.util.Objects;

public class Logradouro {
      
    private String cep;
    private Cidade cidade;
    private UnidadeFederacao uf;
    private Bairro bairro;
    private String nomeLogradouro;

    public Logradouro() {
    }

    public Logradouro(String cep, Cidade cidade, UnidadeFederacao uf, Bairro bairro, String nomeLogradouro) {
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.bairro = bairro;
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public UnidadeFederacao getUf() {
        return uf;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.cep);
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.cep.equals(obj.toString());
    }

    @Override
    public String toString() {
        return " Cep: " + this.cep
                + "\n Cidade: " + this.cidade.getNome() + "/" + this.uf.getSigla()
                + "\n Bairro: " + this.bairro.getNome()
                + "\n Logradouro: " + this.nomeLogradouro;
    }
}
