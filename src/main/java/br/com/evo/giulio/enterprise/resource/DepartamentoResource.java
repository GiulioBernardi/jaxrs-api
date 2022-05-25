package br.com.evo.giulio.enterprise.resource;

import br.com.evo.giulio.enterprise.model.Departamento;
import br.com.evo.giulio.enterprise.service.DepartamentoService;
import br.com.evo.giulio.enterprise.service.impl.DepartamentoServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("departamentos")
public class DepartamentoResource {
    DepartamentoServiceImpl departamentoService1 = DepartamentoServiceImpl.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Departamento> listar(){
        return departamentoService1.logicalList();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addDepartamento(Departamento departamento) {
        departamentoService1.inserir(departamento);
    }

    @PUT
    @Path("/{departamentoId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateDepto(@PathParam("departamentoId") Long departamentoId, Departamento departamento){
        departamento.setId(departamentoId);
        departamentoService1.atualizar(departamento);
    }

    @GET
    @Path("/{departamentoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Departamento obter(@PathParam("departamentoId") Long id){
        return departamentoService1.obter(id);
    }

    @DELETE
    @Path("/{departamentoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remover(@PathParam("departamentoId") Long id){
        departamentoService1.logicalDelete(id);
    }
}