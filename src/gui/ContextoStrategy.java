/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Joanacelle
 */
public class ContextoStrategy {

    private InterfaceStrategy contexto;
    
    public void definirStrategy(int escolhe) {
     
        if (escolhe == 1) {
            contexto = new Janela();

        } else {
            contexto = new Linha();

        }
    }

    public void seleciona(int escolhe) {

        contexto.constroInterface(escolhe);

    }
}
