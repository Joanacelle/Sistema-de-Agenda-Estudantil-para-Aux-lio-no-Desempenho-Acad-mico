package Logic;

import Excecoes.AlunoDuplicadoException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle e Alexandre
 */
public class GerenciaAluno1 {

    private LinkedList<Aluno> alunos;

    public GerenciaAluno1() {
        this.alunos = new LinkedList<Aluno>();
    }

    public void cadastraAluno(String nome, String curso, String mat) throws AlunoDuplicadoException {


        Aluno temp = new Aluno(nome, curso, mat);
        if (!confirma(mat)) {
            throw new AlunoDuplicadoException("Erro de cadastro: aluno duplicado");
        } else {     
            alunos.add(temp);
        }
        
        


    }

    public String retornaAlunos() {   
        
        String linhasAlunos= "";
        for (Aluno aluno: alunos){
            linhasAlunos = linhasAlunos +  aluno.getMatricula() + " " + aluno.getNomeAluno() + " " + aluno.getNomeCurso() + "\n";
        }
        return linhasAlunos;
    }

    public boolean confirma(String matricula) {
         for (Aluno aluno: alunos){
             if (aluno.getMatricula().equals(matricula) ){
                return false;
             }
         }
         
         return true;
    }
}