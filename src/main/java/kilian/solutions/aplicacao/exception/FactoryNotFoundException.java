package kilian.solutions.aplicacao.exception;

public class FactoryNotFoundException extends ApplicationException {
    private static final long serialVersionUID = 1L;

    public FactoryNotFoundException(String tipo) {
        super("F�brica de processadores n�o encontrada: " + tipo);
    }
}
