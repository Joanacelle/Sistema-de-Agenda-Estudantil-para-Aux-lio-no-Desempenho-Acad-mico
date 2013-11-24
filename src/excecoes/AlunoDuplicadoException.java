/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Excecoes;
import java.lang.Exception;
import javax.swing.JOptionPane;
/**
 *
 * @author Joanacelle e Alexandre
 */
public class AlunoDuplicadoException extends Exception{
    
    public AlunoDuplicadoException() {
        super("Aluno duplicado");
    }
    
    public AlunoDuplicadoException(String msg) {
        super(msg);
    }
    

    
}
