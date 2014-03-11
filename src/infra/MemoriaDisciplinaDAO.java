/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import Logic.Disciplina;
import java.util.LinkedList;

/**
 *
 * @author Joanacelle
 */
public class MemoriaDisciplinaDAO implements DAO<Disciplina> {

    private static LinkedList<Disciplina> listaDisciplina;

    public MemoriaDisciplinaDAO() {

        listaDisciplina = new LinkedList<>();

    }

    public void cadastrar(Disciplina disciplina) {

        listaDisciplina.add(disciplina);

    }

    public Disciplina consultar(String cod) {

        for (Disciplina d : listaDisciplina) {

            if (cod.equals(d)) {

                return d;

            }
        }

        return null;

    }
}
