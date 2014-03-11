/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Excecoes.AlunoException;
import excecoes.DisciplinaException;
import infra.DAOFactory;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle
 */
public class GerenciaDisciplina {

    private DAOFactory daofactory;

    public GerenciaDisciplina(int escolha) {

        daofactory = DAOFactory.getDAOFactory(escolha);
    }

    public void cadastraDis(Disciplina disciplina, String codigo) throws DisciplinaException {

        boolean cadastra = true;

        Disciplina dis = (Disciplina) daofactory.getInstanciaDAO(2).consultar(codigo);

        if (dis != null) {

            cadastra = false;

        }
        if (cadastra) {

            daofactory.getInstanciaDAO(2).cadastrar(disciplina);

            throw new DisciplinaException("Disciplina cadastrada com sucesso!");

        } else {

            throw new DisciplinaException("Já consta esse código em nossos registros!");
        }


    }
    //REVER ESSA PARTE DO CÓDIGO MAIS TARDE!

    public void consultaDis(String cod) throws DisciplinaException {

        Disciplina d = (Disciplina) daofactory.getInstanciaDAO(2).consultar(cod);

        if (d != null) {

            JOptionPane.showMessageDialog(null, "Disciplina: " + d.getNome() + "\n Nivel: " + d.getNivel()
                    + "\n Carga: " + d.getCargaHoraria() + "\n Metodo de Avaliação: " + d.getMetodoAvaliacao()
                    + "\n Numero de Faltas: " + d.getFalta() + "\n Bibliografia: " + d.getBibliiografia()
                    + "\n Ementa da Disciplina: " + d.getEmenta(), "Disciplina Encontrada", JOptionPane.INFORMATION_MESSAGE);
        } else {

            throw new DisciplinaException("Disciplina não encontrada!");
        }

    }
}
