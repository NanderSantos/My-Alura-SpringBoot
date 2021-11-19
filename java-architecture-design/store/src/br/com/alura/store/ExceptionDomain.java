package br.com.alura.store;

public class ExceptionDomain extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExceptionDomain(String message) {
        super(message);
    }
}
