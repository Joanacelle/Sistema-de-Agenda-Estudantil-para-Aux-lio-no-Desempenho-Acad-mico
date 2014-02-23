package Logic;

import Excecoes.AlunoException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle
 */
public class GerenciaAluno {

    private LinkedList<Aluno> listaAluno = new LinkedList<>();

    public GerenciaAluno(LinkedList<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }

    public void cadastraAluno(String mat, Aluno aluno) throws AlunoException {

        if (!confirma(mat)) {
            throw new AlunoException("Erro de cadastro: aluno duplicado");
        } else {
            listaAluno.add(aluno);
            throw new AlunoException("Aluno cadastrado com sucesso");
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