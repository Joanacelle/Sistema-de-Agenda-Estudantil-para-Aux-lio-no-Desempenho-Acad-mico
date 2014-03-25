package gui;

import excecoes.AlunoException;
import excecoes.DisciplinaException;
import excecoes.ValidaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.Facade;

/**
 *
 * @author Joanacelle
 */
public class Janela implements InterfaceStrategy {

    private Facade f;

    public void constroInterface(int escolha) {

        f = Facade.getInstance(escolha);

        ValidacaoChain validacao;
        ValidaIntervalo vintervalo;
        ValidaLetras vletras;
        ValidaNomeIgual vnome;
        ValidaNumeros vnumero;
        ValidaTexto vtexto;

        String nome, curso, matricula;
        String cod, nomdis, nivel, metodo, bib, ementa;
        int carga, nfalta;

        boolean cadastra = true;

        while (cadastra) {

            int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Aluno"
                    + "\n2 - Cadastrar Disciplina"
                    + "\n3 - Consultar Aluno"
                    + "\n4 - Consultar Disciplina"
                    + "\n5 - Sair"));

            switch (op) {
                case 1:
                    try {

                        nome = JOptionPane.showInputDialog("Digite seu nome \n [minimo de 5 maximo de 300 letras]");
                        curso = JOptionPane.showInputDialog("Digite o nome do curso \n [minimo de 5 maximo de 300 letras]");
                        matricula = JOptionPane.showInputDialog("Digite sua matricula \n [Deve conter 8 numeros]");

                        validacao = new ValidaLetras(nome);

                        ValidacaoChain.v = validacao;
                        vletras = new ValidaLetras(curso);
                        validacao.setNext(vletras);
                        vnumero = new ValidaNumeros(matricula);
                        validacao.setNext(vnumero);
                        validacao.buscaValidacao(validacao);

                        f.cadastraAluno(nome, curso, matricula);

                        JOptionPane.showMessageDialog(null, "Aluno Cadastrado com sucesso", "OK", JOptionPane.INFORMATION_MESSAGE);
                        
                        validacao = null;
                    } catch (AlunoException e) {
                        Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, e);
                    } catch (ValidaException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "!!!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 2:
                    try {
                        cod = JOptionPane.showInputDialog("Digite o codigo da disciplina \n [Deve conter 8 numeros]:");
                        nomdis = JOptionPane.showInputDialog("Digite o nome da disciplina: \n [minimo de 5 maximo de 300 letras] ");
                        nivel = JOptionPane.showInputDialog("Digite o nível de dificuldade[F,M,D]:");
                        carga = Integer.parseInt(JOptionPane.showInputDialog("Digite a carga horaria: \n [minimo de 20 maximo de 60 horas] "));
                        metodo = JOptionPane.showInputDialog("Digite o metodo de avaliação[P,T]:");
                        nfalta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de faltas: \n [minimo de 1 maximo de 30 faltas]"));
                        bib = JOptionPane.showInputDialog("Digite a bibliografia do curso:");
                        ementa = JOptionPane.showInputDialog("Digite a ementa do curso:");

                        validacao = new ValidaNumeros(cod);

                        ValidacaoChain.v = validacao;
                        vletras = new ValidaLetras(nomdis);
                        validacao.setNext(vletras);
                        vnome = new ValidaNomeIgual(nivel, "F", "M", "D");
                        validacao.setNext(vnome);
                        vintervalo = new ValidaIntervalo(carga, 20, 60);
                        validacao.setNext(vintervalo);
                        vnome = new ValidaNomeIgual(metodo, "P", "T", "T");
                        validacao.setNext(vnome);
                        vintervalo = new ValidaIntervalo(nfalta, 1, 30);
                        validacao.setNext(vintervalo);
                        vtexto = new ValidaTexto(bib);
                        validacao.setNext(vtexto);
                        vtexto = new ValidaTexto(ementa);
                        validacao.setNext(vtexto);
                        validacao.buscaValidacao(validacao);

                        f.cadastraDis(cod, nomdis, nivel, carga, metodo, nfalta, bib, ementa);

                        JOptionPane.showMessageDialog(null, "Disciplina Cadastrada com sucesso", "OK", JOptionPane.INFORMATION_MESSAGE);
                        
                        validacao = null;
                    } catch (DisciplinaException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    } catch (ValidaException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3:
                    try {
                        f.consultaAlunos(JOptionPane.showInputDialog("Digite a matricula do aluno"));
                    } catch (AlunoException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }

                    break;

                case 4:
                    try {
                        f.consultaDis(JOptionPane.showInputDialog("Digite o codigo da disciplina:"));
                    } catch (DisciplinaException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 5:

                    cadastra = false;

                    break;

            }//fim do swhich

        }//fim do while


    }
}
