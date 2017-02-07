package kilian.solutions.aplicacao.exception;

public class FactoryNotFoundException extends ApplicationException {
    private static final long serialVersionUID = 1L;

    public FactoryNotFoundException(String tipo) {
        super("Fábrica de processadores não encontrada: " + tipo);
    }
}
