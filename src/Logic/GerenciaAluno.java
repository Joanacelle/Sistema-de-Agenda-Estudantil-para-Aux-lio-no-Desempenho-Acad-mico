/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle
 */
public class GerenciaAluno {
    
    
     private Aluno aluno;
     LinkedList<Aluno> listaAluno = new LinkedList<>();
     
     
     public GerenciaAluno(LinkedList<Aluno> listaAluno) {
     this.listaAluno = listaAluno;
      
     }
        
      public boolean Cadastra(){ 
            
          Aluno aluno = new Aluno(JOptionPane.showInputDialog("Digite o nome do aluno:"),
                        Integer.parseInt(JOptionPane.showInputDialog("Digite o cpf do aluno:")));
          
                
          if (aluno != null) {
                    listaAluno.add(aluno);
                    return true;
                }
        
       else
            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos ", "Error", JOptionPane.ERROR_MESSAGE);
 return false;
  
}
      
      public boolean Consulta(){
      
      DecimalFormat d = new DecimalFormat("0.00");
      boolean achou = false;
      for (Aluno a : listaAluno) {
                     if (a.getCpf() == JOptionPane.showInputDialog(Integer.parseInt(JOptionPane.showInputDialog("Digite o cpf do aluno:")))) {
                        
       }
        catch(NumberFormatException n){
                  JOptionPane.showMessageDialog(null, "Por favor, Digite apenas valores válidos!", "Error", JOptionPane.ERROR_MESSAGE);
       }
        if(achou==false){
            JOptionPane.showMessageDialog(null, "Aluno não cadastrado!", "Resposta", JOptionPane.ERROR_MESSAGE);
               jTextField1.setText("");
        }
        
      
      
      
      }
}