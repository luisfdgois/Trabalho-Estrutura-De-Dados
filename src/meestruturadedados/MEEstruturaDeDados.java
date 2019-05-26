package meestruturadedados;

import implementhash.HashTable;
import java.util.List;

public class MEEstruturaDeDados {

    public static void main(String[] args) {
        
        //long start  = System.currentTimeMillis();
        
        //Lista armazena os dados do arquivo
        List<String> arquivo = Arquivo.Read();
        
        //long stop = System.currentTimeMillis() - start;
       // System.out.println(" Leitura do arquivo: " + stop/1000);
        
        
        //Coleções responsáveis por armazenar oa dados(do arquivo) de cada objeto
        HashTable<String, UnidadeFederacao> ufs = new HashTable();
        HashTable<String, Bairro> bairros = new HashTable();
        HashTable<String, Cidade> cidades = new HashTable();
        HashTable<String, Logradouro> logradouros = new HashTable();

        int i = 0;

        //Estrutura de repetição permitirá adicionar os dados do arquivo nas coleções correspondentes
        while (i < arquivo.size()) {

            String[] log = arquivo.get(i).split("\t");

            Cidade cidade = null;
            UnidadeFederacao uf = null;
            Bairro bairro = null;

            //Condição para evitar que desigualdidade dos dados do arquivo prejudique a execução do programa
            if (log.length == 2 || log.length > 3) {

                //Fazendo a divisão entre cidade e uf do valor lido
                String[] t = log[1].split("/");

                //Execussão da busca antes de inserir um novo objeto, impedindo que objetos de valores iguais sejam criados
                uf = ufs.Buscar(t[1]);
                if (uf == null) {
                    uf = new UnidadeFederacao(t[1]);
                    ufs.Inserir(t[1], uf);
                }

                cidade = cidades.Buscar(t[0]);
                if (cidade == null) {
                    cidade = new Cidade(t[0], uf);
                    cidades.Inserir(t[0], cidade);
                    if (t[0].equals("Aracaju")) {
                        uf.Adicionar(cidade);
                    } else {
                        uf.Adicionar(cidade);
                    }
                }

                if (log.length == 2) {
                    logradouros.Inserir(log[0], new Logradouro(log[0], cidade, uf, null, null));
                }
            }

            if (log.length > 3) {

                bairro = bairros.Buscar(log[2]);
                if (bairro == null) {
                    bairros.Inserir(log[2], new Bairro(log[2]));
                    bairro = bairros.Buscar(log[2]);
                    cidade.Adicionar(bairro);
                }

                String nomeLog = "";
                if (log.length == 5) {
                    nomeLog = log[3] + "\t" + log[4];
                } else {
                    nomeLog = log[3];
                }

                Logradouro logradouro = new Logradouro(log[0], cidade, uf, bairro, nomeLog);
                logradouros.Inserir(log[0], logradouro);
                bairro.Adicionar(logradouro);
            }
            i++;
        }

        /*
        Logradouro obj = logradouros.Buscar("35024440");

        if (obj != null) {

            if (obj.getBairro() == null && obj.getNomeLogradouro() == null) {
                JOptionPane.showMessageDialog(null, " Cep: " + obj.getCep()
                        + "\n Cidade: " + obj.getCidade().getNome()
                        + "\n UF: " + obj.getUf().getSigla());
            } else {
                JOptionPane.showMessageDialog(null, " Cep: " + obj.getCep()
                        + "\n Cidade: " + obj.getCidade().getNome()
                        + "\n UF: " + obj.getUf().getSigla()
                        + "\n Bairro: " + obj.getBairro().getNome()
                        + "\n Logradouro: " + obj.getNomeLogradouro());
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERRO!");
        }
        */
        //long stop = System.currentTimeMillis() - start;
       // System.out.println(" Tempo de busca pelo cep: " + stop/1000);
        
        
        
        long start = System.currentTimeMillis();
        
        UnidadeFederacao u = ufs.Buscar("SE");
        Cidade c = u.GetCidade("Aracaju");
        System.out.println(" Cidade: " + c.getNome());
        Bairro b = c.getBairros("Bugio");

        if (b != null) {

            int j = 0;
            while (j < b.getLogradouros().Tamanho()) {
                if (b.getLogradouros().getTable(j) != null) {
                    for (Logradouro l : b.getLogradouros().getTable(j)) {
                        System.out.println(l.getNomeLogradouro());
                    }
                }
                j++;

            }
        }

        long stop = System.currentTimeMillis() - start;
        System.out.println(" Tempo de busca dos logradouros de um bairro: " + stop/1000);

    }
    
}
