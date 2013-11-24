/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle
 */
public class GerenciaDisciplina {
    
     private Disciplina disciplina;
     LinkedList<Disciplina> listaDisciplina = new LinkedList<>();
     
     
     public GerenciaDisciplina(LinkedList<Disciplina> listaDisciplina) {
     this.listaDisciplina = listaDisciplina;
     }
    
    
     public void CadastraDis(String codigo,String nome,String nivel,
     int carga,String metodo,int falta,String bib,String ementa){ 
            
         boolean cadastra = true; 
         
         for (Disciplina a : listaDisciplina) {
              if (a.getCodigo().equals(codigo)){
               cadastra = false;}
         }
         
         if(cadastra){
         disciplina = new Disciplina(codigo,nome,nivel,carga,metodo,falta,bib,ementa);
         listaDisciplina.add(disciplina);
         JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!",
         "Informações da Disciplina", JOptionPane.INFORMATION_MESSAGE);
         }else
         JOptionPane.showMessageDialog(null, "Já consta esse codigo em nossos registros", "Resposta", JOptionPane.ERROR_MESSAGE);
         
         
   
}

     
public void ConsultaDis(String cod){
      
      boolean achou = false;
      for (Disciplina a : listaDisciplina) {
              if (a.getCodigo().equals(cod)){
              JOptionPane.showMessageDialog(null, "Disciplina: "+disciplina.getNome()+"\n Nivel: "+disciplina.getNivel()+
              "\n Carga: "+disciplina.getCargaHoraria()+"\n Metodo de Avaliação: "+disciplina.getMetodoAvaliacao()+
               "\n Numero de Faltas: "+disciplina.getFalta()+"\n Bibliografia: "+disciplina.getBibliiografia()+
               "\n Ementa da Disciplina: "+ disciplina.getEmenta(),"Disciplina Encontrada", JOptionPane.INFORMATION_MESSAGE);  
              achou = true;}
      }    
        
      if(achou==false){
            JOptionPane.showMessageDialog(null, "Disciplina não cadastrada!", "Resposta", JOptionPane.ERROR_MESSAGE);
      }
        
} 
     
     
     
     
     
     
     
     
     
     
    
    
}
