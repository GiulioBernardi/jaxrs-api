package br.com.evo.giulio.enterprise.dao.impl;

import br.com.evo.giulio.enterprise.model.Departamento;

public class DepartamentoDAOImpl extends HibernateGenericDAO<Departamento, Long> {

    private static DepartamentoDAOImpl instance = null;

    public static DepartamentoDAOImpl getInstance(){
        if(instance == null){
            instance = new DepartamentoDAOImpl();
        }
        return instance;
    }


    public DepartamentoDAOImpl() {
        super(Departamento.class);
    }



}
