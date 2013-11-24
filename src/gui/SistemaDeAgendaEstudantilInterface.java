/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Excecoes.AlunoDuplicadoException;
import Logic.Aluno;
import Logic.Disciplina;
import Logic.GerenciaAluno;
import Logic.GerenciaDisciplina;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import Infra.*;
import Logic.GerenciaAluno1;

/**
 *
 * @author Joanacelle e Alexandre
 */
public class SistemaDeAgendaEstudantilInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Aluno aluno = new Aluno("", "", "");
        GerenciaAluno gerente = new GerenciaAluno(aluno);
        GerenciaAluno1 gerente1 = new GerenciaAluno1();

        LinkedList<Disciplina> listaDisciplina = new LinkedList<>();
        GerenciaDisciplina gerenteDis = new GerenciaDisciplina(listaDisciplina);
        boolean grava = true;
        PersistenciaDis gravandoDis = new PersistenciaDis();
        PersistenciaAluno gravandoAl = new PersistenciaAluno();

//deu certo aprendi
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
                            gerente1.cadastraAluno(JOptionPane.showInputDialog("Digite seu nome"),
                                    JOptionPane.showInputDialog("Digite o nome do curso"),
                                    JOptionPane.showInputDialog("Digite sua matricula"));
                            break;
                        } catch (AlunoDuplicadoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Resposta", JOptionPane.ERROR_MESSAGE);
                        }
                        

                    }
                    JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso",        
                            "Informações do Aluno", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    try {
                        gerenteDis.CadastraDis(JOptionPane.showInputDialog("Digite o codigo da disciplina[xxxx]:"),
                                JOptionPane.showInputDialog("Digite o nome da disciplina: "),
                                JOptionPane.showInputDialog("Digite o nível de dificuldade[F,M,D]:"),
                                Integer.parseInt(JOptionPane.showInputDialog("Digite a carga horaria[xx]: ")),
                                JOptionPane.showInputDialog("Digite o metodo de avaliação[P,T]:"),
                                Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de faltas[xx]:")),
                                JOptionPane.showInputDialog("Digite a bibliografia do curso:"),
                                JOptionPane.showInputDialog("Digite a ementa do curso:"));
                    } catch (NumberFormatException e) {
                        //ExceGui.ExibeExceptionNumb();
                    }
                    break;

                case 3:
                    if (gerente.confirma()) {
                        gerente.ConsultaAluno();
                    } else {
                        JOptionPane.showMessageDialog(null, "Ainda não Consta Cadastro!", "Resposta", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 4:
                    gerenteDis.ConsultaDis(JOptionPane.showInputDialog("Digite o codigo da disciplina:"));
                    break;

                case 5:
                    //try{             
                    grava = false;
                    gravandoAl.GravandoAluno();
                    gravandoDis.GravandoDis();
                    //}catch(NullPointerException n){}
                    break;

            }//fim do swhich

        }//fim do while    
    }
}
