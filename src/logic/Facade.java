package logic;

import Excecoes.AlunoException;
import Infra.PersistenciaAluno;
import Infra.PersistenciaDis;
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
    private static Facade f = null;
    private PersistenciaAluno gravaAluno = PersistenciaAluno.getInstance();
    private PersistenciaDis gravaDis = PersistenciaDis.getInstance();

    private Facade() {
    }

    public synchronized static Facade getInstance() {

        if (f == null) {
            f = new Facade();
        }

        return f;

    }

    public void cadastraAluno(String nome, String curso, String mat) throws ValidaException, AlunoException {

        if (v.validaLetras(nome) && v.validaLetras(curso) && v.validaNumeros(mat)) {

            aluno = new Aluno(nome, curso, mat);
            a.cadastraAluno(mat, aluno);

        } else {
            //falar com o professor sobre essa parte do código
            JOptionPane.showMessageDialog(null, "ERRO! Digite conforme indicado no campo!", "ERRO", JOptionPane.ERROR_MESSAGE);
            //throw new ValidaException("Digite conforme indicado no campo!");
        }
    }

    public void consultaAlunos(String mat) throws AlunoException {

        a.consultaAlunos(mat);
    }

    public void cadastraDis(String codigo, String nome, String nivel,
            int carga, String metodo, int falta, String bib, String ementa) throws DisciplinaException, ValidaException {

        if (v.validaNumeros(codigo) && v.validaLetras(nome) && v.validaNomeIgual(nivel, "F", "M", "D")
                && v.validaIntervalo(carga, 20, 60) && v.validaNomeIgual(metodo, "P", "T", "T")
                && v.validaIntervalo(falta, 1, 30) && v.validaTexto(bib) && v.validaTexto(ementa)) {

            disciplina = new Disciplina(codigo, nome, nivel, carga, metodo, falta, bib, ementa);
            d.cadastraDis(disciplina, codigo);

        } else {
            //falar com o professor sobre essa parte do código
            JOptionPane.showMessageDialog(null, "ERRO! Digite conforme indicado no campo!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void consultaDis(String cod) throws DisciplinaException {

        d.consultaDis(cod);
    }

    public void grava() {

        //gravaAluno.GravandoAluno();
        gravaDis.GravandoDis();
    
    }
}
