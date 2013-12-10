package Logic;

import Excecoes.AlunoException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle e Alexandre
 */
public class GerenciaAluno {

    private Aluno aluno;
    private LinkedList<Aluno> listaAluno = new LinkedList<>();

    public GerenciaAluno(LinkedList<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }

    public void cadastraAluno(String nome, String curso, String mat) throws AlunoException {


        aluno = new Aluno(nome, curso, mat);

        if (!confirma(mat)) {
            throw new AlunoException("Erro de cadastro: aluno duplicado");
        } else {
            listaAluno.add(aluno);
        }

    }

    public void consultaAlunos(String mat) throws AlunoException {

        /*String linhasAlunos = "";
         for (Aluno aluno : listaAluno) {
         //if (aluno.getMatricula().equals(mat)) {
         linhasAlunos = linhasAlunos + aluno.getMatricula() + "matricula " + aluno.getNomeAluno() + "nome " + aluno.getNomeCurso() + "curso\n";
         //}
         }
         return linhasAlunos;
         REVER ESSA PARTE DO CODIGO MAIS TARDE, NÃO ESTÁ IMPRIMINDO CORRETAMENTE*/
        boolean achou = false;
        for (Aluno a : listaAluno) {
            if (a.getMatricula().equals(mat)) {
                JOptionPane.showMessageDialog(null, "Aluno: " + a.getNomeAluno() + "\n Curso: " + a.getNomeCurso()
                        + "\n Matricula: " + a.getMatricula(), "Aluno Encontrado", JOptionPane.INFORMATION_MESSAGE);
                achou = true;
            }
        }

        if (achou == false) {
            throw new AlunoException("Aluno não encontrado!");
        }
    }

    public boolean confirma(String matricula) {
        for (Aluno a : listaAluno) {
            if (a.getMatricula().equals(matricula)) {
                return false;
            }
        }

        return true;
    }
}