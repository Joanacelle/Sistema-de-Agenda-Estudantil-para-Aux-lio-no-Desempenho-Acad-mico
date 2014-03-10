/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import Logic.Disciplina;

/**
 *
 * @author Joanacelle
 */
public interface DisciplinaDAO <G> {
    
    G get(String s);

    void cadastrar(G g);

    Disciplina consultar(G g);
        
}
