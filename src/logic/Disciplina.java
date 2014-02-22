/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Joanacelle
 */
public class Disciplina {
    
    private String codigo;
    private String nome;
    private String nivel;
    private int cargaHoraria;
    private String metodoAvaliacao;
    private int falta;
    private String bibliiografia;
    private String ementa;
        
    public Disciplina(String codigo,String nome, String nivel, int carga,
    String metodo,int falta,String bib, String ementa){
    
        this.codigo = codigo;
        this.nome = nome;
        this.nivel = nivel;
        this.cargaHoraria = carga;
        this.metodoAvaliacao = metodo;
        this.falta = falta;
        this.bibliiografia = bib;
        this.ementa = ementa;
        
     }

    public String getNome() {
        return nome;
    }

    public String getNivel() {
        return nivel;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String getMetodoAvaliacao() {
        return metodoAvaliacao;
    }

    public int getFalta() {
        return falta;
    }

    public String getBibliiografia() {
        return bibliiografia;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setMetodoAvaliacao(String metodoAvaliacao) {
        this.metodoAvaliacao = metodoAvaliacao;
    }

    public void setFalta(int falta) {
        this.falta = falta;
    }

    public void setBibliiografia(String bibliiografia) {
        this.bibliiografia = bibliiografia;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
     }
