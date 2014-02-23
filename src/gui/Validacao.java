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

    public boolean validaNomeIgual(String igual, String a, String b, String c) {

        if ((igual.equalsIgnoreCase(a)) || (igual.equalsIgnoreCase(b)) || (igual.equalsIgnoreCase(c))) {

            return true;

        }

        return false;
    }

    public boolean validaIntervalo(int numero, int minimo, int maximo) {

        if ((numero >= minimo) && (numero <= maximo)) {

            return true;
        }

        return false;
    }

    public boolean validaTexto(String texto) {

        if (texto.length() < 200) {

            return true;
        }

        return false;
    }
}
