/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 *
 * @author Joanacelle
 */
public class DisciplinaException extends Exception {

    public DisciplinaException() {
        super("Disciplina duplicada");
    }

    public DisciplinaException(String msg) {
        super(msg);
    }
}
