/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

/**
 *
 * @author Joanacelle
 */
public abstract class DAOFactory {

    public static final int arquivo = 1;
    public static final int memoria = 2;

    public abstract AlunoDAO getAlunoDAO();

    public abstract DisciplinaDAO getDisciplinaDAO();

    public static DAOFactory getDAOFactory(int escolha) {

        switch (escolha) {
            
            case arquivo:
            return new GravarArquivo();
                
            case memoria:
            return new GravarMemoria();

            default:
                return null;
        }
    }
}
