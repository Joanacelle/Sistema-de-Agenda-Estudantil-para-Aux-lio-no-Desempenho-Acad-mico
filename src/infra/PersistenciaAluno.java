/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Infra;

import Logic.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Joanacelle
 */
public class PersistenciaAluno {

    private Aluno alu;
    private DataOutputStream output;
    private DataInputStream input;
    private boolean moreRecords = true;
    private static PersistenciaAluno p = null;

    private PersistenciaAluno() {

        setupLer();
        readRecords();
        cleanupLer();
        //System.err.println("Entrei na Leitura\n" );
    }

    public synchronized static PersistenciaAluno getInstance() {

        if (p == null) {
            p = new PersistenciaAluno();
        }

        return p;

    }

    public void setupLer() {
        //Abre arquivo para leitura
        try {
            input = new DataInputStream(new FileInputStream("aluno.dat"));
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Leitura\n" + e.toString());
            System.exit(1);
        }

    }

    public void readRecords() {

        String nomeAluno;
        String nomeCurso;
        String matricula;
        try {
            while (moreRecords) {

                nomeAluno = input.readUTF();
                nomeCurso = input.readUTF();
                matricula = input.readUTF();

                alu = new Aluno(nomeAluno, nomeCurso, matricula);

            }
        } catch (EOFException eof) {
            moreRecords = false;
        } catch (IOException e) {
            System.err.println("Erro durante leitura do arquivo\n" + e.toString());
            System.exit(1);
        }
    }

    public void cleanupLer() {
        //Fechar o arquivo, após ter sido descarregado na coleção
        try {
            input.close();
        } catch (IOException e) {
            System.err.println("Falha no Fechamento do Arquivo durante Leitura\n" + e.toString());
            System.exit(1);
        }
    }

    public void setupGravar() {
        //Abre arquivo para gravar
        try {
            output = new DataOutputStream(new FileOutputStream("aluno.dat", false));
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Gravação\n" + e.toString());
            System.exit(1);
        }
    }

    public void addRecords() {
        //Carrega toda a coleção no arquivo
        try {

            output.writeUTF(alu.getNomeAluno());
            output.writeUTF(alu.getNomeCurso());
            output.writeUTF(alu.getMatricula());

        } catch (IOException e) {
            System.err.println("Erro durante gravação no arquivo\n" + e.toString());
            System.exit(1);
        }
    }

    public void cleanupGravar() {
        try {
            output.flush();
            output.close();
        } catch (IOException e) {
            System.err.println("Falha no Fechamento do Arquivo - Durante Gravação!!\n" + e.toString());
            System.exit(1);
        }
    }

    public void GravandoAluno() {
        //System.err.println("Entrei Pra gravar\n" );
        setupGravar();
        addRecords();
        cleanupGravar(); //grava dados, fecha arquivo


    }
}
