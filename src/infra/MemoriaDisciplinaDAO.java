/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import Logic.Disciplina;
import java.util.LinkedList;

/**
 *
 * @author Joanacelle
 */
public class MemoriaDisciplinaDAO implements DisciplinaDAO <Disciplina> {
    
    private static LinkedList<Disciplina> listaDisciplina;

    public MemoriaDisciplinaDAO() {

        listaDisciplina = new LinkedList<>();

    }

   
    public Disciplina get(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public void cadastrar(Disciplina disciplina) {
      
    listaDisciplina.add(disciplina);
    }

   
    public Disciplina consultar(Disciplina disciplina) {
    
    for (Disciplina d : listaDisciplina) {

            if (disciplina.getCodigo().equals(d)) {
            
                return d;
                
            }
        }

        return null;
        
    }

   
}
