package br.com.evo.giulio.enterprise.exception;

public class NotFound extends RuntimeException{
    private static final long serialVersionUID = 3422366044490549448L;



    public NotFound(String mensagem) {
        super(mensagem);
    }
}
