package logic;

import excecoes.AlunoException;
import Logic.Aluno;
import Logic.Disciplina;
import Logic.GerenciaAluno;
import Logic.GerenciaDisciplina;
import excecoes.DisciplinaException;
import excecoes.ValidaException;
import gui.Validacao;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanacelle
 */
public class Facade {

    
    private Aluno aluno;
    private Disciplina disciplina;
    private static Facade f = null;
    private Validacao v;
    private GerenciaAluno a;
    private GerenciaDisciplina d;

    private Facade(int escolha) {

        v = new Validacao();
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

        if (v.validaLetras(nome) && v.validaLetras(curso) && v.validaNumeros(mat)) {

            aluno = new Aluno(nome, curso, mat);
            a.cadastraAluno(mat, aluno);

        } else {
            //falar com o professor sobre essa parte do código
            JOptionPane.showMessageDialog(null, "ERRO! Digite conforme indicado no campo!", "ERRO", JOptionPane.ERROR_MESSAGE);
            //throw new ValidaException("Digite conforme indicado no campo!");
        }
    }

    public void consultaAlunos(String mat)throws AlunoException {

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
}
