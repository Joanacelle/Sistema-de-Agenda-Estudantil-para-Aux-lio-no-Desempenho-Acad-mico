package gui;

import excecoes.ValidaException;

public abstract class ValidacaoChain {

    protected ValidacaoChain next;
    protected IDvalidacao identificador;
    static ValidacaoChain v = null;

    public ValidacaoChain(IDvalidacao id) {

        next = null;
        identificador = id;
    }

    public void setNext(ValidacaoChain nex) {

        if (next == null) {
            next = nex;

        } else {
            next.setNext(nex);

        }

    }

    public void buscaValidacao(ValidacaoChain validacao) throws ValidaException {

        v = validacao;

        if (validacao != null) {
            if (atendeValidacao()) {
                buscaValidacao(v.next);
            } else {
                throw new ValidaException("Validação não efetuada");
            }

        }

    }

    public enum IDvalidacao {

        validaLetras, validaNumeros, validaNomeIgual,
        validaIntervalo, validaTexto
    }

    protected abstract boolean atendeValidacao();
}