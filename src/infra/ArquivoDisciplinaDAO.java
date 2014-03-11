/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import Logic.Disciplina;
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
public class ArquivoDisciplinaDAO implements DAO<Disciplina> {

    private DataOutputStream output;
    private DataInputStream input;
    private boolean moreRecords = true;
    private static ArquivoDisciplinaDAO p = null;

    private ArquivoDisciplinaDAO() {
    }

    public synchronized static ArquivoDisciplinaDAO getInstance() {

        if (p == null) {
            p = new ArquivoDisciplinaDAO();
        }

        return p;

    }

    public void cadastrar(Disciplina disciplina) {

        try {

            output = new DataOutputStream(new FileOutputStream("agenda.dat", false));

            //for (Disciplina a : listaDisciplina) {
            output.writeUTF(disciplina.getCodigo());
            output.writeUTF(disciplina.getNome());
            output.writeUTF(disciplina.getNivel());
            output.writeUTF("" + disciplina.getCargaHoraria());
            output.writeUTF(disciplina.getMetodoAvaliacao());
            output.writeUTF("" + disciplina.getFalta());
            output.writeUTF(disciplina.getBibliiografia());
            output.writeUTF(disciplina.getEmenta());
            //}

            output.flush();
            output.close();
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Gravação\n" + e.toString());
            System.exit(1);
        }
    }

    public Disciplina consultar(String cod) {

        try {
            input = new DataInputStream(new FileInputStream("agenda.dat"));
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Leitura\n" + e.toString());
            System.exit(1);
        }

        String codigo;
        String nome;
        String nivel;
        String cargaHoraria;
        String metodoAvaliacao;
        String faltas;
        String bibliografia;
        String ementa;

        try {
            while (moreRecords) {

                codigo = input.readUTF();
                nome = input.readUTF();
                nivel = input.readUTF();
                cargaHoraria = input.readUTF();
                metodoAvaliacao = input.readUTF();
                faltas = input.readUTF();
                bibliografia = input.readUTF();
                ementa = input.readUTF();

                if (cod.equals(codigo)) {
                    return new Disciplina(codigo, nome, nivel, Integer.parseInt(cargaHoraria),
                            metodoAvaliacao, Integer.parseInt(faltas), bibliografia, ementa);
                }

            }
            input.close();
        } catch (EOFException eof) {
            moreRecords = false;
        } catch (IOException e) {
            System.err.println("Erro durante leitura do arquivo\n" + e.toString());
            System.exit(1);
        }
        return null;


    }
}
