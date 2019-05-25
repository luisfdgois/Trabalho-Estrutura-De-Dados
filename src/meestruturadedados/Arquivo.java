package meestruturadedados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arquivo {
    
     public static List<String> Read() {

        List<String> arquivo = new ArrayList();

        try {

            FileReader file = new FileReader("ceps.txt");
            BufferedReader buffered = new BufferedReader(file);

            String linha = buffered.readLine();

            while (linha != null) {
                arquivo.add(linha);
                linha = buffered.readLine();
            }
            file.close();
            return arquivo;

        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arquivo;
    }
}
