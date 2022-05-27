package br.com.evo.giulio.enterprise.exception;

import br.com.evo.giulio.enterprise.model.ErroMensagem;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AlreadyExistsExceptionMapper implements ExceptionMapper<AlreadyExists> {

    @Override
    public Response toResponse(AlreadyExists exception) {
        ErroMensagem erroMensagem = new ErroMensagem(exception.getMessage(), 409, "Link para a documentação");
        return Response.status(Response.Status.CONFLICT).entity(erroMensagem).build();
    }
}
