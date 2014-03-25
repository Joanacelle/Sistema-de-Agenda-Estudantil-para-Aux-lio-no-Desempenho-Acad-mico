/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import excecoes.ValidaException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle
 */
public class SistemaDeAgendaEstudantilInterface {

    public static void main(String[] args) throws ValidaException {

        ContextoStrategy contexto = new ContextoStrategy();

        int escolha = Integer.parseInt(JOptionPane.showInputDialog("1 - Gravar em arquivo"
                + "\n2 - Gravar em memoria"));

        int escolha2 = Integer.parseInt(JOptionPane.showInputDialog("1 - Interface Janela"
                + "\n2 - Interface Linha"));

        contexto.definirStrategy(escolha2);
        contexto.seleciona(escolha);
    }
}
