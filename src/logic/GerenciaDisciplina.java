/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import excecoes.DisciplinaException;
import infra.DAO;
import infra.DAOFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle
 */
public class GerenciaDisciplina {

    private DAOFactory daofactory;
    private DAO dao;

    public GerenciaDisciplina(int escolha) {

        daofactory = DAOFactory.getDAOFactory(escolha);
        dao = daofactory.getInstanciaDAO(2);
        
    }

    public void cadastraDis(Disciplina disciplina, String codigo) throws DisciplinaException {

        boolean cadastra = true;

        Disciplina dis = (Disciplina) dao.consultar(codigo);

        if (dis != null) {

            cadastra = false;

        }
        if (cadastra) {

            dao.cadastrar(disciplina);
            
        } else {

            throw new DisciplinaException("Já consta esse código em nossos registros!");
        }


    }
    
    public void consultaDis(String cod) throws DisciplinaException {

        Disciplina d = (Disciplina) dao.consultar(cod);

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
