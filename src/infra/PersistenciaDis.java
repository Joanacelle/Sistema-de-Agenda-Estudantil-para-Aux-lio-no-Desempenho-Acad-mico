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
public class PersistenciaDis {
    
   
    LinkedList<Disciplina> listaDisciplina = new LinkedList<>();
    private DataOutputStream output;
    private DataInputStream input;
    private boolean moreRecords = true;
        
    public PersistenciaDis() {
        setupLer();
        readRecords();
        cleanupLer();
       //System.err.println("Entrei na Leitura\n" );
    }
        
    public void setupLer() {
        //Abre arquivo para leitura
        try {
            input = new DataInputStream(new FileInputStream("agenda.dat"));
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Leitura\n" + e.toString());
            System.exit(1);
        }
        
    } 
    public void readRecords() {
//Carrega todo o conteúdo do arquivo na Coleção agenda
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
                                
                listaDisciplina.add(new Disciplina(codigo, nome,nivel,
                        Integer.parseInt(cargaHoraria),metodoAvaliacao,Integer.parseInt(faltas),
                        bibliografia,ementa));
               
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
            output = new DataOutputStream(new FileOutputStream("agenda.dat", false));
        } catch (IOException e) {
            System.err.println("Falha na Abertura do Arquivo para Gravação\n" + e.toString());
            System.exit(1);
        }
    }

    public void addRecords() {
        //Carrega toda a coleção no arquivo
        try {
            for (Disciplina a : listaDisciplina) {
                output.writeUTF(a.getCodigo());
                output.writeUTF(a.getNome());
                output.writeUTF(a.getNivel());
                output.writeUTF(""+a.getCargaHoraria());
                output.writeUTF(a.getMetodoAvaliacao());
                output.writeUTF(""+a.getFalta());
                output.writeUTF(a.getBibliiografia());
                output.writeUTF(a.getEmenta());
            }
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
    public void GravandoDis(){
        //System.err.println("Entrei Pra gravar\n" );
        setupGravar();
        addRecords();
        cleanupGravar(); //grava dados, fecha arquivo
                
        
    } 
    
    
}
