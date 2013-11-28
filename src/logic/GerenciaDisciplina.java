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

    private Disciplina disciplina;
    private  LinkedList<Disciplina> listaDisciplina = new LinkedList<>();
    
    public GerenciaDisciplina(LinkedList<Disciplina> listaDisciplina) {
        this.listaDisciplina = listaDisciplina;
    }

    public void cadastraDis(String codigo, String nome, String nivel,
            int carga, String metodo, int falta, String bib, String ementa) throws DisciplinaException{

        boolean cadastra = true;

        for (Disciplina d : listaDisciplina) {
            if (d.getCodigo().equals(codigo)) {
                cadastra = false;
            }
        }

        if (cadastra) {
            disciplina = new Disciplina(codigo, nome, nivel, carga, metodo, falta, bib, ementa);
            listaDisciplina.add(disciplina);
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
