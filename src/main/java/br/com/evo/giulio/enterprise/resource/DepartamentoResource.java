package br.com.evo.giulio.enterprise.resource;

import br.com.evo.giulio.enterprise.model.Departamento;
import br.com.evo.giulio.enterprise.service.DepartamentoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("departamentos")
public class DepartamentoResource {
    DepartamentoService departamentoService = new DepartamentoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Departamento> listar(){
        return departamentoService.getAllDeptos();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Departamento addDepartamento(Departamento departamento) {
        return departamentoService.addDepartamento(departamento);
    }

    @GET
    @Path("/{departamentoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Departamento test(@PathParam("departamentoId") Long departamentoId){
        return departamentoService.getDepartamento(departamentoId);
    }




}

