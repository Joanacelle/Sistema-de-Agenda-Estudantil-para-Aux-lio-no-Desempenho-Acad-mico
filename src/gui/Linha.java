/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import excecoes.AlunoException;
import excecoes.DisciplinaException;
import excecoes.ValidaException;
import java.util.Scanner;
import logic.Facade;

/**
 *
 * @author Joanacelle
 */
public class Linha implements InterfaceStrategy {

    private Facade f;

    public void constroInterface(int escolha) {

        f = Facade.getInstance(escolha);

        ValidacaoChain validacao;
        ValidaIntervalo vintervalo;
        ValidaLetras vletras;
        ValidaNomeIgual vnome;
        ValidaNumeros vnumero;
        ValidaTexto vtexto;

        boolean cadastra = true;
        String nome, curso, matricula;
        String cod, nomdis, nivel, metodo, bib, ementa;
        int carga, nfalta;
        Scanner captura = new Scanner(System.in);

        while (cadastra) {

            System.out.println("1 - Cadastrar Aluno"
                    + "\n2 - Cadastrar Disciplina"
                    + "\n3 - Consultar Aluno"
                    + "\n4 - Consultar Disciplina"
                    + "\n5 - Sair");

            int op = captura.nextInt();

            switch (op) {
                case 1:
                    try {
                        System.out.println("Digite seu nome \n [minimo de 5 maximo de 300 letras]");
                        nome = captura.next();
                        System.out.println("Digite o nome do curso \n [minimo de 5 maximo de 300 letras]");
                        curso = captura.next();
                        System.out.println("Digite sua matricula \n [Deve conter 8 numeros]");
                        matricula = captura.next();

                        validacao = new ValidaLetras(nome);

                        ValidacaoChain.v = validacao;
                        vletras = new ValidaLetras(curso);
                        validacao.setNext(vletras);
                        vnumero = new ValidaNumeros(matricula);
                        validacao.setNext(vnumero);
                        validacao.buscaValidacao(validacao);


                        f.cadastraAluno(nome, curso, matricula);

                    } catch (ValidaException ex) {
                        System.err.println(ex.getMessage());
                    } catch (AlunoException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Digite o codigo da disciplina \n [Deve conter 8 numeros]:");
                        cod = captura.next();
                        System.out.println("Digite o nome da disciplina: \n [minimo de 5 maximo de 300 letras] ");
                        nomdis = captura.next();
                        System.out.println("Digite o nível de dificuldade[F,M,D]:");
                        nivel = captura.next();
                        System.out.println("Digite a carga horaria: \n [minimo de 20 maximo de 60 horas] ");
                        carga = captura.nextInt();
                        System.out.println("Digite o metodo de avaliação[P,T]:");
                        metodo = captura.next();
                        System.out.println("Digite o numero de faltas: \n [minimo de 1 maximo de 30 faltas]");
                        nfalta = captura.nextInt();
                        System.out.println("Digite a bibliografia do curso:");
                        bib = captura.next();
                        System.out.println("Digite a ementa do curso:");
                        ementa = captura.next();
                        
                        validacao = new ValidaNumeros(cod);

                        ValidacaoChain.v = validacao;
                        vletras = new ValidaLetras(nomdis);
                        validacao.setNext(vletras);
                        vnome = new ValidaNomeIgual(nivel,"F", "M", "D");
                        validacao.setNext(vnome);
                        vintervalo = new ValidaIntervalo(carga,20,60);
                        validacao.setNext(vintervalo);
                        vnome = new ValidaNomeIgual(metodo, "P", "T", "T");
                        validacao.setNext(vnome);
                        vintervalo = new ValidaIntervalo(nfalta,1,30);
                        validacao.setNext(vintervalo);
                        vtexto = new ValidaTexto(bib);
                        validacao.setNext(vtexto);
                        vtexto = new ValidaTexto(ementa);
                        validacao.setNext(vtexto);
                        validacao.buscaValidacao(validacao);                       
                        
                        f.cadastraDis(cod, nomdis, nivel, carga, metodo, nfalta, bib, ementa);
                    } catch (DisciplinaException e) {
                        System.err.println(e.getMessage());
                    } catch (ValidaException e) {
                        System.err.println(e.getMessage());
                    }


                    break;

                case 3:
                    try {
                        System.out.println("Digite a matricula do aluno");
                        matricula = captura.next();
                        f.consultaAlunos(matricula);
                    } catch (AlunoException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:
                    try {
                        System.out.println("Digite o codigo da disciplina:");
                        cod = captura.next();
                        f.consultaDis(cod);
                    } catch (DisciplinaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:

                    cadastra = false;
                    break;

            }//fim do swhich

        }//fim do while 


    }
}
