package Logic;

import java.text.DecimalFormat;

public class Aluno {

    private String nomeAl;
    private int cpf;
      
        
    public Aluno(String n, int c){
        this.nomeAl = n;
        this.cpf = c;
      }

    public String getNomeAl() {
        return nomeAl;
    }

    public int getCpf() {
        return cpf;
    }

    public void setNomeAl(String nomeAl) {
        this.nomeAl = nomeAl;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
        
    
}
