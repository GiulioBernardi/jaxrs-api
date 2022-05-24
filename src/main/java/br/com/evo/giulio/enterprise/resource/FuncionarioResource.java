package br.com.evo.giulio.enterprise.resource;

import br.com.evo.giulio.enterprise.model.Departamento;
import br.com.evo.giulio.enterprise.model.Funcionario;
import br.com.evo.giulio.enterprise.service.impl.FuncionarioServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("funcionarios")
public class FuncionarioResource {
    FuncionarioServiceImpl funcionarioService = FuncionarioServiceImpl.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Funcionario> listar(){
        return funcionarioService.listar();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addDepartamento(Funcionario funcionario) {
        funcionarioService.inserir(funcionario);
    }

    @PUT
    @Path("/{funcionarioId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateDepto(@PathParam("funcionarioId") Long funcionarioId, Funcionario funcionario){
        funcionario.setId(funcionarioId);
        funcionarioService.atualizar(funcionario);
    }

    @GET
    @Path("/{funcionarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Funcionario obter(@PathParam("funcionarioId") Long id){
        return funcionarioService.obter(id);
    }

}
