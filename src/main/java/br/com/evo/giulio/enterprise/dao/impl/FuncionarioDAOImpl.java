package br.com.evo.giulio.enterprise.dao.impl;

import br.com.evo.giulio.enterprise.model.Funcionario;

public class FuncionarioDAOImpl extends HibernateGenericDAO<Funcionario, Long>{

    private static FuncionarioDAOImpl instance = null;

    public static FuncionarioDAOImpl getInstance(){
        if(instance == null){
            instance = new FuncionarioDAOImpl();
        }
        return instance;
    }

    public FuncionarioDAOImpl() {
        super(Funcionario.class);
    }
}
