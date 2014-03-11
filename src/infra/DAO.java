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
public interface DAO<G> {

    void cadastrar(G g);

    G consultar(String string);
}
