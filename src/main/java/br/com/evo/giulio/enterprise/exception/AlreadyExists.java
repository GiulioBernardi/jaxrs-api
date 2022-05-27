package br.com.evo.giulio.enterprise.exception;

public class AlreadyExists extends RuntimeException{

    private static final long serialVersionUID = 4098651272644591534L;

    public AlreadyExists(String mensagem) {
        super(mensagem);
    }

}
