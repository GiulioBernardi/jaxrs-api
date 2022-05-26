package br.com.evo.giulio.enterprise.exception;

import br.com.evo.giulio.enterprise.model.ErroMensagem;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFound> {

    @Override
    public Response toResponse(NotFound exception) {
        ErroMensagem errorMessage = new ErroMensagem (exception.getMessage(), 404, "link para a documentação");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}
