/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Joanacelle
 */
public class ValidaIntervalo extends ValidacaoChain {

    private int numero, minimo, maximo;

    public ValidaIntervalo(int numero, int minimo, int maximo) {

        super(IDvalidacao.validaIntervalo);
        this.numero = numero;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    @Override
    protected boolean atendeValidacao() {
        if ((numero >= minimo) && (numero <= maximo)) {

            return true;
        }

        return false;
    }
}
