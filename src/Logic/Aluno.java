package Logic;

import java.text.DecimalFormat;

public class Aluno {

    private String nomeAluno;
    private String nomeCurso;
    private String matricula;

    
        
    public Aluno(String nome, String curso, String mat){
        this.nomeAluno = nome;
        this.nomeCurso = curso;
        this.matricula = mat;
        }
   
   public String getNomeAluno() {
        return nomeAluno;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
         
}
