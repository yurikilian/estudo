package kilian.solutions.aplicacao.exception;

public class ApplicationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Exception exception) {
        super("Falha na aplicacao: " + exception.getMessage(), exception.getCause());
    }
}
