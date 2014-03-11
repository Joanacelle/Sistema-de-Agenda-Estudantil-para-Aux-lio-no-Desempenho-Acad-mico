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
    
    public abstract DAO getInstanciaDAO(int escolha);

    public static DAOFactory getDAOFactory(int escolha) {

        switch (escolha) {

            case memoria:
                return new GravarMemoria();//deve haver uma escolha aqui se aluno ou disciplina

            case arquivo:
                return new GravarArquivo();//deve haver uma escolha aqui se aluno ou disciplina

            default:
                return null;
        }
    }
}
