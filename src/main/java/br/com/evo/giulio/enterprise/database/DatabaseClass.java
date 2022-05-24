package br.com.evo.giulio.enterprise.database;

import br.com.evo.giulio.enterprise.model.Departamento;
import br.com.evo.giulio.enterprise.model.Funcionario;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
//TODO delete this class
    private static Map<Long, Departamento> departamentos = new HashMap<>();
    private static Map<Long, Funcionario> funcionarios = new HashMap<>();

    public static Map<Long, Departamento> getDepartamentos(){
        return departamentos;
    }

    public static Map<Long, Funcionario> getFuncionarios(){
        return funcionarios;
    }


}
