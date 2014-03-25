/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Joanacelle
 */
public class ValidaNumeros extends ValidacaoChain {

    int i;
    private String numeros;

    public ValidaNumeros(String numeros) {

        super(IDvalidacao.validaNumeros);
        this.numeros = numeros;
    }

    @Override
    protected boolean atendeValidacao() {
        
        if ((numeros.length() == 8)) {

            for (i = 0; i < numeros.length(); i++) {

                if (!(Character.isDigit(numeros.charAt(i)))) {

                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
