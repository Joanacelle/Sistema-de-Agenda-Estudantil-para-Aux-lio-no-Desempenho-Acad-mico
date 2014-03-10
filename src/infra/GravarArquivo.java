/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import Logic.Aluno;
import Logic.Disciplina;
import java.util.LinkedList;

/**
 *
 * @author Joanacelle
 */
public class GravarArquivo extends DAOFactory {

    
    public AlunoDAO getAlunoDAO() {

        return ArquivoAlunoDAO.getInstance();
    }

    public DisciplinaDAO getDisciplinaDAO() {

        return ArquivoDisciplinaDAO.getInstance();
    }
}
