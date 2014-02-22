package logic;

import Excecoes.AlunoException;
import Logic.Aluno;
import Logic.Disciplina;
import Logic.GerenciaAluno;
import Logic.GerenciaDisciplina;
import excecoes.DisciplinaException;
import excecoes.ValidaException;
import gui.Validacao;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle
 */
public class Facade {

    private LinkedList<Logic.Aluno> listaAluno = new LinkedList<>();
    private GerenciaAluno a = new GerenciaAluno(listaAluno);
    private LinkedList<Logic.Disciplina> listaDisciplina = new LinkedList<>();
    private GerenciaDisciplina d = new GerenciaDisciplina(listaDisciplina);
    private Aluno aluno;
    private Disciplina disciplina;
    private Validacao v = new Validacao();

    public void cadastraAluno(String nome, String curso, String mat) throws ValidaException, AlunoException {

        if (v.validaLetras(nome)&& v.validaLetras(curso) && v.validaNumeros(mat)) {
            
            aluno = new Aluno(nome, curso, mat);
            a.cadastraAluno(mat, aluno);
            
        } else {
            //falar com o professor sobre essa parte do código
            JOptionPane.showMessageDialog(null,"ERRO! Tente novamente mais tarde!","ERRO", JOptionPane.ERROR_MESSAGE);
                        
        }
    }

    public void consultaAlunos(String mat) throws AlunoException {

        a.consultaAlunos(mat);
    }

    public void cadastraDis(String codigo, String nome, String nivel,
            int carga, String metodo, int falta, String bib, String ementa) throws DisciplinaException {

        disciplina = new Disciplina(codigo, nome, nivel, carga, metodo, falta, bib, ementa);
        d.cadastraDis(disciplina, codigo);
    }

    public void consultaDis(String cod) throws DisciplinaException {

        d.consultaDis(cod);
    }
}
