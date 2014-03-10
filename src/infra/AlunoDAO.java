/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import Logic.Aluno;

/**
 *
 * @author Joanacelle
 */
public interface AlunoDAO <G> {

    G get(String s);

    void cadastrar(G g);

    Aluno consultar(G g);

}
