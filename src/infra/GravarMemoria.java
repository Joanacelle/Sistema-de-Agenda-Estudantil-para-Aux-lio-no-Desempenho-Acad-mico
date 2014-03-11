/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

/**
 *
 * @author Joanacelle
 */
public class GravarMemoria extends DAOFactory {

   
    public DAO getInstanciaDAO(int escolha) {

        if (escolha == 1) {

            return new MemoriaAlunoDAO();
            
        } else {

            return new MemoriaDisciplinaDAO();
        }
    }
}
