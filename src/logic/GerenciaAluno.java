package Logic;

import Excecoes.AlunoException;
import infra.DAOFactory;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle
 */
public class GerenciaAluno {

    private DAOFactory daofactory;

    public GerenciaAluno(int escolha) {
        daofactory = DAOFactory.getDAOFactory(escolha);
    }

    public void cadastraAluno(String mat, Aluno aluno) throws AlunoException {

        if (!confirma(aluno)) {
            throw new AlunoException("Erro de cadastro: aluno duplicado");
        } else {
            daofactory.getAlunoDAO().cadastrar(aluno);
            throw new AlunoException("Aluno cadastrado com sucesso");
        }

    }

    public void consultaAlunos(String mat) throws AlunoException {

        Aluno aluno = daofactory.getAlunoDAO().consultar(mat);
        if (aluno != null) {
            JOptionPane.showMessageDialog(null, "Aluno: " + aluno.getNomeAluno() + "\n Curso: " + aluno.getNomeCurso()
                    + "\n Matricula: " + aluno.getMatricula(), "Aluno Encontrado", JOptionPane.INFORMATION_MESSAGE);

        } else {
            throw new AlunoException("Aluno não encontrado!");
        }

    }

    public boolean confirma(Aluno aluno) {

        Aluno a = daofactory.getAlunoDAO().consultar(aluno);
        
        if (a != null) {
            return false;
        }
        return true;
    }
}