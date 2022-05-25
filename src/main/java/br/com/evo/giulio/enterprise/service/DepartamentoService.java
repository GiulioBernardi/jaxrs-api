package br.com.evo.giulio.enterprise.service;

import br.com.evo.giulio.enterprise.database.DatabaseClass;
import br.com.evo.giulio.enterprise.model.Departamento;

import java.beans.DefaultPersistenceDelegate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//TODO delete this class
public class DepartamentoService {

//    public DepartamentoService(){
//        departamentos.put(1L, new Departamento(1l, "Desenvolvimento", "dev"));
//        departamentos.put(2L, new Departamento(2l, "Financeiro", "fin"));
//        departamentos.put(3L, new Departamento(3l, "Juridico", "jur"));
//    }

    private Map<Long, Departamento> departamentos = DatabaseClass.getDepartamentos();

    public List<Departamento> getAllDeptos(){
        return new ArrayList<Departamento>(departamentos.values());
    }

    public Departamento getDepartamento(Long id){
        return departamentos.get(id);
    }

    public Departamento addDepartamento(Departamento departamento){
        departamento.setId(departamentos.size() + 1l);
        departamentos.put(departamento.getId(), departamento);
        return departamento;
    }

    public Departamento updateDepartamento(Departamento departamento){
        if(departamento.getId() <= 0) {
            return null;
        }
        departamentos.put(departamento.getId(), departamento);
        return departamento;
    }

    public Departamento removeDepartamento(Long id){
        return departamentos.remove(id);
    }


}


