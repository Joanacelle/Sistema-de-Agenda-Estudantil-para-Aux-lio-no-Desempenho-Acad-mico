/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Excecoes.AlunoException;
import excecoes.DisciplinaException;
import excecoes.ValidaException;
import javax.swing.JOptionPane;
import logic.Facade;

/**
 *
 * @author Joanacelle
 */
public class SistemaDeAgendaEstudantilInterface {

    public static void main(String[] args) throws ValidaException {


        int escolha = Integer.parseInt(JOptionPane.showInputDialog("1 - Gravar em arquivo"
                + "\n2 - Gravar em memoria"));
        Facade f = Facade.getInstance(escolha);
        boolean grava = true;

        while (grava) {

            int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Aluno"
                    + "\n2 - Cadastrar Disciplina"
                    + "\n3 - Consultar Aluno"
                    + "\n4 - Consultar Disciplina"
                    + "\n5 - Sair"));

            switch (op) {
                case 1:

                    try {
                        f.cadastraAluno(JOptionPane.showInputDialog("Digite seu nome \n [minimo de 5 maximo de 300 letras]"),
                                JOptionPane.showInputDialog("Digite o nome do curso \n [minimo de 5 maximo de 300 letras]"),
                                JOptionPane.showInputDialog("Digite sua matricula \n [Deve conter 8 numeros]"));
                        break;
                    } catch (AlunoException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "!!!", JOptionPane.ERROR_MESSAGE);
                    }


                    break;
                case 2:
                    try {
                        f.cadastraDis(JOptionPane.showInputDialog("Digite o codigo da disciplina \n [Deve conter 8 numeros]:"),
                                JOptionPane.showInputDialog("Digite o nome da disciplina: \n [minimo de 5 maximo de 300 letras] "),
                                JOptionPane.showInputDialog("Digite o nível de dificuldade[F,M,D]:"),
                                Integer.parseInt(JOptionPane.showInputDialog("Digite a carga horaria: \n [minimo de 20 maximo de 60 horas] ")),
                                JOptionPane.showInputDialog("Digite o metodo de avaliação[P,T]:"),
                                Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de faltas: \n [minimo de 1 maximo de 30 faltas]")),
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

                    //f.grava();

                    grava = false;

                    break;

            }//fim do swhich

        }//fim do while    
    }
}
