/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 *
 * @author Joanacelle
 */
public class AlunoException extends Exception{
    
    public AlunoException() {
        super("Aluno duplicado");
    }
    
    public AlunoException(String msg) {
        super(msg);
    }
    
}
