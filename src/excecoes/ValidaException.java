/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 *
 * @author Joanacelle
 */
public class ValidaException extends Exception{
    
    
 public ValidaException() {
        super("Digite entre 5 e 300 caractéres");
    }

    public ValidaException(String msg) {
        super(msg);
    }   
}
