package gui;

import excecoes.ValidaException;

public class Validacao {

    int i;

    public boolean validaLetras(String letras) throws ValidaException {

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

    public boolean validaNumeros(String numeros) throws ValidaException {

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
