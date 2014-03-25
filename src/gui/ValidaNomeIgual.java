/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Joanacelle
 */
public class ValidaNomeIgual extends ValidacaoChain {

    private String igual, a, b, c;

    public ValidaNomeIgual(String igual, String a, String b, String c) {

        super(IDvalidacao.validaNomeIgual);
        this.igual = igual;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    protected boolean atendeValidacao() {

        if ((igual.equalsIgnoreCase(a)) || (igual.equalsIgnoreCase(b)) || (igual.equalsIgnoreCase(c))) {

            return true;
        }

        return false;
    }
}
