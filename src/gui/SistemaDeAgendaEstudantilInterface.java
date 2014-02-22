/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Excecoes.AlunoException;
import Logic.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import Infra.*;
import excecoes.DisciplinaException;
import excecoes.ValidaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Facade;

/**
 *
 * @author Joanacelle
 */
public class SistemaDeAgendaEstudantilInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ValidaException {

        Facade f = new Facade();

        boolean grava = true;

        while (grava) {

            int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Aluno"
                    + "\n2 - Cadastrar Disciplina"
                    + "\n3 - Consultar Aluno"
                    + "\n4 - Consultar Disciplina"
                    + "\n5 - Sair"));

            switch (op) {
                case 1:


                    while (true) {
                        try {
                            f.cadastraAluno(JOptionPane.showInputDialog("Digite seu nome"),
                                    JOptionPane.showInputDialog("Digite o nome do curso"),
                                    JOptionPane.showInputDialog("Digite sua matricula"));
                            break;
                        } catch (AlunoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "!!!", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    break;
                case 2:
                    try {
                        f.cadastraDis(JOptionPane.showInputDialog("Digite o codigo da disciplina[xxxx]:"),
                                JOptionPane.showInputDialog("Digite o nome da disciplina: "),
                                JOptionPane.showInputDialog("Digite o nível de dificuldade[F,M,D]:"),
                                Integer.parseInt(JOptionPane.showInputDialog("Digite a carga horaria[xx]: ")),
                                JOptionPane.showInputDialog("Digite o metodo de avaliação[P,T]:"),
                                Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de faltas[xx]:")),
                                JOptionPane.showInputDialog("Digite a bibliografia do curso:"),
                                JOptionPane.showInputDialog("Digite a ementa do curso:"));

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    } catch (DisciplinaException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3:
                    try {
                        f.consultaAlunos(JOptionPane.showInputDialog("Digite a matricula do aluno"));
                    } catch (AlunoException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }

                    break;

                case 4:
                    try {
                        f.consultaDis(JOptionPane.showInputDialog("Digite o codigo da disciplina:"));
                    } catch (DisciplinaException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 5:

                    grava = false;

                    break;

            }//fim do swhich

        }//fim do while    
    }
}
