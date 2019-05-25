package meestruturadedados;

import implementhash.HashTable;
import java.util.Objects;

public class UnidadeFederacao {
    
    private String sigla;
    private HashTable<String, Cidade> cidades;
    
    public UnidadeFederacao(){
        this.cidades = new HashTable();
    }
    
    public UnidadeFederacao(String sigla){
        this();
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }
    
    public void Adicionar(Cidade cidade){
        this.cidades.Inserir(cidade.getNome(), cidade);
    }
    
    public Cidade GetCidade(String nome){
        return this.cidades.Buscar(nome);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.sigla);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }

        return this.sigla.equals(obj.toString());
    }
}
