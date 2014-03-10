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
public class MemoriaAlunoDAO implements AlunoDAO {

    private static LinkedList<Aluno> listaAluno;

    public MemoriaAlunoDAO() {

        
    }

    public void cadastrar(Aluno aluno) {

        listaAluno.add(aluno);
    }

    public Aluno consultar(Aluno aluno) {

        for (Aluno a : listaAluno) {

            if (aluno.getMatricula().equals(a.getMatricula())) {
            
                return a;
                
            }
        }

        return null;
    }

    @Override
    public Object get(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cadastrar(Object g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Aluno consultar(Object g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

    
}
