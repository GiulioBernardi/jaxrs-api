package br.com.evo.giulio.enterprise.resource;

import br.com.evo.giulio.enterprise.model.Departamento;
import br.com.evo.giulio.enterprise.service.DepartamentoService;
import br.com.evo.giulio.enterprise.service.impl.DepartamentoServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("departamentos")
public class DepartamentoResource {
    DepartamentoServiceImpl departamentoService = DepartamentoServiceImpl.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Departamento> listar(){
        return departamentoService.logicalList();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addDepartamento(Departamento departamento) {
        departamentoService.inserir(departamento);
    }

    @PUT
    @Path("/{departamentoId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateDepto(@PathParam("departamentoId") Long departamentoId, Departamento departamento){
        departamento.setId(departamentoId);
        departamentoService.atualizar(departamento);
    }

    @GET
    @Path("/{departamentoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Departamento obter(@PathParam("departamentoId") Long id){
        return departamentoService.obter(id);
    }

    @DELETE
    @Path("/{departamentoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remover(@PathParam("departamentoId") Long id){
        departamentoService.logicalDelete(id);
    }
}