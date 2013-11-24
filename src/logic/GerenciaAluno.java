

package Logic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane; 
        
/**
 *
 * @author Joanacelle e Alexandre
 */
public class GerenciaAluno {
    
    
     private Aluno aluno;
          
     
     public GerenciaAluno(Aluno aluno) {
     this.aluno = aluno;
     }
        
public void CadastraAluno(String nome,String curso,String mat){ 
         
         
         aluno = new Aluno(nome,curso,mat);
         JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso",
         "Informações do Aluno", JOptionPane.INFORMATION_MESSAGE);
             
         
}

     
public void ConsultaAluno(){
             
              JOptionPane.showMessageDialog(null, "Aluno(a): "+aluno.getNomeAluno()+"\n Curso: "+aluno.getNomeCurso(),
             "Aluno Encontrado", JOptionPane.INFORMATION_MESSAGE);  
              
      }
        

      
public boolean confirma(){
        if (!(aluno.getNomeAluno().equals(""))){return true;}
        else {return false;}
    }
          
      
}