/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Joanacelle
 */
public class ValidaTexto extends ValidacaoChain {

    private String texto;

    public ValidaTexto(String texto) {

        super(IDvalidacao.validaTexto);
        this.texto = texto;
    }

    @Override
    protected boolean atendeValidacao() {
        if (texto.length() < 200) {

            return true;
        }

        return false;
    }
}
