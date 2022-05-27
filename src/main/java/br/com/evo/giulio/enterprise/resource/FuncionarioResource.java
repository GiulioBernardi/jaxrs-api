package br.com.evo.giulio.enterprise.resource;

import br.com.evo.giulio.enterprise.model.Funcionario;
import br.com.evo.giulio.enterprise.service.impl.FuncionarioServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;

@Path("funcionarios")
public class FuncionarioResource {
    FuncionarioServiceImpl funcionarioService = FuncionarioServiceImpl.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Funcionario> listar(){
        return funcionarioService.logicalList();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionar(Funcionario funcionario, @Context UriInfo uriInfo) {
        Funcionario novoFuncionario = funcionarioService.inserir(funcionario);
        String novoId = String.valueOf(novoFuncionario.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(novoId).build();
        return Response.created(uri).entity(novoFuncionario).build();
    }

    @PUT
    @Path("/{funcionarioId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("funcionarioId") Long funcionarioId, Funcionario funcionario, @Context UriInfo uriInfo){
        funcionario.setId(funcionarioId);
        Funcionario funcionarioAtualizado = funcionarioService.atualizar(funcionario);
        String id = String.valueOf(funcionarioAtualizado.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
        return Response.ok(uri).entity(funcionarioAtualizado).build();
    }

    @GET
    @Path("/{funcionarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Funcionario obter(@PathParam("funcionarioId") Long id){
        return funcionarioService.obter(id);
    }

    @DELETE
    @Path("/{funcionarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remover(@PathParam("funcionarioId") Long id){
        funcionarioService.logicalDelete(id);
    }

}
