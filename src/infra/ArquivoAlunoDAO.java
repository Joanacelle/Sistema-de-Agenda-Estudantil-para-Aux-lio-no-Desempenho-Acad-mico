/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import Logic.Aluno;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Joanacelle
 */
public class ArquivoAlunoDAO implements AlunoDAO <Aluno>{

    private DataOutputStream output;
    private DataInputStream input;
    private boolean moreRecords = true;
    private static ArquivoAlunoDAO p = null;

    private ArquivoAlunoDAO() {
    }

    public synchronized static ArquivoAlunoDAO getInstance() {

        if (p == null) {
            p = new ArquivoAlunoDAO();
        }

        return p;

    }
    
    public Aluno get(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void cadastrar(Aluno aluno) {

        try {
            output = new DataOutputStream(new FileOutputStream("aluno.dat", false));

            //for (Aluno a : listaAluno) {
            output.writeUTF(aluno.getNomeAluno());
            output.writeUTF(aluno.getNomeCurso());
            output.writeUTF(aluno.getMatricula());

            // }

            output.flush();
            output.close();

        } catch (IOException e) {
            System.err.println("Erro durante gravação no arquivo\n" + e.toString());
            System.exit(1);
        }


    }

    public Aluno consultar(Aluno aluno) {

        try {
            input = new DataInputStream(new FileInputStream("aluno.dat"));
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Leitura\n" + e.toString());
            System.exit(1);
        }

        String nomeAluno;
        String nomeCurso;
        String matricula;
        try {
            while (moreRecords) {

                nomeAluno = input.readUTF();
                nomeCurso = input.readUTF();
                matricula = input.readUTF();

                if (aluno.getMatricula().equals(matricula)) {
                    return new Aluno(nomeAluno, nomeCurso, matricula);
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
