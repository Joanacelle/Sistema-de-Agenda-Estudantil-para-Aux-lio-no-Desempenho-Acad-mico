/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import Logic.Aluno;
import java.util.LinkedList;

/**
 *
 * @author Joanacelle
 */
public class MemoriaAlunoDAO implements DAO<Aluno> {

    private static LinkedList<Aluno> listaAluno;

    public MemoriaAlunoDAO() {

        listaAluno = new LinkedList<>();
    }

    public void cadastrar(Aluno aluno) {

        listaAluno.add(aluno);
    }

    public Aluno consultar(String mat) {

        Iteration<Aluno> percorre = new Iteration<Aluno>(listaAluno);
        
        Aluno aluno;
        
        while (percorre.hasNext() == true) {
            
            aluno = percorre.next();
            
            if (mat.equals(aluno.getMatricula())) {

                return aluno;

            }
        }

        return null;
    }
}
