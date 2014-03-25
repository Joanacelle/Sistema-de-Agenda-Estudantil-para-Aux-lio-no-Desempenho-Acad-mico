package logic;

import Logic.Aluno;
import Logic.Disciplina;
import Logic.GerenciaAluno;
import Logic.GerenciaDisciplina;
import excecoes.AlunoException;
import excecoes.DisciplinaException;
import excecoes.ValidaException;

/**
 *
 * @author Joanacelle
 */
public class Facade {

    private Aluno aluno;
    private Disciplina disciplina;
    private static Facade f = null;
    private GerenciaAluno a;
    private GerenciaDisciplina d;

    private Facade(int escolha) {

        d = new GerenciaDisciplina(escolha);
        a = new GerenciaAluno(escolha);

    }

    public synchronized static Facade getInstance(int escolha) {

        if (f == null) {
            f = new Facade(escolha);
        }

        return f;

    }

    public void cadastraAluno(String nome, String curso, String mat) throws ValidaException, AlunoException {

        aluno = new Aluno(nome, curso, mat);
        a.cadastraAluno(mat, aluno);

    }

    public void consultaAlunos(String mat) throws AlunoException {

        a.consultaAlunos(mat);
    }

    public void cadastraDis(String codigo, String nome, String nivel,
            int carga, String metodo, int falta, String bib, String ementa) throws DisciplinaException, ValidaException {

        disciplina = new Disciplina(codigo, nome, nivel, carga, metodo, falta, bib, ementa);
        d.cadastraDis(disciplina, codigo);

    }

    public void consultaDis(String cod) throws DisciplinaException {
        d.consultaDis(cod);
    }
}
