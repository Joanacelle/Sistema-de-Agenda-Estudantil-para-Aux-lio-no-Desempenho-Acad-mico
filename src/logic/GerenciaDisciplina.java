/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Excecoes.AlunoException;
import excecoes.DisciplinaException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle
 */
public class GerenciaDisciplina {

    
    private  LinkedList<Disciplina> listaDisciplina = new LinkedList<>();
    
    public GerenciaDisciplina(LinkedList<Disciplina> listaDisciplina) {
        this.listaDisciplina = listaDisciplina;
    }

    public void cadastraDis(Disciplina disciplina,String codigo) throws DisciplinaException{

        boolean cadastra = true;

        for (Disciplina d : listaDisciplina) {
            if (d.getCodigo().equals(codigo)) {
                cadastra = false;
            }
        }

        if (cadastra) {
            
            listaDisciplina.add(disciplina);
            //falar com o professor sobre essa parte
            throw new DisciplinaException("Disciplina cadastrada com sucesso!");
        } else {
            throw new DisciplinaException("Já consta esse código em nossos registros!");
        }



    }
    //REVER ESSA PARTE DO CÓDIGO MAIS TARDE!
    public void consultaDis(String cod) throws DisciplinaException {

        boolean achou = false;
        for (Disciplina d : listaDisciplina) {
            if (d.getCodigo().equals(cod)) {
                JOptionPane.showMessageDialog(null, "Disciplina: " + d.getNome() + "\n Nivel: " + d.getNivel()
                        + "\n Carga: " + d.getCargaHoraria() + "\n Metodo de Avaliação: " + d.getMetodoAvaliacao()
                        + "\n Numero de Faltas: " + d.getFalta() + "\n Bibliografia: " + d.getBibliiografia()
                        + "\n Ementa da Disciplina: " + d.getEmenta(), "Disciplina Encontrada", JOptionPane.INFORMATION_MESSAGE);
                achou = true;
            }
        }

        if (achou == false) {
            throw new DisciplinaException("Disciplina não encontrada!");
        }

    }
}
