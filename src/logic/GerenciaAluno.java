package Logic;

import excecoes.AlunoException;
import infra.DAO;
import infra.DAOFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle
 */
public class GerenciaAluno {

    private DAOFactory daofactory;
    private DAO dao;

    public GerenciaAluno(int escolha) {

        daofactory = DAOFactory.getDAOFactory(escolha);
        dao = daofactory.getInstanciaDAO(1);
        
    }

    public void cadastraAluno(String mat, Aluno aluno)throws AlunoException {

        if (!confirma(aluno)) {

            throw new AlunoException("Erro de cadastro: aluno duplicado");

        } else {

            dao.cadastrar(aluno);
           
        }

    }

    public void consultaAlunos(String mat)throws AlunoException {

        Aluno aluno = (Aluno) dao.consultar(mat);
        
        if (aluno != null) {

            JOptionPane.showMessageDialog(null, "Aluno: " + aluno.getNomeAluno() + "\n Curso: " + aluno.getNomeCurso()
                    + "\n Matricula: " + aluno.getMatricula(), "Aluno Encontrado", JOptionPane.INFORMATION_MESSAGE);

        } else {

            throw new AlunoException("Aluno não encontrado!");
        }

    }

    public boolean confirma(Aluno aluno) {

        Aluno a = (Aluno) dao.consultar(aluno.getMatricula());

        if (a != null) {
            return false;
        }
        return true;
    }
}
