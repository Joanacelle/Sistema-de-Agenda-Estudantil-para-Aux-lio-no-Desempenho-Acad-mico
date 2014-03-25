/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import excecoes.ValidaException;

/**
 *
 * @author Joanacelle
 */
public class ValidaLetras extends ValidacaoChain {

    int i;
    private String letras;

    public ValidaLetras(String letras) throws ValidaException {

        super(IDvalidacao.validaLetras);
        this.letras = letras;

    }

    @Override
    protected boolean atendeValidacao() {

        if ((letras.length() > 5) && (letras.length() < 300)) {

            for (i = 0; i < letras.length(); i++) {

                if (Character.isDigit(letras.charAt(i))) {

                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
