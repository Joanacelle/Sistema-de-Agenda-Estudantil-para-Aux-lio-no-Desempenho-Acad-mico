/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Logic.Aluno;
import Logic.Disciplina;
import Logic.GerenciaAluno;
import Logic.GerenciaDisciplina;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import Excecoes.ExceGui;
import Infra.Persistencia;
/**
 *
 * @author Joanacelle
 */
public class SistemaDeAgendaEstudantilParaAuxílioNoDesempenhoAcadêmico {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
               
        Aluno aluno = new Aluno("","","");
        GerenciaAluno gerente = new GerenciaAluno(aluno);
        LinkedList<Disciplina> listaDisciplina = new LinkedList<>();
        GerenciaDisciplina gerenteDis = new GerenciaDisciplina(listaDisciplina);
        boolean grava = true;
        
        Persistencia gravando = new Persistencia();
        
        while(grava){
            
        int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Aluno" + "\n2 - Cadastrar Disciplina" + 
                "\n3 - Consultar Aluno" + "\n4 - Consultar Disciplina" + "\n5 - Sair"));
        
        switch(op){
            case 1:
                if(!gerente.confirma()){
                gerente.CadastraAluno(JOptionPane.showInputDialog("Digite seu nome"),
                JOptionPane.showInputDialog("Digite o nome do curso"),
                JOptionPane.showInputDialog("Digite sua matricula"));
                }else
                    JOptionPane.showMessageDialog(null, "Já exixte um aluno cadastrado", "Resposta", JOptionPane.ERROR_MESSAGE);
                break;
            case 2:
                try{
                   gerenteDis.CadastraDis(JOptionPane.showInputDialog("Digite o codigo da disciplina[xxxx]:"),
                   JOptionPane.showInputDialog("Digite o nome da disciplina: "),
                   JOptionPane.showInputDialog("Digite o nível de dificuldade[F,M,D]:"),
                   Integer.parseInt(JOptionPane.showInputDialog("Digite a carga horaria[xx]: ")),
                   JOptionPane.showInputDialog("Digite o metodo de avaliação[P,T]:"),
                   Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de faltas[xx]:")),
                   JOptionPane.showInputDialog("Digite a bibliografia do curso:"),
                   JOptionPane.showInputDialog("Digite a ementa do curso:"),aluno);
                }catch(NumberFormatException e){
                   ExceGui.ExibeExceptionNumb();
                }
                break;
       
            case 3:
               if(gerente.confirma()){ 
                  gerente.ConsultaAluno();
               }else
                  JOptionPane.showMessageDialog(null, "Ainda não Consta Cadastro!", "Resposta", JOptionPane.ERROR_MESSAGE);
               break;
           
            case 4:
                  gerenteDis.ConsultaDis(JOptionPane.showInputDialog("Digite o codigo da disciplina:")); 
               break;
                
            case 5:
                grava = false;
                gravando.Gravando();
                break;
        
         }//fim do swhich

   }//fim do while    
    

    
    
    
}}
